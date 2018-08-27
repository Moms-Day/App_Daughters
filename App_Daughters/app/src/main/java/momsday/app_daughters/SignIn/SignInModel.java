package momsday.app_daughters.SignIn;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

import momsday.app_daughters.Api;
import momsday.app_daughters.ApiClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

