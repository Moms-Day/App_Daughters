package momsday.app_daughters.Main.Chat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import momsday.app_daughters.R;

public class ChatActivity extends AppCompatActivity {

    RecyclerView mainChatRecycler;
    LinearLayoutManager mainChatLayoutManager;
    MainChatRecyclerViewAdapter mainChatRecyclerAdapter;
    long now;
    Date nowDate;
    SimpleDateFormat timeDateFormat, dateDateFormat;
    String timeText, dateText, careworkerName;
    private TextView sendBtn, careworkerNameText;
    private ArrayList<MainRecyclerChatItem> mainRecyclerChatItems;
    private EditText messageEdit;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        now =  System.currentTimeMillis();
        nowDate = new Date(now);
        timeDateFormat = new SimpleDateFormat("hh:mm");
        dateDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
        timeText = timeDateFormat.format(nowDate);
        dateText = dateDateFormat.format(nowDate);
        sendBtn = (TextView) findViewById(R.id.text_chat_send_message);
        messageEdit = (EditText) findViewById(R.id.edit_chat_message);
        careworkerNameText = (TextView) findViewById(R.id.text_chat_toolbar_careworker_name);

        SharedPreferences preferences = getApplicationContext().getSharedPreferences("PREFERENCE",MODE_PRIVATE);
        careworkerName = preferences.getString("careworkerName","");

        careworkerNameText.setText(careworkerName);

        mainChatRecycler = (RecyclerView)findViewById(R.id.recycler_main_chat);
        mainChatLayoutManager = new LinearLayoutManager(this);
        mainChatLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mainRecyclerChatItems = new ArrayList();

        mainRecyclerChatItems.add(new MainRecyclerChatItem(0,dateText));

        mainChatRecycler.setLayoutManager(mainChatLayoutManager);
        mainChatRecycler.setItemAnimator(new DefaultItemAnimator());

        mainChatRecyclerAdapter = new MainChatRecyclerViewAdapter(mainRecyclerChatItems);
        mainChatRecycler.setAdapter(mainChatRecyclerAdapter);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainRecyclerChatItem chatData = new MainRecyclerChatItem(1,messageEdit.getText().toString(),timeText);
                mainRecyclerChatItems.add(chatData);
                mainChatRecyclerAdapter.notifyDataSetChanged();
                mainChatRecycler.smoothScrollToPosition(mainRecyclerChatItems.size() - 1);
                databaseReference.child("message").push().setValue(chatData);
                messageEdit.setText("");
            }
        });


        databaseReference.child("message").addChildEventListener(new ChildEventListener() {  // message는 child의 이벤트를 수신합니다.
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                MainRecyclerChatItem chatData = dataSnapshot.getValue(MainRecyclerChatItem.class);  // chatData를 가져오고
                if(chatData.getItemViewType() == 2) {
                    mainRecyclerChatItems.add(new MainRecyclerChatItem(2,chatData.getMessageText(),chatData.getTimeText()));
                    mainChatRecyclerAdapter.notifyDataSetChanged();
                    mainChatRecycler.smoothScrollToPosition(mainRecyclerChatItems.size() - 1);
                }
                if(chatData.getItemViewType() == 1) {
                    mainRecyclerChatItems.add(new MainRecyclerChatItem(1,chatData.getMessageText(),chatData.getTimeText()));
                    mainChatRecyclerAdapter.notifyDataSetChanged();
                    mainChatRecycler.smoothScrollToPosition(mainRecyclerChatItems.size() - 1);
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) { }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) { }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) { }

            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });
    }

}
