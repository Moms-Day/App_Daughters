package momsday.app_daughters.Main.Rank;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import momsday.app_daughters.Api;
import momsday.app_daughters.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static momsday.app_daughters.Main.Rank.RankFragment.RankContext;

public class RankPresenter implements RankContract.Presenter {
    private RankContract.View view;
    private Api api = ApiClient.getClient().create(Api.class);
    RankEvaluateHospitalModel rankEvaluateHospitalModel;
    private String authorization, hospitalCode;

    @Override
    public void setView(RankContract.View view) {
        this.view = view;
    }

    @Override
    public void evaluateCareworker() {

    }

    @Override
    public void evaluateHospital(int equipment, int meal, int schedule, int cost, int service, float overall, String lineE) {
        Log.d("Debug","presenter");
        SharedPreferences preferences = RankContext.getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE);
        authorization =preferences.getString("Authorization","");
        hospitalCode = preferences.getString("hospitalCode","dd");
        rankEvaluateHospitalModel  = new RankEvaluateHospitalModel();
        rankEvaluateHospitalModel.setEquipment(equipment);
        rankEvaluateHospitalModel.setMeal(meal);
        rankEvaluateHospitalModel.setSchedule(schedule);
        rankEvaluateHospitalModel.setCost(cost);
        rankEvaluateHospitalModel.setService(service);
        rankEvaluateHospitalModel.setOverall(overall);
        rankEvaluateHospitalModel.setLineE(lineE);

        api.evaluateHospital(hospitalCode, "JWT "+authorization,rankEvaluateHospitalModel).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d("Debug","server");
                if(response.code()==201) {
                    view.showSuccessMessage();
                } else if(response.code()==400){
                    view.showErrorMEssage("존재하지 않는 요양시설");
                } else {
                    view.showErrorMEssage("오류");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });




    }

}
