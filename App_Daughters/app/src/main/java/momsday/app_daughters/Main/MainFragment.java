package momsday.app_daughters.Main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import momsday.app_daughters.R;
import momsday.app_daughters.SignUp.FirstFragment;


public class MainFragment extends Fragment {
    public MainFragment() { }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_main,null);

        ViewPager mainMainViewPager = (ViewPager) view.findViewById(R.id.viewPager_main_inform);
        mainMainViewPager.setAdapter(new pagerAdapter(getChildFragmentManager()));

        return view;
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
            return 30;
        }
    }
}
