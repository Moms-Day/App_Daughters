package momsday.app_daughters.Main.Main.Main;

public interface MainContract {
    interface View {
        void successGetInform();
        void showRequestConnectDialog();
    }
    interface Presenter {
        void setView(View view);
        void getInform();
    }
}
