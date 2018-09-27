package momsday.app_daughters.Main.Chat;

import android.media.Image;

public class MainRecyclerChatListItem {
    String nameText, messageText,timeText;
    Image profileImage;

    public String getNameText() {
        return nameText;
    }
    public String getMessageText() {
        return messageText;
    }
    public Image getProfileImage() {
        return profileImage;
    }
    public String getTimeText() {
        return timeText;
    }

    public MainRecyclerChatListItem(String nameText, String messageText, String timeText) {
        this.nameText = nameText;
        this.messageText = messageText;
        this.timeText = timeText;
    }

}
