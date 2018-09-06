package momsday.app_daughters.Main.Rank;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import momsday.app_daughters.Api;
import momsday.app_daughters.ApiClient;
import momsday.app_daughters.Main.Rank.RankEvaluateHospital.RankEvaluateHospitalModel;
import momsday.app_daughters.Main.Rank.RankEvaluteCareworker.RankEvaluateCareworkerModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static momsday.app_daughters.Main.Rank.RankFragment.RankContext;

public class RankPresenter implements RankContract.Presenter {
    private RankContract.View view;
    private Api api = ApiClient.getClient().create(Api.class);
    private RankEvaluateHospitalModel rankEvaluateHospitalModel;
    private RankEvaluateCareworkerModel rankEvaluateCareworkerModel;
    private String authorization, hospitalCode, careworkerId;

    @Override
    public void setView(RankContract.View view) {
        this.view = view;
    }

    @Override
    public void evaluateCareworker(int sincerity, int kindness, float overall, String review) {
        SharedPreferences preferences = RankContext.getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE);
        authorization =preferences.getString("Authorization","");
        careworkerId = preferences.getString("careworkerId","dd");
        rankEvaluateCareworkerModel = new RankEvaluateCareworkerModel();
        rankEvaluateCareworkerModel.setSincerity(sincerity);
        rankEvaluateCareworkerModel.setKindness(kindness);
        rankEvaluateCareworkerModel.setOverall(overall);
        rankEvaluateCareworkerModel.setReview(review);

        api.evaluateCareworker(careworkerId, "JWT "+authorization,rankEvaluateCareworkerModel).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d("Debug","server");
                if(response.code()==201) {
                    view.showEvaluateCareworkerSuccessMessage();
                } else if(response.code()==400){
                    view.showErrorMEssage("존재하지 않는 요양보호사");
                } else {
                    view.showErrorMEssage("오류");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
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
                    view.showEvaluateHospitalSuccessMessage();
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
