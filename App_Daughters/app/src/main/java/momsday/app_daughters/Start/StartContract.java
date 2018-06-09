package momsday.app_daughters.Start;

public interface StartContract {
    interface View {
        void startSignInActivity();
        void startSignUpActivity();
    }

    interface Presenter {
        void setview(View view);

        void moveSignIn();
        void moveSignUp();
    }
}