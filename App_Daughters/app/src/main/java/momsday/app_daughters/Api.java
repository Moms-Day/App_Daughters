package momsday.app_daughters;


import com.google.gson.JsonObject;

import org.json.JSONObject;

import momsday.app_daughters.Main.Rank.RankEvaluateHospitalModel;
import momsday.app_daughters.Main.Rank.RankModel;
import momsday.app_daughters.RequestConnection.RequestConnectionModel;
import momsday.app_daughters.SignIn.SignInModel;
import momsday.app_daughters.SignUp.SignUpModel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {
    @POST("auth")
    @Headers("Content-Type: application/json")
    Call<JsonObject> doSignIn(@Body SignInModel signInModel);

    @POST("signup")
    @Headers("Content-Type: application/json")
    Call<Void> doSignUp(@Body SignUpModel signUpModel);

    @PATCH("evaluate/facility/{facility_code}")
    @Headers("Content-Type: application/json")
    Call<Void> evaluateHospital(@Path("facility_code") String facilityCode,
                                @Header("Authorization") String Authorization,
                                @Body RankEvaluateHospitalModel rankEvaluateHospitalModel);

    @POST("connect/request")
    @Headers("Content-Type: application/json")
    Call<Void> requestConnection(@Header("Authorization") String Authorization,
                                 @Body RequestConnectionModel requestConnectionModel);

    @GET("connect/search")
    @Headers("Content-Type: application/json")
    Call<ResponseBody> searchHospital(@Header("Authorization") String Authorization,
                                    @Query("facilityName") String facilityName);
}
