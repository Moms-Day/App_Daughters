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

public class CareworkerInformationPresenter implements CareworkerInformationContract.Presenter {
    CareworkerInformationContract.View view;
    private Api api = ApiClient.getClient().create(Api.class);
    private String firstReview, secondReview, thirdReview;

    @Override
    public void setView(CareworkerInformationContract.View view) {
        this.view = view;
    }

    @Override
    public void getCareworkerInform(String careworkerId) {
        Log.d("Debug","careworkerId : "+careworkerId);
        api.careworkerInform(careworkerId).enqueue(new Callback<CareworkerInformationModel>() {
            @Override
            public void onResponse(Call<CareworkerInformationModel> call, Response<CareworkerInformationModel> response) {
                Log.d("Debug","Debug");
                if (response.code() == 200) {
                    CareworkerInformationModel model = response.body();
                    switch (model.getReviews().length) {
                        case 0:
                            firstReview = "";
                            secondReview = "";
                            thirdReview = "";
                            break;
                        case 1:
                            firstReview = model.getReviews()[0];
                            secondReview = "";
                            thirdReview = "";
                            break;
                        case 2:
                            firstReview = model.getReviews()[0];
                            secondReview = model.getReviews()[1];
                            thirdReview = "";
                            break;
                        case 3:
                            firstReview = model.getReviews()[0];
                            secondReview = model.getReviews()[1];
                            thirdReview = model.getReviews()[2];
                            break;
                    }
                    view.setCareworkerInform(model.getName(), model.getHospitalName(), model.getCareer(), model.getPatientNumber(), model.getIntroduction(), model.getSincerityScore(), model.getKindnessScore(), model.getOverall(), firstReview, secondReview, thirdReview, model.getImagePath());
                } else {
                    view.showErrorMessage();
                }

            }

            @Override
            public void onFailure(Call<CareworkerInformationModel> call, Throwable t) {
                Log.d("Debug","ㅠㅠ");
            }
        });

    }
}
