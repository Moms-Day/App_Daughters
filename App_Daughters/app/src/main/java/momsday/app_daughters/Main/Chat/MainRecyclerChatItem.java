package momsday.app_daughters.Main.Chat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainRecyclerChatItem {
    String nameText, messageText, timeText, dateText;
    private int itemViewType;

    public String getNameText() {
        return nameText;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getTimeText() {
        return timeText;
    }

    public String getDateText() {
        return dateText;
    }

    public int getItemViewType() {
        return itemViewType;
    }

    MainRecyclerChatItem(int itemViewType, String nameText, String messageText, String timeText) {
        this.itemViewType = itemViewType;
        this.nameText = nameText;
        this.messageText = messageText;
        this.timeText = timeText;
    }

    MainRecyclerChatItem(int itemViewType, String messageText, String timeText) {
        this.itemViewType = itemViewType;
        this.messageText = messageText;
        this.timeText = timeText;
    }

    MainRecyclerChatItem(int itemViewType, String dateText) {
        this.itemViewType = itemViewType;
        this.dateText = dateText;
    }
}
