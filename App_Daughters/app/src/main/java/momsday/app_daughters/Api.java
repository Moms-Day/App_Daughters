package momsday.app_daughters;


import org.json.JSONObject;
import momsday.app_daughters.SignIn.SignInModel;
import momsday.app_daughters.SignUp.SignUpModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {

    @POST("signup")
    @Headers("Content-Type: application/json")
    Call<Void> doSignUp(@Body SignUpModel signUpModel);

    @POST("auth")
    @Headers("Content-Type: application/json")
    Call<Void> doSignIn(@Body SignInModel signInModel);

}
