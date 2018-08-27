package momsday.app_daughters.SignUp;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import momsday.app_daughters.Api;
import momsday.app_daughters.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpPresenter implements SignUpContract.SignUpPresenter {
    private SignUpContract.SignUpView signUpView;
    private SignUpModel signUpModel;
    private int age, parentAge;
    private boolean parentGender;
    private JSONArray parents;
    private Api api = ApiClient.getClient().create(Api.class);

    @Override
    public void setView(SignUpContract.SignUpView signUpView) {
        this.signUpView = signUpView;
        this.signUpModel = new SignUpModel();
    }

    @Override
    public void doSignUp(String id, String pw, String phoneNumber, String certifyCode, String name, String ageText, String parentName, String parentAgeText, String parentGenderText) {


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

            if ((TextUtils.isEmpty(parentName) || TextUtils.isEmpty(parentAgeText) || TextUtils.isEmpty(parentGenderText)) == false) {
                this.parentAge = Integer.parseInt(parentAgeText);

                if (parentGenderText.equals("man")) {
                    this.parentGender = true;
                } else {
                    this.parentGender = false;
                }

                this.parents = new JSONArray();
//            JSONObject jsonObject = new JSONObject();
                try {
//                jsonObject.put("name", this.parentName);
//                jsonObject.put("age", this.parentAge);
//                jsonObject.put("gender", this.parentGender);
//                this.parents.put(jsonObject);
                    this.parents.put(0, parentName);
                    this.parents.put(1, this.parentAge);
                    this.parents.put(2, this.parentGender);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                signUpModel.setParents(this.parents);
            }
            api.doSignUp(signUpModel).enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    Log.d("Debug", "responseCode : " + Integer.toString(response.code()));
                    if (response.code() == 201) {
                        signUpView.startSignInActivity();
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
