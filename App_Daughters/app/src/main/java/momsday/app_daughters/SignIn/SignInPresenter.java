package momsday.app_daughters.SignIn;

import android.util.Log;
import android.widget.EditText;

import org.json.JSONObject;

import momsday.app_daughters.Api;
import momsday.app_daughters.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInPresenter implements SignInContract.Presenter {
    private SignInContract.View view;
    private SignInModel signInModel;
    private Api api = ApiClient.getClient().create(Api.class);

    @Override
    public void setView(SignInContract.View view) {
        this.view = view;
        this.signInModel = new SignInModel();
    }


    @Override
    public void doSignIn(String id, String pw) {
//        view.startMainActivity();
        final SignInModel signInModel = new SignInModel();
        signInModel.setId(id);
        signInModel.setPw(pw);

        api.doSignIn(signInModel).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d("Debug", Integer.toString(response.code()));
                if (response.code() == 200) {
                    view.startMainActivity();
                } else if(response.code() == 401){
                    view.showIdErrorMessage();
                } else {
                    view.showErrorMessage();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
            }

        });
    }


    @Override
    public void goSignUp() {
        view.startSignUpActivity();
    }
}
