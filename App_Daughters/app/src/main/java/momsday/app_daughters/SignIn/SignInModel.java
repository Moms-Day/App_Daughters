package momsday.app_daughters.SignIn;

import com.google.gson.annotations.SerializedName;

public class SignInModel {
    @SerializedName("id")
    private String id;
    @SerializedName("pw")
    private String pw;

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}

