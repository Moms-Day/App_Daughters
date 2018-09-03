package momsday.app_daughters.SearchHospital;

public interface SearchHospitalContract {
    interface View {
        void setHospitalNameList(String hospitalName, String hospitalLocation);
        void startRequestConnection(int position);
    }
    interface Presenter {
        void setView(View view);
        void searchFacility(String FacilityName);

    }
}
