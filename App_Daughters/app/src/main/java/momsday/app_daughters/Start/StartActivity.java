package momsday.app_daughters.Start;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import momsday.app_daughters.R;
import momsday.app_daughters.SignIn.SignInActivity;
import momsday.app_daughters.SignIn.SignInContract;
import momsday.app_daughters.SignIn.SignInPresenter;
import momsday.app_daughters.SignUp.SignUpActivity;

public class StartActivity extends AppCompatActivity implements StartContract.View {

    private StartContract.Presenter presenter;
    private Button signInBtn, signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        presenter = new StartPresenter();
        presenter.setview(this);
        initView();
    }

    private void initView() {
        signInBtn = (Button) findViewById(R.id.btn_signin_start);
        signUpBtn = (Button) findViewById(R.id.btn_signup_start);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.moveSignIn();
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.moveSignUp();
            }
        });
    }

    @Override
    public void startSignInActivity() {
        Intent intent = new Intent(StartActivity.this, SignInActivity.class);
        startActivity(intent);
    }

    @Override
    public void startSignUpActivity() {
        Intent intent = new Intent(StartActivity.this, SignUpActivity.class);
        startActivity(intent);
    }
}
