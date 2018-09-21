package momsday.app_daughters.Main.Main.Main;

import java.util.ArrayList;

public interface MainContract {
    interface View {
        void successGetInform(ArrayList<MainModel> parentInforms);
        void showRequestConnectDialog();
    }
    interface Presenter {
        void setView(View view);
        void getInform();
    }
}
