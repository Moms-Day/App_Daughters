package momsday.app_daughters.SignIn;

import android.widget.EditText;

public class SignInPresenter implements SignInContract.Presenter {
    private SignInContract.View view;

    @Override
    public void setView(SignInContract.View view) {
        this.view = view;
    }

    @Override
    public void callSignIn() {
        view.startMainActivity();
    }
}
