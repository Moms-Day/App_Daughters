package momsday.app_daughters.Main.Main.Main;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

import momsday.app_daughters.Api;
import momsday.app_daughters.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static momsday.app_daughters.Main.Main.Main.MainActivity.MainContext;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View view;
    private Api api = ApiClient.getClient().create(Api.class);
    private String authorization;
    private ArrayList<String> parentIds;
    private String parentId;
    @Override
    public void setView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void getInform() {
        final SharedPreferences preferences = MainContext.getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE);
        authorization =preferences.getString("Authorization","");
        api.getMain("JWT "+authorization).enqueue(new Callback<ArrayList<String>>() {
            @Override
            public void onResponse(Call<ArrayList<String>> call, Response<ArrayList<String>> response) {
                if(response.code() == 200) {
                    parentIds = response.body();
                    if(parentIds.size() != 0) {
                        parentId = parentIds.get(0);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("parentId",parentId);
                        editor.apply();
                        view.successGetInform();
                    } else {
                        view.showRequestConnectDialog();
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<String>> call, Throwable t) {

            }
        });
    }
}
