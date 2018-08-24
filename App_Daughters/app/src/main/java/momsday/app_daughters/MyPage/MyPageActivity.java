package momsday.app_daughters.MyPage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import momsday.app_daughters.Main.Main.MainActivity;
import momsday.app_daughters.R;

public class MyPageActivity extends AppCompatActivity {

    private Button changePwBtn;
    private TextView withdrawalText, completeText;
    private ChangePwDialog changePwDialog;
    private WithdrawalDialog withdrawalDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        changePwBtn = (Button) findViewById(R.id.btn_my_page_change_pw);
        withdrawalText = (TextView) findViewById(R.id.text_my_page_withdrawal);
        completeText = (TextView) findViewById(R.id.text_my_page_complete);
        changePwDialog = new ChangePwDialog(this, changePwCancelClickListener,changePwChangeClickListener);
        withdrawalDialog = new WithdrawalDialog(this, withdrawalCancelClickListener, withdrawalClickListener);
        changePwDialog.setCancelable(true);
        withdrawalDialog.setCancelable(true);

        changePwBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changePwDialog.show();

            }
        });

        withdrawalText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                withdrawalDialog.show();
            }
        });

        completeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyPageActivity.this, MainActivity.class);
                startActivity(intent);
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

    private View.OnClickListener withdrawalCancelClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            withdrawalDialog.dismiss();
        }
    };

    private View.OnClickListener withdrawalClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };
}
