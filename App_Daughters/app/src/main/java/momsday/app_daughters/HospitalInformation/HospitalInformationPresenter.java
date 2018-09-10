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
                    //todo view.setHospitalInform
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
