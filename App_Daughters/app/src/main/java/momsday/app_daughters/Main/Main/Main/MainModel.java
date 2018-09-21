package momsday.app_daughters.Main.Main.Main;

import com.google.gson.annotations.SerializedName;

public class MainModel {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
