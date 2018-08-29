package momsday.app_daughters.SearchHospital;

public interface SearchHospitalContract {
    interface View {
        void setHospitalNameList(String hospitalName, String hospitalLocation);
    }
    interface Presenter {
        void setView(View view);
        void searchFacility(String FacilityName);

    }
}
