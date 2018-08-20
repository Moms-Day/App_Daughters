package momsday.app_daughters;

import momsday.app_daughters.SignIn.SignInModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

interface Api {
    //로그인
    @POST("/daughter/auth")
    @Headers("Content-Type: application/json")
    @FormUrlEncoded
    Call<SignInModel> signIn(@Body String id, @Body String pw);
}
