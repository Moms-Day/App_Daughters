package momsday.app_daughters.SignUp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import momsday.app_daughters.R;
import momsday.app_daughters.SignIn.SignInActivity;

public class SignUpActivity extends AppCompatActivity {
    private ViewPager signUpViewPager;
    private CircleAnimIndicator circleAnimIndicator;
    private List<String> numberList;
    private Button signUpNextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUpViewPager = (ViewPager) findViewById(R.id.viewPager_signup);
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
                        signUpNextBtn.setText("회원가입");
                        signUpNextBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                                startActivity(intent);
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

        initData();
        initIndicaotor();
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

    private void initData() {

        numberList = new ArrayList<>();
        numberList.add("1");
        numberList.add("2");

    }

    private void initIndicaotor() {

        //원사이의 간격
        circleAnimIndicator.setItemMargin(15);
        //애니메이션 속도
        circleAnimIndicator.setAnimDuration(300);
        //indecator 생성
        circleAnimIndicator.createDotPanel(numberList.size(), R.drawable.indicator_non, R.drawable.indicator_on);
    }
}
