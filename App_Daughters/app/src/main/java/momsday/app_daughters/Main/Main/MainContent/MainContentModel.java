package momsday.app_daughters.Main.Main.MainContent;

import com.google.gson.annotations.SerializedName;

import momsday.app_daughters.Main.Main.MainContent.Form;

public class MainContentModel {
    @SerializedName("2days_ago")
    private Form twoDaysAgoForm;

    @SerializedName("today")
    private Form today;

    @SerializedName("yesterday")
    private Form yesterday;

    public Form getToday() {
        return today;
    }

    public Form getTwoDaysAgoForm() {
        return twoDaysAgoForm;
    }

    public Form getYesterday() {
        return yesterday;
    }
}
