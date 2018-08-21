package momsday.app_daughters.SignIn;

import android.widget.EditText;

public class SignInPresenter implements SignInContract.Presenter {
    private SignInContract.View view;
    private SignInModel signInModel;

    @Override
    public void setView(SignInContract.View view) {
        this.view = view;
        this.signInModel = new SignInModel();
    }

    @Override
    public void doSignIn(String id, String pw) {
        view.startMainActivity();
//        if(signInModel.checkIdPw(id, pw) == 201) {
//            view.startMainActivity();
//        } else if(signInModel.checkIdPw(id, pw) == 409){
//            view.showIdErrorMessage();
//        } else {
//            view.showErrorMessage();
//        }
    }

    @Override
    public void goSignUp() {
        view.startSignUpActivity();
    }
}
