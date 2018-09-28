package momsday.app_daughters.RequestConnection;

import android.content.Context;
import android.content.SharedPreferences;
import momsday.app_daughters.Api;
import momsday.app_daughters.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static momsday.app_daughters.RequestConnection.RequestConnectionActivity.RequestConnectionContext;

public class RequestConnectionPresenter implements RequestConnectionContract.Presenter {
    private RequestConnectionContract.View view;
    private RequestConnectionModel requestConnectionModel;
    private Api api = ApiClient.getClient().create(Api.class);
    private String authorization, careId, userId;

    @Override
    public void setView(RequestConnectionContract.View view) {
        this.view = view;
    }

    @Override
    public void searchHospital() {

    }

    @Override
    public void getCareworkerList() {

    }

    @Override
    public void requestConnection(String userName, String patientName, String patientAge, boolean patientGender, String careId) {

        SharedPreferences preferences = RequestConnectionContext.getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE);

        authorization =preferences.getString("Authorization","");
        userId = preferences.getString("id","");
        requestConnectionModel = new RequestConnectionModel();
        requestConnectionModel.setRequesterName(userName);
        requestConnectionModel.setPatientName(patientName);
        requestConnectionModel.setPatientAge(Integer.parseInt(patientAge));
        requestConnectionModel.setPatientGender(patientGender);
        requestConnectionModel.setRequesterId(userId);
        requestConnectionModel.setCareId(careId);

        api.requestConnection("JWT "+authorization, requestConnectionModel).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, final Response<Void> response) {
                if (response.code() == 201) {
                    view.startMainActivity();
                } else {
                    view.showErrorMessage();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
            }

        });

    }

}
