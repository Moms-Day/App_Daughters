package momsday.app_daughters.SearchHospital;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import momsday.app_daughters.Api;
import momsday.app_daughters.ApiClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchHospitalPresenter implements SearchHospitalContract.Presenter{
    private SearchHospitalContract.View view;
    private Api api = ApiClient.getClient().create(Api.class);
    private String authorization;
    @Override
    public void setView(SearchHospitalContract.View view) {
        this.view = view;
    }

    @Override
    public void searchFacility(String facilityName) {
        SharedPreferences preferences = SearchHospitalActivity.searchHospitalContext.getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE);
        authorization = preferences.getString("Authorization","");
        api.searchHospital("JWT "+authorization,facilityName).enqueue(new Callback<SearchHospitalModel>() {
            @Override
            public void onResponse(Call<SearchHospitalModel> call, Response<SearchHospitalModel> response) {
                if(response.code()==200) {
                    SearchHospitalModel searchHospitalModel = response.body();
                    Log.d("Debug","searchHospitalModel : "+searchHospitalModel.toString());
                    //todo response받아서 recyclerview에 띄워주기
                }
            }

            @Override
            public void onFailure(Call<SearchHospitalModel> call, Throwable t) {

            }
        });
    }
}
