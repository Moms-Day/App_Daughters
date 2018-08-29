package momsday.app_daughters.SignUp;

public interface SignUpContract {
    interface SignUpView{
        void startSignInActivity();
        void showErrorMessage();
        void showIdErrorMessage();
        void showErrorMessage(String errorMessage);

    }
    interface SignUpPresenter{
        void setView(SignUpView signUpView);
        void doSignUp(String id, String pw, String phoneNumber, String certifyCode, String name, String age);
    }
}
