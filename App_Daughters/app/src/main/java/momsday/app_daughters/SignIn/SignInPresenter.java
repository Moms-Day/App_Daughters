package momsday.app_daughters.SignIn;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.gson.JsonObject;
import momsday.app_daughters.Api;
import momsday.app_daughters.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static momsday.app_daughters.SignIn.SignInActivity.signInContext;

public class SignInPresenter implements SignInContract.Presenter {
    private SignInContract.View view;
    private Api api = ApiClient.getClient().create(Api.class);

    @Override
    public void setView(SignInContract.View view) {
        this.view = view;
    }


    @Override
    public void doSignIn(String id, String pw) {
//        view.startMainActivity();
        final SignInModel signInModel = new SignInModel();
        signInModel.setId(id);
        signInModel.setPw(pw);

        api.doSignIn(signInModel).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, final Response<JsonObject> response) {
                Log.d("Debug", Integer.toString(response.code()));
                if (response.code() == 200) {
                    SharedPreferences sharedPreferences = signInContext.getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("Authorization",response.body().get("accessToken").getAsString());
                    editor.putString("id", signInModel.getId());
                    editor.putString("pw",signInModel.getPw());
                    editor.apply();
                    view.startMainActivity();
                } else if(response.code() == 401){
                    view.showIdErrorMessage();
                } else {
                    view.showErrorMessage();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
            }

        });
    }


    @Override
    public void goSignUp() {
        view.startSignUpActivity();
    }
}
