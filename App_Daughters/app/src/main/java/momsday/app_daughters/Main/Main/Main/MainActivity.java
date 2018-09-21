package momsday.app_daughters.Main.Main.Main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.signin.SignIn;

import java.util.ArrayList;

import momsday.app_daughters.CustomViewPager;
import momsday.app_daughters.Main.Chat.ChatFragment;
import momsday.app_daughters.Main.Main.MainContent.MainFragment;
import momsday.app_daughters.Main.Rank.RankFragment;
import momsday.app_daughters.MyPage.MyPageActivity;
import momsday.app_daughters.R;
import momsday.app_daughters.RequestConnection.RequestConnectionActivity;
import momsday.app_daughters.RequestConnection.RequestConnectionDialog;
import momsday.app_daughters.SignIn.SignInActivity;

public class MainActivity extends AppCompatActivity implements MainContract.View{

    private SectionsPagerAdapter mainSectionsPagerAdapter;
    private ArrayAdapter spinnerAdapter;
    private ViewPager mainViewPager;
    private ImageButton moreBtn;
    private RequestConnectionDialog requestConnectionDialog;
    public static Context MainContext;
    private MainContract.Presenter presenter;
    private Intent intent;
    private String parentId;
    private Spinner parentsSpinner;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainContext = getApplicationContext();
        mainSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        moreBtn = (ImageButton) findViewById(R.id.btn_main_more);
        parentsSpinner = (Spinner) findViewById(R.id.spinner_main_parents);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_layout);
        mainViewPager = (CustomViewPager) findViewById(R.id.viewPager_main);
        mainViewPager.setAdapter(mainSectionsPagerAdapter);
        presenter = new MainPresenter();
        presenter.setView(this);
        presenter.getInform();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mainSectionsPagerAdapter.notifyDataSetChanged();

                swipeRefreshLayout.setRefreshing(false);
            }
        });
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs_main);

        TextView tv1 = (TextView)(((LinearLayout)((LinearLayout)tabLayout.getChildAt(0)).getChildAt(0)).getChildAt(1));
        tv1.setScaleY(-1);
        TextView tv2 = (TextView)(((LinearLayout)((LinearLayout)tabLayout.getChildAt(0)).getChildAt(1)).getChildAt(1));
        tv2.setScaleY(-1);
        TextView tv3 = (TextView)(((LinearLayout)((LinearLayout)tabLayout.getChildAt(0)).getChildAt(2)).getChildAt(1));
        tv3.setScaleY(-1);

        mainViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mainViewPager));

        moreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final PopupMenu popupMenu = new PopupMenu(getApplicationContext(), view);
                getMenuInflater().inflate(R.menu.menu_main,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch(menuItem.getItemId()) {
                            case R.id.btn_menu_my_page:
                                intent = new Intent(MainActivity.this, MyPageActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.btn_menu_request:
                                intent = new Intent(MainActivity.this, RequestConnectionActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.btn_menu_logout:
                                Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                                SharedPreferences preferences = getApplicationContext().getSharedPreferences("PREFERENCE",MODE_PRIVATE);
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.clear();
                                editor.apply();
                                startActivity(intent);
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();

            }
        });
    }

    @Override
    public void successGetInform(final ArrayList<MainModel> parentsInform) {
        //todo spinner
        ArrayList<String> names = new ArrayList<>();
        for(int i=0;i<parentsInform.size();i++) {
            names.add(i,parentsInform.get(i).getName());
        }
        spinnerAdapter = new ArrayAdapter(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,names);
        parentsSpinner.setAdapter(spinnerAdapter);
        SharedPreferences preference = getApplicationContext().getSharedPreferences("PREFERENCE",MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.putString("parentId",parentsInform.get(0).getId());
        editor.apply();
        parentsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SharedPreferences preference = getApplicationContext().getSharedPreferences("PREFERENCE",MODE_PRIVATE);
                SharedPreferences.Editor editor = preference.edit();
                editor.putString("parentId",parentsInform.get(i).getId());
                editor.apply();
                //todo refresh mainContentFragment
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void showRequestConnectDialog() {
        requestConnectionDialog = new RequestConnectionDialog(this, moveRankClickListener, moveConnectClickListener);
        requestConnectionDialog.setCancelable(false);
        requestConnectionDialog.show();
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getItemPosition(@NonNull Object object) {
            return POSITION_NONE;
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
