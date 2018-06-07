package momsday.app_daughters.Start;

public interface StartContract {
    interface View {
        void startSignInActivity();
    }

    interface Presenter {
        void setview(View view);

        void moveSignIn();
    }
}