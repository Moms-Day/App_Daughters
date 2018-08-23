package momsday.app_daughters.SignIn;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import java.io.Serializable;

import momsday.app_daughters.Api;
import momsday.app_daughters.ApiClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInModel implements Serializable {

    private int responseCode;

    private Api api = ApiClient.getClient().create(Api.class);

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


    public int checkIdPw(String id, String pw) {
        this.id = id;
        this.pw = pw;
        api.doSignIn(id, pw).enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                if (response.code() == 201) {
                    responseCode = 201;
                } else if(response.code() == 409){
                    responseCode = 409;
                } else {
                    responseCode = 0;
                }
            }

            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {
                responseCode = 0;
            }
        });
        return responseCode;
    }
}
