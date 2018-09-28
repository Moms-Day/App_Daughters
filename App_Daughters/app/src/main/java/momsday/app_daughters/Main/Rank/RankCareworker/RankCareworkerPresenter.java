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

public class RankCareworkerPresenter implements RankCareworkerContract.Presenter {
    RankCareworkerContract.View view;
    private Api api = ApiClient.getClient().create(Api.class);
    private String authorization, careworkerId;
    private SharedPreferences preferences;
    private RankCareworkerModel rankCareworkerModel;

    @Override
    public void setView(RankCareworkerContract.View view) {
        this.view = view;
    }

    @Override
    public void getCareworkerRank() {
        preferences = RankCareworkerContext.getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE);
        authorization = preferences.getString("Authorization", "");
        api.rankCareworker("JWT " + authorization).enqueue(new Callback<RankCareworkerModel>() {
            @Override
            public void onResponse(Call<RankCareworkerModel> call, Response<RankCareworkerModel> response) {
                if (response.code() == 200) {
                    rankCareworkerModel = response.body();
                    for (int i = 0; i < rankCareworkerModel.getCareworkers().size(); i++) {
                        view.setCareworker(rankCareworkerModel.getCareworkers().get(i).getName(), rankCareworkerModel.getCareworkers().get(i).getWorkplace(), rankCareworkerModel.getCareworkers().get(i).getOverall(), rankCareworkerModel.getCareworkers().get(i).getImagePath());
                    }

                    if(rankCareworkerModel.getMyCareworekrs().size() == 0) {
                        view.setMyCareworkerNoneText();
                    } else {
                        for(int i=0; i<rankCareworkerModel.getMyCareworekrs().size(); i++) {
                            if(rankCareworkerModel.getMyCareworekrs().get(i).getCareworkerId().equals(preferences.getString("careworkerId", ""))) {
                                view.setMyCareworker(rankCareworkerModel.getMyCareworekrs().get(i).getName(), rankCareworkerModel.getMyCareworekrs().get(i).getWorkplace(), rankCareworkerModel.getMyCareworekrs().get(i).getOverall(), rankCareworkerModel.getMyCareworekrs().get(i).getImagePath());
                                break;
                            }
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<RankCareworkerModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void getCareworkerId(int position) {
        careworkerId = rankCareworkerModel.getCareworkers().get(position).getCareworkerId();
        view.startCareworkerInform(careworkerId);
    }

    @Override
    public void getMyCareworkerId(int position) {
        careworkerId = preferences.getString("careworkerId","");
        view.startCareworkerInform(careworkerId);
    }
}
