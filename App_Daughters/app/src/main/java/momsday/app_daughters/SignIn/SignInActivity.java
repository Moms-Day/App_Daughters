package momsday.app_daughters.SignIn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import momsday.app_daughters.MainActivity;
import momsday.app_daughters.R;

public class SignInActivity extends AppCompatActivity implements SignInContract.View {

    private SignInContract.Presenter presenter;
    private Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        presenter = new SignInPresenter();
        presenter.setView(this);
        initView();
    }

    private void initView() {
        btnSignIn = (Button) findViewById(R.id.btn_sign_in);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.callSignIn();
            }
        });
    }

    @Override
    public void startMainActivity() {
        Intent intent = new Intent(SignInActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
