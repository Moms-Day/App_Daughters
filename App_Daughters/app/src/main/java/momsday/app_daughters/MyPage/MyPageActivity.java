package momsday.app_daughters.MyPage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import momsday.app_daughters.R;
import momsday.app_daughters.SignIn.SignInActivity;

public class MyPageActivity extends AppCompatActivity implements MyPageContract.View {

    private Button changePwBtn;
    private TextView withdrawalText, completeText;
    private ChangePwDialog changePwDialog;
    private WithdrawalDialog withdrawalDialog;
    private MyPageContract.Presenter presenter;
    private EditText myNameEdit, myAgeEdit;
    public static Context myPageContext;
    private String pw;
    private LinearLayoutManager myPageParentsLayoutManager;
    private ArrayList<MyPageParentsRecyclerItem> myPageParentsRecyclerItems;
    private RecyclerView parentsRecycler;
    private MyPageParentsRecyclerViewAdapter myPageParentsRecyclerViewAdapter;

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
        changePwDialog = new ChangePwDialog(this, changePwCancelClickListener,changePwChangeClickListener);
        withdrawalDialog = new WithdrawalDialog(this, withdrawalCancelClickListener, withdrawalClickListener);
        changePwDialog.setCancelable(true);
        withdrawalDialog.setCancelable(true);

        parentsRecycler = (RecyclerView) findViewById(R.id.recycler_my_page_parents);
        myPageParentsLayoutManager = new LinearLayoutManager(getApplicationContext());
        myPageParentsRecyclerItems = new ArrayList<>();

        myPageParentsLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        parentsRecycler.setLayoutManager(myPageParentsLayoutManager);
        myPageParentsRecyclerViewAdapter = new MyPageParentsRecyclerViewAdapter(myPageParentsRecyclerItems);
        parentsRecycler.setAdapter(myPageParentsRecyclerViewAdapter);


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
                finish();
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
            pw = withdrawalDialog.getPw();
            presenter.doWithdrawal(pw);
        }
    };

    @Override
    public void setMyInform(String myName, int myAge) {
        myNameEdit.setText(myName);
        myAgeEdit.setText(Integer.toString(myAge));
    }

    @Override
    public void setParentInform(String parentName, int parentAge, boolean parentGender) {
        myPageParentsRecyclerItems.add(new MyPageParentsRecyclerItem(parentName, Integer.toString(parentAge), parentGender));
        myPageParentsRecyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void completeWithdrawal() {
        Toast.makeText(getApplicationContext(),"회원탈퇴 성공!",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MyPageActivity.this, SignInActivity.class);
        startActivity(intent);

        SharedPreferences preference = getApplicationContext().getSharedPreferences("PREFERENCE",MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.clear();
        finish();
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
