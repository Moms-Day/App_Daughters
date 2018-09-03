package momsday.app_daughters.CareworkerInformation;

import android.view.View;

public interface CareworkerInformationContract {
    interface View {
        void setCareworkerInform();

    }

    interface Presenter {
        void setView(android.view.View view);
        void getCareworkerInform();
    }
}
