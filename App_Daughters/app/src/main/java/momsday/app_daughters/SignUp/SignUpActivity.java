package momsday.app_daughters.SignUp;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import momsday.app_daughters.R;
import momsday.app_daughters.SignIn.SignInActivity;

public class SignUpActivity extends AppCompatActivity implements SignUpContract.SignUpView{
    private SignUpContract.SignUpPresenter signUpPresenter;
    String id,pw,phoneNumber,certifyCode,name, age, pwCheck;
    private ViewPager signUpViewPager;
    private CircleAnimIndicator circleAnimIndicator;
    private List<String> numberList;
    private Button signUpNextBtn;
    public static Context signUpContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUpContext = getApplicationContext();
        signUpViewPager = (ViewPager) findViewById(R.id.viewPager_signup);
        signUpPresenter = new SignUpPresenter();
        signUpPresenter.setView(this);
        circleAnimIndicator = (CircleAnimIndicator) findViewById(R.id.circleAnimIndicator);
        signUpNextBtn = (Button) findViewById(R.id.btn_signup_next);

        signUpViewPager.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        signUpViewPager.setCurrentItem(0);

        signUpViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position) {
                    case 0:
                        signUpNextBtn.setText("다음");
                        signUpNextBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                signUpViewPager.setCurrentItem(1);
                            }
                        });
                        break;
                    case 1:
                        SecondFragment.signUpCertifyCodeBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                SecondFragment.signUpCertifyCodeEdit.setText(generateCode());
                            }
                        });
                        signUpNextBtn.setText("회원가입");
                        signUpNextBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                id = FirstFragment.signUpIdEdit.getText().toString();
                                pw = FirstFragment.signUpPwEdit.getText().toString();
                                pwCheck = FirstFragment.signUpPwCheckEdit.getText().toString();
                                phoneNumber = SecondFragment.signUpPhoneNumberEdit.getText().toString();
                                certifyCode = SecondFragment.signUpCertifyCodeEdit.getText().toString();
                                name = SecondFragment.signUpNameEdit.getText().toString();
                                age = SecondFragment.signUpAgeEdit.getText().toString();
                                if(pw.equals(pwCheck)) {
                                    signUpPresenter.doSignUp(id, pw, phoneNumber, certifyCode, name, age);
                                }
                                else {
                                    Toast.makeText(getApplicationContext(),"비밀번호 확인 오류",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        break;
                }
            }

            @Override
            public void onPageSelected(int position) {
                circleAnimIndicator.selectDot(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        init();
    }

    @Override
    public void startSignInActivity() {
        Toast.makeText(getApplicationContext(),"회원가입 성공!",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(getApplicationContext(),"오류",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showIdErrorMessage() {
        Toast.makeText(getApplicationContext(),"id중복",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    private class pagerAdapter extends FragmentStatePagerAdapter {
        public pagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new FirstFragment();
                case 1:
                    return new SecondFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }


    private void init() {

        numberList = new ArrayList<>();
        numberList.add("1");
        numberList.add("2");
        //원사이의 간격
        circleAnimIndicator.setItemMargin(15);
        //애니메이션 속도
        circleAnimIndicator.setAnimDuration(300);
        //indecator 생성
        circleAnimIndicator.createDotPanel(numberList.size(), R.drawable.indicator_non, R.drawable.indicator_on);
    }

    private String generateCode() {
        int certCharLength = 8;
        final char[] characterTable = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
                'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
                'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
        Random random = new Random(System.currentTimeMillis());
        int tablelength = characterTable.length;
        StringBuffer buf = new StringBuffer();

        for(int i = 0; i < certCharLength; i++) {
            buf.append(characterTable[random.nextInt(tablelength)]);
        }

        return buf.toString();
    }
}
