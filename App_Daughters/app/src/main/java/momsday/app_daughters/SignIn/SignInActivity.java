package momsday.app_daughters.SignIn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import momsday.app_daughters.Main.MainActivity;
import momsday.app_daughters.R;

public class SignInActivity extends AppCompatActivity implements SignInContract.View {

    private SignInContract.Presenter presenter;
    private Button btnSignIn;
    private EditText editIdSignIn;
    private EditText editPwSignIn;

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
        editIdSignIn = (EditText) findViewById(R.id.edit_id_sign_in);
        editPwSignIn = (EditText) findViewById(R.id.edit_pw_sign_in);
        if (editIdSignIn.getText().toString().isEmpty() || editPwSignIn.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(),"아이디 또는 비밀번호를 입력해주세요",Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(SignInActivity.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"로그인에 성공하셨습니다!",Toast.LENGTH_LONG).show();
        }
    }
}
