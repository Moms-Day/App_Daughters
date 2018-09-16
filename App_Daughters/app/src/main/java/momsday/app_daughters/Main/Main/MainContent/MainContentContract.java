package momsday.app_daughters.Main.Main.MainContent;

import momsday.app_daughters.Main.Main.MainContent.Form;

public interface MainContentContract {
    interface View {
        void setForm(Form form);
        void showErrorMessage();

    }
    interface Presenter {
        void setView(View view);
        void getMainModel(int position);
    }
}
