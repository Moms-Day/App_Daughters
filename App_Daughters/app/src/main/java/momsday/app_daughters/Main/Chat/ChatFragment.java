package momsday.app_daughters.Main.Chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import momsday.app_daughters.R;

public class ChatFragment extends Fragment {
    public ChatFragment() {
    }

    RecyclerView mainChatListRecycler;
    LinearLayoutManager mainChatListLayoutManager;
    MainChatListRecyclerViewAdapter mainChatListRecyclerAdapter;
    private String careworkerName, facilityName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ConstraintLayout layout = (ConstraintLayout) inflater.inflate(R.layout.fragment_main_chat, container, false);

        SharedPreferences preferences = getContext().getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE);
        careworkerName = preferences.getString("careworkerName","");
        facilityName = preferences.getString("facilityName","");

        mainChatListRecycler = (RecyclerView)layout.findViewById(R.id.recycler_main_chat_list);
        mainChatListLayoutManager = new LinearLayoutManager(getContext());
        mainChatListLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ArrayList<MainRecyclerChatListItem> mainRecyclerChatListItems = new ArrayList();

        mainRecyclerChatListItems.add(new MainRecyclerChatListItem(careworkerName+"요양보호사님",""));
        mainRecyclerChatListItems.add(new MainRecyclerChatListItem(facilityName+"단체채팅방",""));

        mainChatListRecycler.setLayoutManager(mainChatListLayoutManager);
        mainChatListRecycler.setItemAnimator(new DefaultItemAnimator());

        mainChatListRecyclerAdapter = new MainChatListRecyclerViewAdapter(mainRecyclerChatListItems);
        mainChatListRecycler.setAdapter(mainChatListRecyclerAdapter);
        return layout;
    }
}
