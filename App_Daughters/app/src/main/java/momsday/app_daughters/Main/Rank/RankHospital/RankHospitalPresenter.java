package momsday.app_daughters.Main.Rank.RankHospital;

import android.content.Context;
import android.content.SharedPreferences;

import momsday.app_daughters.Api;
import momsday.app_daughters.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static momsday.app_daughters.Main.Rank.RankHospital.RankHospitalFragment.RankHospitalContext;

public class RankHospitalPresenter implements RankHospitalContract.Presenter {
    private RankHospitalContract.View view;
    private Api api = ApiClient.getClient().create(Api.class);
    private String authorization, hospitalCode;
    private RankHospitalModel rankHospitalModel;
    private SharedPreferences preferences;

    @Override
    public void setView(RankHospitalContract.View view) {
        this.view = view;
    }

    @Override
    public void getHospitalRank() {
        preferences = RankHospitalContext.getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE);
        authorization = preferences.getString("Authorization", "");
        api.rankHospital("JWT " + authorization).enqueue(new Callback<RankHospitalModel>() {
            @Override
            public void onResponse(Call<RankHospitalModel> call, Response<RankHospitalModel> response) {
                if (response.code() == 200) {
                    rankHospitalModel = response.body();
                    for (int i = 0; i < rankHospitalModel.getFacilities().size(); i++) {
                        view.setHospital(rankHospitalModel.getFacilities().get(i).getHospitalName(), rankHospitalModel.getFacilities().get(i).getHospitalAddress(), rankHospitalModel.getFacilities().get(i).getHospitalOverAll(), rankHospitalModel.getFacilities().get(i).getHospitalImagePath());
                    }

                    if (rankHospitalModel.getMyFacilities().size() == 0) {
                        view.setMyHospitalNoneText();
                    } else {
                        for(int i=0;i<rankHospitalModel.getMyFacilities().size();i++) {
                            if(rankHospitalModel.getMyFacilities().get(i).getMyHospitalCode().equals(preferences.getString("hospitalCode", ""))) {
                                view.setMyHospital(rankHospitalModel.getMyFacilities().get(i).getMyHospitalName(), rankHospitalModel.getMyFacilities().get(i).getMyHospitalAddress(), rankHospitalModel.getMyFacilities().get(i).getMyHospitalOverAll(), rankHospitalModel.getMyFacilities().get(i).getMyHospitalImagePath());
                                break;
                            }
                        }
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
        hospitalCode = rankHospitalModel.getFacilities().get(position).getHospitalCode();
        view.startHospitalInform(hospitalCode);
    }

    @Override
    public void getMyHospitalCode(int position) {
        hospitalCode = preferences.getString("hospitalCode","");
        view.startHospitalInform(hospitalCode);
    }
}
