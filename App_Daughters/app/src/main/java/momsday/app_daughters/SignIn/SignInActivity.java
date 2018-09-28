package momsday.app_daughters.SignIn;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import momsday.app_daughters.Main.Main.Main.MainActivity;
import momsday.app_daughters.R;
import momsday.app_daughters.SignUp.SignUpActivity;

public class SignInActivity extends AppCompatActivity implements SignInContract.View {

    private SignInContract.Presenter presenter;
    private Button btnSignIn;
    private EditText editIdSignIn, editPwSignIn;
    private TextView goSignUpBtn;
    private String id, pw;
    public static Context signInContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        signInContext = this;


        presenter = new SignInPresenter();
        presenter.setView(this);
        editIdSignIn = (EditText) findViewById(R.id.edit_id_sign_in);
        editPwSignIn = (EditText) findViewById(R.id.edit_pw_sign_in);
        goSignUpBtn = (TextView) findViewById(R.id.text_sign_in_sign_up);
        initView();
    }

    private void initView() {
        btnSignIn = (Button) findViewById(R.id.btn_sign_in);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = editIdSignIn.getText().toString();
                pw = editPwSignIn.getText().toString();
                presenter.doSignIn(id, pw);
            }
        });
        goSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.goSignUp();
            }
        });
    }

    @Override
    public void startMainActivity() {
        Intent intent = new Intent(SignInActivity.this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "로그인에 성공하셨습니다!", Toast.LENGTH_LONG).show();

        finish();
    }

    @Override
    public void startSignUpActivity() {
        Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
        startActivity(intent);
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(getApplicationContext(), "오류", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showIdErrorMessage() {
        Toast.makeText(getApplicationContext(), "비밀번호 오류", Toast.LENGTH_SHORT).show();
    }
}
