package momsday.app_daughters.Main.Main.MainContent;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import momsday.app_daughters.R;


public class MainFragment extends Fragment {
    public MainFragment() {
    }

    private View view;
    private ViewPager mainContentViewPager;
    private pagerAdapter viewPagerAdapter;
    public static Context MainContentContext;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MainContentContext = getContext();

        view = inflater.inflate(R.layout.fragment_main_main, null);
        mainContentViewPager = (ViewPager) view.findViewById(R.id.viewPager_main_content);
        viewPagerAdapter = new pagerAdapter(getChildFragmentManager());
        mainContentViewPager.setAdapter(viewPagerAdapter);
        mainContentViewPager.setCurrentItem(2);

        mainContentViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        mainContentViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mainContentViewPager.getParent().requestDisallowInterceptTouchEvent(true);
            }
            @Override
            public void onPageSelected(int position) { }

            @Override
            public void onPageScrollStateChanged(int state) { }
        });
        return view;
    }

    private class pagerAdapter extends FragmentStatePagerAdapter {

        public pagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            MainContentFragment mainContentFragment = new MainContentFragment();
            mainContentFragment.setPosition(position);
            return mainContentFragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        viewPagerAdapter.notifyDataSetChanged();
    }
}
