package momsday.app_daughters.Main.Rank.RankHospital;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import momsday.app_daughters.Api;
import momsday.app_daughters.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static momsday.app_daughters.Main.Rank.RankHospital.RankHospitalFragment.RankHospitalContext;

public class RankHospitalPresenter implements RankHospitalContract.Presenter {
    private RankHospitalContract.View view;
    private Api api = ApiClient.getClient().create(Api.class);
    private String authorization;

    @Override
    public void setView(RankHospitalContract.View view) {
        this.view = view;
    }

    @Override
    public void getHospitalRank() {
        SharedPreferences preferences = RankHospitalContext.getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE);
        authorization = preferences.getString("Authorization", "");
        api.rankHospital("").enqueue(new Callback<RankHospitalModel>() {
            @Override
            public void onResponse(Call<RankHospitalModel> call, Response<RankHospitalModel> response) {
                if (response.code() == 200) {
                    RankHospitalModel rankHospitalModel = response.body();
                    for (int i = 0; i < rankHospitalModel.getFacilities().size(); i++) {
                        view.setHospital(rankHospitalModel.getFacilities().get(i).getHospitalName(), rankHospitalModel.getFacilities().get(i).getHospitalAddress(), rankHospitalModel.getFacilities().get(i).getHospitalOverAll());
                    }
                    for(int i=0; i<rankHospitalModel.getMyFacilities().size(); i++) {
                        view.setMyHospital(rankHospitalModel.getMyFacilities().get(i).getMyHospitalName(),rankHospitalModel.getMyFacilities().get(i).getMyHospitalAddress(),rankHospitalModel.getMyFacilities().get(i).getMyHospitalOverAll());
                    }
                    if(rankHospitalModel.getMyFacilities().size() == 0) {
                        view.setMyHospitalNoneText();
                    }
                }
            }

            @Override
            public void onFailure(Call<RankHospitalModel> call, Throwable t) {

            }
        });

    }

    @Override
    public void getHospitalCode(int position) {
        //view.startHospitalInform();
    }
}
