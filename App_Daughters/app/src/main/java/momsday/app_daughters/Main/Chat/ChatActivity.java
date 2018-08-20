package momsday.app_daughters.Main.Chat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
    String timeText, dateText;

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


        mainChatRecycler = (RecyclerView)findViewById(R.id.recycler_main_chat);
        mainChatLayoutManager = new LinearLayoutManager(this);
        mainChatLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ArrayList<MainRecyclerChatItem> mainRecyclerChatItems = new ArrayList();

        mainRecyclerChatItems.add(new MainRecyclerChatItem(0,dateText));
        mainRecyclerChatItems.add(new MainRecyclerChatItem(1,"이종현",timeText));

        mainChatRecycler.setLayoutManager(mainChatLayoutManager);
        mainChatRecycler.setItemAnimator(new DefaultItemAnimator());

        mainChatRecyclerAdapter = new MainChatRecyclerViewAdapter(mainRecyclerChatItems);
        mainChatRecycler.setAdapter(mainChatRecyclerAdapter);

    }
}
