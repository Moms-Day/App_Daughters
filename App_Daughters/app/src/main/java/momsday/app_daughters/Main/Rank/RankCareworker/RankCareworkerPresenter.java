package momsday.app_daughters.Main.Rank.RankCareworker;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import momsday.app_daughters.Api;
import momsday.app_daughters.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static momsday.app_daughters.Main.Rank.RankCareworker.RankCareworkerFragment.RankCareworkerContext;

public class RankCareworkerPresenter implements RankCareworkerContract.Presenter{
    RankCareworkerContract.View view;
    private Api api = ApiClient.getClient().create(Api.class);
    private String authorization;

    @Override
    public void setView(RankCareworkerContract.View view) {
        this.view = view;
    }

    @Override
    public void getCareworkerRank() {
        SharedPreferences preferences = RankCareworkerContext.getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE);
        authorization =preferences.getString("Authorization","");
//        api.rankCareworker("").enqueue(new Callback<RankCareworkerModel>() {
//            @Override
//            public void onResponse(Call<RankCareworkerModel> call, Response<RankCareworkerModel> response) {
//                if(response.code()==200) {
//                    RankCareworkerModel rankCareworkerModel = response.body();
//                    Log.d("Debug","rankCareworkerModel : "+rankCareworkerModel.toString());
//                    //todo response받아서 ranking띄워주기
//                }
//            }
//
//            @Override
//            public void onFailure(Call<RankCareworkerModel> call, Throwable t) {
//
//            }
//        });
    }

    @Override
    public void getCareworkerId(int position) {

    }
}
