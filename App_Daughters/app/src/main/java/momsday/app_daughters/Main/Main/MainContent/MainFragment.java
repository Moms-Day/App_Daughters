package momsday.app_daughters.Main.Main.MainContent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import momsday.app_daughters.Main.Main.MainContent.Form;
import momsday.app_daughters.Main.Main.MainContent.MainContentContract;
import momsday.app_daughters.Main.Main.MainContent.MainContentFragment;
import momsday.app_daughters.Main.Main.MainContent.MainContentPresenter;
import momsday.app_daughters.R;


public class MainFragment extends Fragment implements MainContentContract.View{
    public MainFragment() {
    }

    private View view;
    private ViewPager mainContentViewPager;
    private ScrollView mainContentScrollView;
    private MainContentFragment mainContentFragment;
    private Form twoDaysAgoForm, yesterdayForm, todayForm;
    private MainContentContract.Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        presenter = new MainContentPresenter();
        presenter.setView(this);
        presenter.getMainModel();


        view = inflater.inflate(R.layout.fragment_main_main, null);
        mainContentViewPager = (ViewPager) view.findViewById(R.id.viewPager_main_content);
        mainContentScrollView = (ScrollView) view.findViewById(R.id.scroll_main_content);
        mainContentViewPager.setAdapter(new pagerAdapter(getChildFragmentManager()));
        mainContentViewPager.setCurrentItem(2);
        mainContentFragment = new MainContentFragment();


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
            public void onPageSelected(int position) {
                if (mainContentViewPager.getCurrentItem() == 0) {
                    Log.d("Debug", "0");
                } else if (mainContentViewPager.getCurrentItem() == 1) {
                    Log.d("Debug", "1");
                } else if (mainContentViewPager.getCurrentItem() == 2) {
                    Log.d("Debug", "2");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }

    @Override
    public void successGetMainModel() {
        mainContentFragment.setForm(presenter.getForm(mainContentViewPager.getCurrentItem()));
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(getContext(),"오류",Toast.LENGTH_SHORT).show();
    }

    private class pagerAdapter extends FragmentStatePagerAdapter {

        public pagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new MainContentFragment();
        }

        @Override
        public int getCount() {
            return 3;
        }
    }


}
