package momsday.app_daughters.Main.Chat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;

import org.json.JSONObject;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import momsday.app_daughters.R;

public class ChatActivity extends AppCompatActivity {

    RecyclerView mainChatRecycler;
    LinearLayoutManager mainChatLayoutManager;
    MainChatRecyclerViewAdapter mainChatRecyclerAdapter;
    long now;
    int i = 0;
    Date nowDate, chatDate;
    SimpleDateFormat timeDateFormat, dateDateFormat;
    private String timeText, dateText, chatCode;
    private TextView sendBtn, careworkerNameText;
    private ArrayList<MainRecyclerChatItem> mainRecyclerChatItems;
    private EditText messageEdit;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        initTime();

        sendBtn = (TextView) findViewById(R.id.text_chat_send_message);
        messageEdit = (EditText) findViewById(R.id.edit_chat_message);
        careworkerNameText = (TextView) findViewById(R.id.text_chat_toolbar_careworker_name);

        Intent intent = getIntent();
        careworkerNameText.setText(intent.getStringExtra("chatName"));
        chatCode = intent.getStringExtra("chatCode");
        mainChatRecycler = (RecyclerView) findViewById(R.id.recycler_main_chat);
        mainChatLayoutManager = new LinearLayoutManager(this);
        mainChatLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mainRecyclerChatItems = new ArrayList();

        mainChatRecycler.setLayoutManager(mainChatLayoutManager);
        mainChatRecycler.setItemAnimator(new DefaultItemAnimator());

        mainChatRecyclerAdapter = new MainChatRecyclerViewAdapter(mainRecyclerChatItems);
        mainChatRecycler.setAdapter(mainChatRecyclerAdapter);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initTime();
                MainRecyclerChatItem chatData = new MainRecyclerChatItem(1, messageEdit.getText().toString(), timeText, nowDate);

                sendPostToFCM(messageEdit.getText().toString());

                databaseReference.child(chatCode).child("message").push().setValue(chatData);
                messageEdit.setText("");
            }
        });


        databaseReference.child(chatCode).child("message").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                MainRecyclerChatItem chatData = dataSnapshot.getValue(MainRecyclerChatItem.class);
                if (i == 0) {
                    chatDate = chatData.getDate();
                    mainRecyclerChatItems.add(new MainRecyclerChatItem(0, dateDateFormat.format(chatDate)));
                    i++;
                } else {
                    if (chatDate.compareTo(chatData.getDate()) < 0) {
                        chatDate = chatData.getDate();
                        mainRecyclerChatItems.add(new MainRecyclerChatItem(0, dateDateFormat.format(chatDate)));
                    }
                }


                if (chatData.getItemViewType() == 2) {
                    mainRecyclerChatItems.add(new MainRecyclerChatItem(2, chatData.getMessageText(), chatData.getTimeText()));
                    mainChatRecyclerAdapter.notifyDataSetChanged();
                    mainChatRecycler.smoothScrollToPosition(mainRecyclerChatItems.size() - 1);
                }
                if (chatData.getItemViewType() == 1) {
                    mainRecyclerChatItems.add(new MainRecyclerChatItem(1, chatData.getMessageText(), chatData.getTimeText()));
                    mainChatRecyclerAdapter.notifyDataSetChanged();
                    mainChatRecycler.smoothScrollToPosition(mainRecyclerChatItems.size() - 1);
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    private void sendPostToFCM(final String message) {

        final String[] careworkerToken = new String[1];
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE);
        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

        firebaseDatabase.getReference("users").child(preferences.getString("careworkerId","")).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                careworkerToken[0] = dataSnapshot.getValue().toString();
                Log.d("Debug","ㅠㅠㅠㅠㅠㅠㅠ   "+careworkerToken[0]);
                sendNotify(message,careworkerToken[0]);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void sendNotify(final String message, final String careworkerToken) {
        final String FCM_MESSAGE_URL = "https://fcm.googleapis.com/fcm/send";
        final String SERVER_KEY = "AAAA3AwqIjw:APA91bFUYswTxWgsFddoDI7LOen1w97GzIvhjM5y5OK-x0sgT2WLyE__W3XpRCiuYPAxj4fdQtoyO16e5vSwDiASbu2E-734PXfB9Bp5lsM3K0rV17atvYfs7LYXuawGwWwwRu5igpfh0JXzhLlzJ_VSf1pPus_F-Q";

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // FMC 메시지 생성 start
                    JSONObject root = new JSONObject();
                    JSONObject notification = new JSONObject();
                    notification.put("body", message);
                    notification.put("title", getString(R.string.app_name));
                    root.put("notification", notification);
                    root.put("to", careworkerToken);

                    Log.d("Debug","상대방토큰토큰토큰  "+careworkerToken);
                    // FMC 메시지 생성 end

                    URL Url = new URL(FCM_MESSAGE_URL);
                    HttpURLConnection conn = (HttpURLConnection) Url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setDoOutput(true);
                    conn.setDoInput(true);
                    conn.addRequestProperty("Authorization", "key=" + SERVER_KEY);
                    conn.setRequestProperty("Accept", "application/json");
                    conn.setRequestProperty("Content-type", "application/json");
                    OutputStream os = conn.getOutputStream();
                    os.write(root.toString().getBytes("utf-8"));
                    os.flush();
                    conn.getResponseCode();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    public void initTime() {
        now = System.currentTimeMillis();
        nowDate = new Date(now);
        timeDateFormat = new SimpleDateFormat("hh:mm");
        dateDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
        timeText = timeDateFormat.format(nowDate);
        dateText = dateDateFormat.format(nowDate);
    }
}
