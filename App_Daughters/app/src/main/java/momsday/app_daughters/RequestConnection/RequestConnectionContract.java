package momsday.app_daughters.RequestConnection;

import java.util.ArrayList;

public interface RequestConnectionContract {
    interface View {
        void startSearchHospital();
        void setCareworkerList(ArrayList<String> careworkerNameList);
        void startMainActivity();
        void showErrorMessage();
    }
    interface Presenter {
        void setView(View view);
        void searchHospital();
        void getCareworkerList();
        void requestConnection(String userName, String patientName, String patientAge, boolean patientGender);
    }
}
