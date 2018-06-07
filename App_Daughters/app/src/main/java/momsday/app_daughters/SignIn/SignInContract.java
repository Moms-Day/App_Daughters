package momsday.app_daughters.SignIn;

public interface SignInContract {
    interface View {
        void startMainActivity();
    }
    interface Presenter {
        void setView(View view);
        void callSignIn();
    }
}
