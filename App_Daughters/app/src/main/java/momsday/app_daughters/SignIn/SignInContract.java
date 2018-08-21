package momsday.app_daughters.SignIn;

public interface SignInContract {
    interface View {
        void startMainActivity();
        void startSignUpActivity();
        void showErrorMessage();
        void showIdErrorMessage();
    }

    interface Presenter {
        void setView(View view);
        void goSignUp();
        void doSignIn(String id, String pw);
    }
}
