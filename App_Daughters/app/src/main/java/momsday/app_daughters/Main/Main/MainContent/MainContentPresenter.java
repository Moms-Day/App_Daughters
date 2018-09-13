package momsday.app_daughters.Main.Main.MainContent;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import momsday.app_daughters.Api;
import momsday.app_daughters.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static momsday.app_daughters.Main.Main.MainContent.MainFragment.MainContentContext;

public class MainContentPresenter implements MainContentContract.Presenter {
    private MainContentContract.View view;
    private Api api = ApiClient.getClient().create(Api.class);
    private String authorization, parentId;
    private MainContentModel mainContentModel;
    private Form form;

    @Override
    public void setView(MainContentContract.View view) {
        this.view = view;
    }

    @Override
    public void getMainModel() {
        SharedPreferences preferences = MainContentContext.getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE);
        authorization = preferences.getString("Authorization", "");
        parentId = preferences.getString("parentId", "");
        api.getForm("JWT " + authorization, parentId).enqueue(new Callback<MainContentModel>() {
            @Override
            public void onResponse(Call<MainContentModel> call, Response<MainContentModel> response) {
                if (response.code() == 200) {
                    mainContentModel = response.body();
                    Log.d("Debug", "presenter : " + mainContentModel.getToday().toString());
                    view.successGetMainModel();
                } else {
                    view.showErrorMessage();
                }
            }

            @Override
            public void onFailure(Call<MainContentModel> call, Throwable t) {
            }
        });

    }

    @Override
    public Form getForm(int position) {
        switch (position) {
            case 0:
                form = mainContentModel.getTwoDaysAgoForm();
                return form;
            case 1:
                form = mainContentModel.getYesterday();
                return form;
            case 2:
                form = mainContentModel.getToday();
                return form;
            default:
                return null;
        }
    }
}
