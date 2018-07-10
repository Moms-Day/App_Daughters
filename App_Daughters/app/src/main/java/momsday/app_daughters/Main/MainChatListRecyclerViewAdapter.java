package momsday.app_daughters.Main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import momsday.app_daughters.R;

public class MainChatListRecyclerViewAdapter extends RecyclerView.Adapter<MainChatListRecyclerViewHolder> {
    private ArrayList<MainRecyclerChatListItem> mainRecyclerChatListItems;
    Context mainRecyclerChatListContext;

    public MainChatListRecyclerViewAdapter(ArrayList itemList) {
        mainRecyclerChatListItems = itemList;
    }

    @NonNull
    @Override
    public MainChatListRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_recycler_chat_list, parent, false);
        mainRecyclerChatListContext = parent.getContext();
        MainChatListRecyclerViewHolder holder = new MainChatListRecyclerViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainChatListRecyclerViewHolder holder, int position) {
        holder.chatListNameText.setText(mainRecyclerChatListItems.get(position).nameText);
        holder.chatListMessageText.setText(mainRecyclerChatListItems.get(position).messageText);

        holder.
    }


    @Override
    public int getItemCount() {
        return mainRecyclerChatListItems.size();
    }
}
