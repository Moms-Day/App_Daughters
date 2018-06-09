package momsday.app_daughters.SignUp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import momsday.app_daughters.R;

public class SignUpActivity extends AppCompatActivity {
    private ViewPager signUpViewPager;
    private Button signUpNextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUpViewPager = (ViewPager) findViewById(R.id.viewPager_signup);
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
                        break;
                }
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

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
                    signUpNextBtn.setText("회원가입");
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
}
