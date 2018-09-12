package momsday.app_daughters.Main.Main.MainContent;

import momsday.app_daughters.Main.Main.MainContent.Form;

public interface MainContentContract {
    interface View {
        void successGetMainModel();
        void showErrorMessage();

    }
    interface Presenter {
        void setView(View view);
        void getMainModel();
        Form getForm(int position);
    }
}
