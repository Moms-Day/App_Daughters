package momsday.app_daughters.MyPage;

import com.google.gson.annotations.SerializedName;

public class WithdrawalModel {
    @SerializedName("pw")
    String pw;

    public void setPw(String pw) {
        this.pw = pw;
    }
}
