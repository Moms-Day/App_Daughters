package momsday.app_daughters.MyPage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import momsday.app_daughters.Main.Main.MainActivity;
import momsday.app_daughters.R;

public class MyPageActivity extends AppCompatActivity implements MyPageContract.View {

    private Button changePwBtn;
    private TextView withdrawalText, completeText;
    private ChangePwDialog changePwDialog;
    private WithdrawalDialog withdrawalDialog;
    private MyPageContract.Presenter presenter;
    private EditText myNameEdit, myAgeEdit, parentNameEdit, parentAgeEdit;
    private RadioButton parentMaleBtn, parentFemaleBtn;
    public static Context myPageContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);
        myPageContext = getApplicationContext();
        presenter = new MyPagePresenter();
        presenter.setView(this);
        changePwBtn = (Button) findViewById(R.id.btn_my_page_change_pw);
        withdrawalText = (TextView) findViewById(R.id.text_my_page_withdrawal);
        completeText = (TextView) findViewById(R.id.text_my_page_complete);
        myNameEdit = (EditText) findViewById(R.id.edit_my_page_my_name);
        myAgeEdit = (EditText) findViewById(R.id.edit_my_page_my_age);
        parentNameEdit = (EditText) findViewById(R.id.edit_my_page_parent_name);
        parentAgeEdit = (EditText) findViewById(R.id.edit_my_page_parent_age);
        parentMaleBtn = (RadioButton)findViewById(R.id.radiobtn_my_page_parent_male);
        parentFemaleBtn = (RadioButton) findViewById(R.id.radiobtn_my_page_parent_female);
        changePwDialog = new ChangePwDialog(this, changePwCancelClickListener,changePwChangeClickListener);
        withdrawalDialog = new WithdrawalDialog(this, withdrawalCancelClickListener, withdrawalClickListener);
        changePwDialog.setCancelable(true);
        withdrawalDialog.setCancelable(true);

        presenter.getMyInform();

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

    @Override
    public void setMyInform(String myName, int myAge, String parentName, int parentAge, boolean parentGender) {
        myNameEdit.setText(myName);
        myAgeEdit.setText(Integer.toString(myAge));
        parentNameEdit.setText(parentName);
        parentAgeEdit.setText(Integer.toString(parentAge));
        if(parentGender) parentMaleBtn.setChecked(true);
        else parentFemaleBtn.setChecked(true);
    }
}
