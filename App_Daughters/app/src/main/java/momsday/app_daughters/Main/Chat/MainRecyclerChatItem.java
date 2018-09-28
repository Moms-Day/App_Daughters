package momsday.app_daughters.Main.Chat;

import java.util.Date;

public class MainRecyclerChatItem {
    String  messageText, timeText, dateText;
    Date date;
    private int itemViewType;

    public String getMessageText() {
        return messageText;
    }

    public String getTimeText() {
        return timeText;
    }

    public String getDateText() {
        return dateText;
    }

    public Date getDate() {
        return date;
    }

    public int getItemViewType() {
        return itemViewType;
    }

    MainRecyclerChatItem() { }

    MainRecyclerChatItem(int itemViewType, String messageText, String timeText, Date date) {
        this.itemViewType = itemViewType;
        this.messageText = messageText;
        this.timeText = timeText;
        this.date = date;
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
