package momsday.app_daughters.CareworkerInformation;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;

import momsday.app_daughters.Api;
import momsday.app_daughters.ApiClient;
import momsday.app_daughters.Main.Rank.RankCareworker.RankCareworkerModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static momsday.app_daughters.CareworkerInformation.CareworkerInformationActivity.CareworkerInformationContext;

public class CareworkerInformationPresenter implements CareworkerInformationContract.Presenter {
    CareworkerInformationContract.View view;
    private Api api = ApiClient.getClient().create(Api.class);

    @Override
    public void setView(CareworkerInformationContract.View view) {
        this.view = view;
    }

    @Override
    public void getCareworkerInform(String careworkerId) {
        api.careworkerInform(careworkerId).enqueue(new Callback<CareworkerInformationModel>() {
            @Override
            public void onResponse(Call<CareworkerInformationModel> call, Response<CareworkerInformationModel> response) {
                if(response.code()==200) {
                    CareworkerInformationModel model = response.body();
                    //todo view.setCareworkerInform
                } else {
                    view.showErrorMessage();
                }

            }

            @Override
            public void onFailure(Call<CareworkerInformationModel> call, Throwable t) {

            }
        });

    }
}
