package momsday.app_daughters.SignUp;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import momsday.app_daughters.Api;
import momsday.app_daughters.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static momsday.app_daughters.SignUp.SignUpActivity.signUpContext;

public class SignUpPresenter implements SignUpContract.SignUpPresenter {
    private SignUpContract.SignUpView signUpView;
    private SignUpModel signUpModel;
    private int age;
    private Api api = ApiClient.getClient().create(Api.class);

    @Override
    public void setView(SignUpContract.SignUpView signUpView) {
        this.signUpView = signUpView;
        this.signUpModel = new SignUpModel();
    }

    @Override
    public void doSignUp(String id, String pw, String phoneNumber, String certifyCode, String name, String ageText) {


        if (TextUtils.isEmpty(id) || TextUtils.isEmpty(pw) || TextUtils.isEmpty(phoneNumber) || TextUtils.isEmpty(certifyCode) || TextUtils.isEmpty(name) || TextUtils.isEmpty(ageText)) {
            signUpView.showErrorMessage("필수 항목을 모두 입력해주세요.");
        } else {
            this.age = Integer.parseInt(ageText);

            signUpModel.setId(id);
            signUpModel.setPw(pw);
            signUpModel.setAge(age);
            signUpModel.setName(name);
            signUpModel.setCertifyCode(certifyCode);
            signUpModel.setPhoneNumber(phoneNumber);

            api.doSignUp(signUpModel).enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.code() == 201) {
                        signUpView.startSignInActivity();
                        SharedPreferences sharedPreferences = signUpContext.getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("name", signUpModel.getName());
                        editor.apply();

                    } else if (response.code() == 409) {
                        signUpView.showIdErrorMessage();
                    } else {
                        signUpView.showErrorMessage();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {


                }
            });
        }
    }
}
