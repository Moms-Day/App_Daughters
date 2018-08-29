package momsday.app_daughters.Main.Rank;


import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioButton;
import momsday.app_daughters.CustomViewPager;
import momsday.app_daughters.R;

public class RankFragment extends Fragment {
    public RankFragment() {
    }
    private RadioButton rankHospitalRadiobtn, rankCareworkerRadiobtn;
    private ViewPager rankViewPager;
    private ImageButton rankEvaluateBtn;
    private RankEvaluateHospitalDialog rankEvaluateHospitalDialog;
    private RankEvaluateCareworkerDialog rankEvaluateCareworkerDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ConstraintLayout layout = (ConstraintLayout) inflater.inflate(R.layout.fragment_main_rank, container, false);
        rankHospitalRadiobtn = (RadioButton) layout.findViewById(R.id.radiobtn_main_rank_hospital);
        rankCareworkerRadiobtn = (RadioButton) layout.findViewById(R.id.radiobtn_main_rank_careworker);
        rankEvaluateBtn = (ImageButton) layout.findViewById(R.id.imagebtn_main_rank_evaluate);
        rankEvaluateHospitalDialog = new RankEvaluateHospitalDialog(getContext(),hospitalDialogCancelClickListener);
        rankEvaluateCareworkerDialog = new RankEvaluateCareworkerDialog(getContext(),careworkerDialogCancelClickListener);
        rankViewPager = (CustomViewPager) layout.findViewById(R.id.viewpager_rank);

        rankViewPager.setAdapter(new PagerAdapter(getChildFragmentManager()));
        rankViewPager.setCurrentItem(0);

        rankViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });


        rankViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                rankViewPager.getParent().requestDisallowInterceptTouchEvent(true);


            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        rankHospitalRadiobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Debug","rankHospitalRadioBtn checked");
                rankViewPager.setCurrentItem(0);
            }
        });

        rankCareworkerRadiobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Debug","rankCareworkerRadioBtn checked");
                rankViewPager.setCurrentItem(1);
            }
        });

        rankEvaluateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rankViewPager.getCurrentItem() == 0) {
                    rankEvaluateHospitalDialog.setCancelable(true);
                    rankEvaluateHospitalDialog.getWindow().setGravity(Gravity.CENTER);
                    rankEvaluateHospitalDialog.show();
                } else {
                 rankEvaluateCareworkerDialog.setCancelable(true);
                 rankEvaluateCareworkerDialog.getWindow().setGravity(Gravity.CENTER);
                 rankEvaluateCareworkerDialog.show();
                }
            }
        });

        return layout;
    }

    private View.OnClickListener hospitalDialogCancelClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            rankEvaluateHospitalDialog.dismiss();
        }
    };

    private View.OnClickListener careworkerDialogCancelClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            rankEvaluateCareworkerDialog.dismiss();
        }
    };

    public class PagerAdapter extends FragmentStatePagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new RankHospitalFragment();
                case 1:
                    return new RankCareworkerFragment();
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
