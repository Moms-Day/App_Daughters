package momsday.app_daughters.Main.Chat;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import momsday.app_daughters.R;

public class MainChatRecyclerMeViewHolder extends RecyclerView.ViewHolder {
    public TextView chatMessageText, chatTimeText;

    public MainChatRecyclerMeViewHolder(View itemView) {
        super(itemView);

        chatMessageText = (TextView)itemView.findViewById(R.id.chat_my_message);
        chatTimeText = (TextView)itemView.findViewById(R.id.chat_my_time);
    }
}
