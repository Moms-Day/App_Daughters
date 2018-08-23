package momsday.app_daughters;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("signup")
    @Headers("Content-Type: application/json")
    Call<Void> doSignUp(@Field("id") String id,
                        @Field("pw") String pw,
                        @Field("phoneNumber") String phoneNumber,
                        @Field("certifyCode") String certifyCode,
                        @Field("name") String name,
                        @Field("age") int age);



    @FormUrlEncoded
    @POST("signin")
    Call<JSONObject> doSignIn(@Field("id") String id,
                              @Field("pw") String pw);

}
