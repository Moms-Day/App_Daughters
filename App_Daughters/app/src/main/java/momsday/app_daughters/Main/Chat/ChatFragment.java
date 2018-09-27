package momsday.app_daughters.Main.Chat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import momsday.app_daughters.R;
import momsday.app_daughters.RecyclerItemClickListener;

public class ChatFragment extends Fragment {
    public ChatFragment() {
    }

    private TextView messageText;
    private RecyclerView mainChatListRecycler;
    private LinearLayoutManager mainChatListLayoutManager;
    private MainChatListRecyclerViewAdapter mainChatListRecyclerAdapter;
    private String careworkerName, hospitalName, userId, careworkerId, hospitalCode;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private ArrayList<MainRecyclerChatListItem> mainRecyclerChatListItems;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ConstraintLayout layout = (ConstraintLayout) inflater.inflate(R.layout.fragment_main_chat, container, false);
        SharedPreferences preferences = getContext().getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE);
        careworkerName = preferences.getString("careworkerName", "");
        careworkerId = preferences.getString("careworkerId", "");
        userId = preferences.getString("id", "");
        hospitalName = preferences.getString("hospitalName", "");
        hospitalCode = preferences.getString("hospitalCode", "");

        mainChatListRecycler = (RecyclerView) layout.findViewById(R.id.recycler_main_chat_list);
        mainChatListLayoutManager = new LinearLayoutManager(getContext());
        mainChatListLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mainRecyclerChatListItems = new ArrayList();

        mainRecyclerChatListItems.add(new MainRecyclerChatListItem(careworkerName + " 요양보호사님", "",""));
        databaseReference.child(careworkerId+"AND"+userId).child("message").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                MainRecyclerChatItem chatData = dataSnapshot.getValue(MainRecyclerChatItem.class);
                mainRecyclerChatListItems.set(0,new MainRecyclerChatListItem(careworkerName+" 요양보호사님",chatData.getMessageText(),chatData.getTimeText()));
                mainChatListRecyclerAdapter.notifyDataSetChanged();
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
        mainRecyclerChatListItems.add(new MainRecyclerChatListItem(hospitalName + " 단체채팅방", "",""));
        databaseReference.child(hospitalCode).child("message").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                MainRecyclerChatItem chatData = dataSnapshot.getValue(MainRecyclerChatItem.class);
                mainRecyclerChatListItems.set(1,new MainRecyclerChatListItem(hospitalName+" 단체채팅방",chatData.getMessageText(),chatData.getTimeText()));
                mainChatListRecyclerAdapter.notifyDataSetChanged();
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


        mainChatListRecycler.setLayoutManager(mainChatListLayoutManager);
        mainChatListRecycler.setItemAnimator(new DefaultItemAnimator());

        mainChatListRecyclerAdapter = new MainChatListRecyclerViewAdapter(mainRecyclerChatListItems);
        mainChatListRecycler.setAdapter(mainChatListRecyclerAdapter);
        mainChatListRecycler.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), mainChatListRecycler, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(view.getContext(), ChatActivity.class);
                if (position == 0) {
                    intent.putExtra("chatName", careworkerName + "요양보호사님");
                    intent.putExtra("chatCode", careworkerId + "AND" + userId);
                } else if (position == 1) {
                    intent.putExtra("chatName", hospitalName);
                    intent.putExtra("chatCode", hospitalCode);
                }

                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
        return layout;
    }
}
