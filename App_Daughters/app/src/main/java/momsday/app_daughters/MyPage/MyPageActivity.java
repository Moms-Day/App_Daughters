package momsday.app_daughters.MyPage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import momsday.app_daughters.R;

public class MyPageActivity extends AppCompatActivity {

    private Button changePwBtn;
    private ChangePwDialog changePwDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        changePwBtn = (Button) findViewById(R.id.btn_my_page_change_pw);
        changePwDialog = new ChangePwDialog(this, changePwCancelClickListener,changePwChangeClickListener);
        changePwDialog.setCancelable(true);

        changePwBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changePwDialog.show();

            }
        });
    }

    private View.OnClickListener changePwCancelClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            changePwDialog.dismiss();
        }
    };

    private View.OnClickListener changePwChangeClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };
}
