package momsday.app_daughters.Main.Main;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import momsday.app_daughters.CustomViewPager;
import momsday.app_daughters.Main.Chat.ChatFragment;
import momsday.app_daughters.Main.Rank.RankFragment;
import momsday.app_daughters.R;
import momsday.app_daughters.RequestConnection.RequestConnectionActivity;
import momsday.app_daughters.RequestConnection.RequestConnectionDialog;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mainSectionsPagerAdapter;
    private ViewPager mainViewPager;
    private RequestConnectionDialog requestConnectionDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mainViewPager = (CustomViewPager) findViewById(R.id.viewPager_main);
        mainViewPager.setAdapter(mainSectionsPagerAdapter);
        requestConnectionDialog = new RequestConnectionDialog(this, moveRankClickListener, moveConnectClickListener);
        requestConnectionDialog.show();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs_main);

        TextView tv1 = (TextView)(((LinearLayout)((LinearLayout)tabLayout.getChildAt(0)).getChildAt(0)).getChildAt(1));
        tv1.setScaleY(-1);
        TextView tv2 = (TextView)(((LinearLayout)((LinearLayout)tabLayout.getChildAt(0)).getChildAt(1)).getChildAt(1));
        tv2.setScaleY(-1);
        TextView tv3 = (TextView)(((LinearLayout)((LinearLayout)tabLayout.getChildAt(0)).getChildAt(2)).getChildAt(1));
        tv3.setScaleY(-1);

        mainViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mainViewPager));
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new MainFragment();
                case 1:
                    return new ChatFragment();
                case 2:
                    return new RankFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    private View.OnClickListener moveRankClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            requestConnectionDialog.dismiss();
            mainViewPager.setCurrentItem(2);
        }
    };

    private View.OnClickListener moveConnectClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            requestConnectionDialog.dismiss();
            Intent intent = new Intent(MainActivity.this, RequestConnectionActivity.class);
            startActivity(intent);
        }
    };
}
