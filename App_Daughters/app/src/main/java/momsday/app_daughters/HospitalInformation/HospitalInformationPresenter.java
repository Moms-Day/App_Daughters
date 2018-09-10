package momsday.app_daughters.HospitalInformation;

import momsday.app_daughters.Api;
import momsday.app_daughters.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HospitalInformationPresenter implements HospitalInformationContract.Presenter {
    HospitalInformationContract.View view;
    private Api api = ApiClient.getClient().create(Api.class);
    private HospitalInformationModel hospitalInformationModel;
    private String firstReview, secondReview, thirdReview;

    @Override
    public void setView(HospitalInformationContract.View view) {
        this.view = view;
    }

    @Override
    public void getHospitalInform(String hospitalCode) {
        api.hospitalInform(hospitalCode).enqueue(new Callback<HospitalInformationModel>() {
            @Override
            public void onResponse(Call<HospitalInformationModel> call, Response<HospitalInformationModel> response) {
                if(response.code()==200) {
                    hospitalInformationModel = response.body();
                    switch(hospitalInformationModel.getReviews().length) {
                        case 0:
                            firstReview = "";
                            secondReview = "";
                            thirdReview = "";
                            break;
                        case 1:
                            firstReview = hospitalInformationModel.getReviews()[0];
                            secondReview = "";
                            thirdReview = "";
                            break;
                        case 2:
                            firstReview = hospitalInformationModel.getReviews()[0];
                            secondReview = hospitalInformationModel.getReviews()[1];
                            thirdReview = "";
                            break;
                        case 3:
                            firstReview = hospitalInformationModel.getReviews()[0];
                            secondReview = hospitalInformationModel.getReviews()[1];
                            thirdReview = hospitalInformationModel.getReviews()[2];
                            break;
                    }


                    view.setHospitalInform(hospitalInformationModel.getName(), hospitalInformationModel.getPhoneNumber(),hospitalInformationModel.getLocation(),hospitalInformationModel.getIntroduction(),hospitalInformationModel.getFacilityScore(),hospitalInformationModel.getMealScore(), hospitalInformationModel.getScheduleScore(), hospitalInformationModel.getCostScore(), hospitalInformationModel.getServiceScore(), firstReview, secondReview, thirdReview,hospitalInformationModel.getOverall(), hospitalInformationModel.getImagePath());
                } else {
                    view.showErrorMessage();
                }
            }

            @Override
            public void onFailure(Call<HospitalInformationModel> call, Throwable t) {

            }
        });
    }
}
