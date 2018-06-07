package momsday.app_daughters.Start;

public class StartPresenter implements StartContract.Presenter {
    private StartContract.View view;

    @Override
    public void setview(StartContract.View view) {
        this.view = view;
    }

    @Override
    public void moveSignIn() {
        view.startSignInActivity();
    }
}
