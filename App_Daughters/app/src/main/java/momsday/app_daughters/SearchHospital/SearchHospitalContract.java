package momsday.app_daughters.SearchHospital;

import java.util.ArrayList;

public interface SearchHospitalContract {
    interface View {
        void showMessage(String message);
        void init();
        void setHospitalNameList(String hospitalName, String hospitalLocation);
    }
    interface Presenter {
        void setView(View view);
        void searchFacility(String FacilityName);
        ArrayList<Careworker> getCareworkers(int position);
    }
}
