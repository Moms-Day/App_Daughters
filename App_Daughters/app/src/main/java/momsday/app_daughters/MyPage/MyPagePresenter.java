package momsday.app_daughters.MyPage;

import android.content.Context;
import android.content.SharedPreferences;

import momsday.app_daughters.Api;
import momsday.app_daughters.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static momsday.app_daughters.MyPage.MyPageActivity.myPageContext;

public class MyPagePresenter implements MyPageContract.Presenter {
    private Api api = ApiClient.getClient().create(Api.class);
    private String authorization, parentName;
    private MyPageModel data;
    private MyPageContract.View view;
    private int parentAge;
    private boolean parentGender;

    @Override
    public void setView(MyPageContract.View view) {
        this.view = view;
    }

    @Override
    public void getMyInform() {
        SharedPreferences preferences = myPageContext.getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE);
        authorization = preferences.getString("Authorization", "");

        api.getMyPage("JWT " + authorization).enqueue(new Callback<MyPageModel>() {
            @Override
            public void onResponse(Call<MyPageModel> call, Response<MyPageModel> response) {
                if (response.code() == 200) {
                    data = response.body();
                    if (data.getPatients().size() != 0) {
                        parentName = data.getPatients().get(0).getName();
                        parentAge = data.getPatients().get(0).getAge();
                        parentGender = data.getPatients().get(0).isGender();
                    }
                    view.setMyInform(data.getName(), data.getAge(), parentName, parentAge, parentGender);
                }
            }

            @Override
            public void onFailure(Call<MyPageModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void doWithdrawal(String pw) {
        WithdrawalModel withdrawalModel = new WithdrawalModel();
        withdrawalModel.setPw(pw);
        api.doWithDrawal("JWT "+authorization,withdrawalModel).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.code() == 200) {
                    view.completeWithdrawal();
                } else if(response.code() == 403) {
                    view.showErrorMessage("비밀번호 불일치");
                } else {
                    view.showErrorMessage("오류");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}
