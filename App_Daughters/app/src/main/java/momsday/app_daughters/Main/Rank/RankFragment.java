package momsday.app_daughters.Main.Rank;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

import momsday.app_daughters.CustomViewPager;
import momsday.app_daughters.Main.Rank.RankCareworker.RankCareworkerFragment;
import momsday.app_daughters.Main.Rank.RankEvaluateHospital.RankEvaluateHospitalDialog;
import momsday.app_daughters.Main.Rank.RankEvaluteCareworker.RankEvaluateCareworkerDialog;
import momsday.app_daughters.Main.Rank.RankHospital.RankHospitalFragment;
import momsday.app_daughters.R;

import static momsday.app_daughters.Main.Rank.RankHospital.RankHospitalFragment.RankHospitalContext;

public class RankFragment extends Fragment implements RankContract.View {
    public RankFragment() {
    }

    private RadioButton rankHospitalRadiobtn, rankCareworkerRadiobtn;
    private ViewPager rankViewPager;
    private ImageButton rankEvaluateBtn;
    private RankEvaluateHospitalDialog rankEvaluateHospitalDialog;
    private RankEvaluateCareworkerDialog rankEvaluateCareworkerDialog;
    private RankContract.Presenter presenter;
    public static Context RankContext;
    private int hospitalFacilityScore, hospitalMealScore, hospitalScheduleScore, hospitalCostScore, hospitalServiceScore, careworkerSincerityScore, careworkerKindnessScore;
    private float hospitalTotalScore, careworkerTotalScore;
    private String hospitalReview, careworkerReview, hospitalCode, careworkerId;
    private SharedPreferences preferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RankContext = getContext();
        presenter = new RankPresenter();
        presenter.setView(this);
        ConstraintLayout layout = (ConstraintLayout) inflater.inflate(R.layout.fragment_main_rank, container, false);
        rankHospitalRadiobtn = (RadioButton) layout.findViewById(R.id.radiobtn_main_rank_hospital);
        rankCareworkerRadiobtn = (RadioButton) layout.findViewById(R.id.radiobtn_main_rank_careworker);
        rankEvaluateBtn = (ImageButton) layout.findViewById(R.id.imagebtn_main_rank_evaluate);
        rankEvaluateHospitalDialog = new RankEvaluateHospitalDialog(getContext(), hospitalDialogCancelClickListener, hospitalDialogEvaluateClickListener);
        rankEvaluateCareworkerDialog = new RankEvaluateCareworkerDialog(getContext(), careworkerDialogCancelClickListener, careworkerDialogEvaluateClickListener);
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
                rankViewPager.setCurrentItem(0);
            }
        });

        rankCareworkerRadiobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rankViewPager.setCurrentItem(1);
            }
        });

        rankEvaluateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                preferences = getContext().getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE);
                hospitalCode = preferences.getString("hospitalCode", "");
                careworkerId = preferences.getString("careworkerId", "");
                if (rankViewPager.getCurrentItem() == 0 && !TextUtils.isEmpty(hospitalCode)) {
                    rankEvaluateHospitalDialog.setCancelable(true);
                    rankEvaluateHospitalDialog.getWindow().setGravity(Gravity.CENTER);
                    rankEvaluateHospitalDialog.show();
                } else if (rankViewPager.getCurrentItem() == 1 && !TextUtils.isEmpty(careworkerId)) {
                    rankEvaluateCareworkerDialog.setCancelable(true);
                    rankEvaluateCareworkerDialog.getWindow().setGravity(Gravity.CENTER);
                    rankEvaluateCareworkerDialog.show();
                } else {
                    Toast.makeText(getContext(),"요양보호사와 연결해주세요.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return layout;
    }

    private View.OnClickListener hospitalDialogEvaluateClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            hospitalFacilityScore = rankEvaluateHospitalDialog.getHospitalFacilityScore();
            hospitalMealScore = rankEvaluateHospitalDialog.getHospitalMealScore();
            hospitalScheduleScore = rankEvaluateHospitalDialog.getHospitalScheduleScore();
            hospitalCostScore = rankEvaluateHospitalDialog.getHospitalCostScore();
            hospitalServiceScore = rankEvaluateHospitalDialog.getHospitalServiceScore();
            hospitalTotalScore = rankEvaluateHospitalDialog.getHospitalTotalScore();
            hospitalReview = rankEvaluateHospitalDialog.getHospitalReview();
            Log.d("Debug", "view : " + hospitalFacilityScore + hospitalMealScore + hospitalScheduleScore + hospitalCostScore + hospitalServiceScore + hospitalTotalScore + hospitalReview);
            presenter.evaluateHospital(hospitalFacilityScore, hospitalMealScore, hospitalScheduleScore, hospitalCostScore, hospitalServiceScore, hospitalTotalScore, hospitalReview);
        }
    };

    private View.OnClickListener careworkerDialogEvaluateClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            careworkerSincerityScore = rankEvaluateCareworkerDialog.getCareworkerSincerityScore();
            careworkerKindnessScore = rankEvaluateCareworkerDialog.getCareworkerKindnessScore();
            careworkerTotalScore = rankEvaluateCareworkerDialog.getCareworkerTotalScore();
            careworkerReview = rankEvaluateCareworkerDialog.getCareworkerReview();
            presenter.evaluateCareworker(careworkerSincerityScore, careworkerKindnessScore, careworkerTotalScore, careworkerReview);
        }
    };

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

    @Override
    public void showEvaluateHospitalSuccessMessage() {
        Toast.makeText(getContext(), "성공", Toast.LENGTH_SHORT).show();
        rankEvaluateHospitalDialog.dismiss();
    }

    @Override
    public void showEvaluateCareworkerSuccessMessage() {
        Toast.makeText(getContext(), "성공", Toast.LENGTH_SHORT).show();
        rankEvaluateCareworkerDialog.dismiss();
    }

    @Override
    public void showErrorMEssage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

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
