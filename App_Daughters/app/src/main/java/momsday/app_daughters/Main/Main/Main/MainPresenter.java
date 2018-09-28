package momsday.app_daughters.Main.Main.Main;

import android.content.SharedPreferences;
import java.util.ArrayList;
import momsday.app_daughters.Api;
import momsday.app_daughters.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import static android.content.Context.MODE_PRIVATE;
import static momsday.app_daughters.Main.Main.Main.MainActivity.MainContext;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View view;
    private Api api = ApiClient.getClient().create(Api.class);
    private String authorization;
    private ArrayList<MainModel> parentInforms;
    @Override
    public void setView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void getInform() {
        final SharedPreferences preferences = MainContext.getSharedPreferences("PREFERENCE", MODE_PRIVATE);
        authorization =preferences.getString("Authorization","");
        api.getMain("JWT "+authorization).enqueue(new Callback<ArrayList<MainModel>>() {
            @Override
            public void onResponse(Call<ArrayList<MainModel>> call, Response<ArrayList<MainModel>> response) {
                if(response.code() == 200) {
                    parentInforms = response.body();
                    if(parentInforms.size() != 0) {
                        SharedPreferences preference = MainContext.getSharedPreferences("PREFERENCE",MODE_PRIVATE);
                        SharedPreferences.Editor editor = preference.edit();
                        editor.putString("parentId",parentInforms.get(0).getId());
                        editor.apply();
                        view.successGetInform(parentInforms);
                    } else {
                        view.showRequestConnectDialog();
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<MainModel>> call, Throwable t) {

            }
        });
    }
}
