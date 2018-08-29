package momsday.app_daughters.SearchHospital;

public class SearchHospitalPresenter implements SearchHospitalContract.Presenter{
    private SearchHospitalContract.View view;
    @Override
    public void setView(SearchHospitalContract.View view) {
        this.view = view;
    }

    @Override
    public void searchFacility(String FacilityName) {

    }
}
