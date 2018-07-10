package momsday.app_daughters.Main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import momsday.app_daughters.R;

public class MainChatListRecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView chatListNameText, chatListMessageText;
    public ImageView chatListProfileImage;

    public MainChatListRecyclerViewHolder(View itemView) {
        super(itemView);

        chatListNameText = (TextView)itemView.findViewById(R.id.text_chat_list_name);
        chatListMessageText = (TextView)itemView.findViewById(R.id.text_chat_list_message);
        chatListProfileImage = (ImageView)itemView.findViewById(R.id.image_chat_list_profile);
    }
}
