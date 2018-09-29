package momsday.app_daughters.SearchHospital;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import momsday.app_daughters.Api;
import momsday.app_daughters.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchHospitalPresenter implements SearchHospitalContract.Presenter {
    private SearchHospitalContract.View view;
    private Api api = ApiClient.getClient().create(Api.class);
    private String authorization;
    private ArrayList<SearchHospitalModel> data;
    private ArrayList<Careworker> careworkers;

    @Override
    public void setView(SearchHospitalContract.View view) {
        this.view = view;
    }

    @Override
    public void searchFacility(String facilityName) {
        SharedPreferences preferences = SearchHospitalActivity.searchHospitalContext.getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE);
        authorization = preferences.getString("Authorization", "");
        api.searchHospital("JWT " + authorization, facilityName).enqueue(new Callback<ArrayList<SearchHospitalModel>>() {
            @Override
            public void onResponse(Call<ArrayList<SearchHospitalModel>> call, Response<ArrayList<SearchHospitalModel>> response) {
                if (response.code() == 200) {
                    view.init();
                    view.showMessage("검색 완료");
                    data = response.body();
                    for (int i = 0; i < data.size(); i++) {
                        view.setHospitalNameList(data.get(i).getFacilityName(), data.get(i).getAddress());
                    }
                } else
                    view.showMessage("검색 실패");
            }
            @Override
            public void onFailure(Call<ArrayList<SearchHospitalModel>> call, Throwable t) {

            }
        });
    }

    @Override
    public ArrayList<Careworker> getCareworkers(int position) {
        return data.get(position).getCareworekrs();
    }

}
