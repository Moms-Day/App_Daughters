package momsday.app_daughters.Main.Chat;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import momsday.app_daughters.R;

public class MainChatRecyclerDateViewHolder extends RecyclerView.ViewHolder {
    public TextView chatDateText;

    public MainChatRecyclerDateViewHolder(View itemView) {
        super(itemView);
        chatDateText = (TextView)itemView.findViewById(R.id.chat_date);
    }
}
