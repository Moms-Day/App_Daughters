package momsday.app_daughters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import momsday.app_daughters.SignIn.SignInActivity;

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // MainActivity.class 자리에 다음에 넘어갈 액티비티를 넣어주기
        Intent intent = new Intent(this, SignInActivity.class);
        intent.putExtra("state", "launch");
        startActivity(intent);
        finish();
    }
}
