package momsday.app_daughters;


import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import momsday.app_daughters.CareworkerInformation.CareworkerInformationModel;
import momsday.app_daughters.HospitalInformation.HospitalInformationModel;
import momsday.app_daughters.Main.Rank.RankCareworker.RankCareworkerModel;
import momsday.app_daughters.Main.Rank.RankEvaluteCareworker.RankEvaluateCareworkerModel;
import momsday.app_daughters.Main.Rank.RankEvaluateHospital.RankEvaluateHospitalModel;
import momsday.app_daughters.Main.Rank.RankHospital.RankHospitalModel;
import momsday.app_daughters.RequestConnection.RequestConnectionModel;
import momsday.app_daughters.SearchHospital.SearchHospitalModel;
import momsday.app_daughters.SignIn.SignInModel;
import momsday.app_daughters.SignUp.SignUpModel;
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

    @GET("ranking/care_worker")
    @Headers("Content-Type: application/json")
    Call<RankCareworkerModel> rankCareworker(@Header("Authorization") String Authorization);

    @GET("ranking/facility")
    @Headers("Content-Type: application/json")
    Call<RankHospitalModel> rankHospital(@Header("Authorization") String Authorization);

    @POST("connect/request")
    @Headers("Content-Type: application/json")
    Call<Void> requestConnection(@Header("Authorization") String Authorization,
                                 @Body RequestConnectionModel requestConnectionModel);

    @GET("connect/search")
    @Headers("Content-Type: application/json")
    Call<ArrayList<SearchHospitalModel>> searchHospital(@Header("Authorization") String Authorization,
                                                        @Query("facilityName") String facilityName);

    @GET("info/care_worker/{care_worker_id}")
    @Headers("Content-Type: application/json")
    Call<CareworkerInformationModel> careworkerInform(@Path("care_worker_id") String careworkerId);

    @GET("info/facility/{facility_code}")
    @Headers("Content-Type: application/json")
    Call<HospitalInformationModel> hospitalInform(@Path("facility_code")String facilityCode);

    @PATCH("evaluate/facility/{facility_code}")
    @Headers("Content-Type: application/json")
    Call<Void> evaluateHospital(@Path("facility_code") String facilityCode,
                                @Header("Authorization") String Authorization,
                                @Body RankEvaluateHospitalModel rankEvaluateHospitalModel);

    @PATCH("evaluate/care_worker/{care_worker_id}")
    @Headers("Content-Type: application/json")
    Call<Void> evaluateCareworker(@Path("care_worker_id") String careworkerId,
                                @Header("Authorization") String Authorization,
                                @Body RankEvaluateCareworkerModel rankEvaluateCareworkerModel);


}
