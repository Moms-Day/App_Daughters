package momsday.app_daughters.Main;

import android.media.Image;

public class MainRecyclerChatListItem {
    String nameText, messageText;
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

    public MainRecyclerChatListItem(String nameText, String messageText) {
        this.nameText = nameText;
        this.messageText = messageText;
    }

}
