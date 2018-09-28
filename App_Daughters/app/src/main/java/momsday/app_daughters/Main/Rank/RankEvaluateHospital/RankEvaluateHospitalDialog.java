package momsday.app_daughters.Main.Rank.RankEvaluateHospital;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import momsday.app_daughters.R;

public class RankEvaluateHospitalDialog extends Dialog {

    private View.OnClickListener hospitalDialogCancelClickListener, evaluateHospitalClickListener;
    private TextView evaluateHospitalDialogCancelText, evaluateHospitalDialogEvaluateText, hospitalNameText;
    private RadioGroup evaluateHospitalFacilityRadioGrp, evaluateHospitalMealRadioGrp, evaluateHospitalScheduleRadioGrp, evaluateHospitalCostRadioGrp, evaluateHospitalServiceRadioGrp;
    private int hospitalFacilityScore, hospitalMealScore, hospitalScheduleScore, hospitalCostScore, hospitalServiceScore;
    private float hospitalTotalScore;
    private RatingBar evaluateHospitalTotalScoreRatingBar;
    private String hospitalReview, hospitalName;
    private EditText evaluateHospitalReviewEdit;
    private SharedPreferences preferences;

    public RankEvaluateHospitalDialog(@NonNull Context context, View.OnClickListener hospitalDialogCancelClickListener, View.OnClickListener evaluateHospitalClickListener) {
        super(context);
        this.hospitalDialogCancelClickListener = hospitalDialogCancelClickListener;
        this.evaluateHospitalClickListener = evaluateHospitalClickListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);
        setContentView(R.layout.dialog_rank_evaluate_hospital);

        hospitalNameText = (TextView) findViewById(R.id.text_rank_evaluate_hospital_name);
        evaluateHospitalDialogCancelText = (TextView) findViewById(R.id.text_rank_evaluate_hospital_cancel);
        evaluateHospitalDialogEvaluateText = (TextView) findViewById(R.id.text_rank_evaluate_hospital_ok);
        evaluateHospitalFacilityRadioGrp = (RadioGroup) findViewById(R.id.radiogrp_rank_evaluate_hospital_facility);
        evaluateHospitalMealRadioGrp = (RadioGroup) findViewById(R.id.radiogrp_rank_evaluate_hospital_meal);
        evaluateHospitalScheduleRadioGrp = (RadioGroup) findViewById(R.id.radiogrp_rank_evaluate_hospital_schedule);
        evaluateHospitalCostRadioGrp = (RadioGroup) findViewById(R.id.radiogrp_rank_evaluate_hospital_cost);
        evaluateHospitalServiceRadioGrp = (RadioGroup) findViewById(R.id.radiogrp_rank_evaluate_hospital_service);
        evaluateHospitalTotalScoreRatingBar = (RatingBar) findViewById(R.id.ratingbar_rank_evaluate_hospital_score);
        evaluateHospitalReviewEdit = (EditText) findViewById(R.id.edit_rank_evaluate_hospital_review);

        preferences = getContext().getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE);
        hospitalName = preferences.getString("hospitalName", "");
        hospitalNameText.setText(hospitalName);

        if (hospitalDialogCancelClickListener != null) {
            evaluateHospitalDialogCancelText.setOnClickListener(hospitalDialogCancelClickListener);
        }
        if (evaluateHospitalClickListener != null) {
            evaluateHospitalDialogEvaluateText.setOnClickListener(evaluateHospitalClickListener);
        }

        evaluateHospitalFacilityRadioGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radiobtn_rank_evaluate_hospital_facility_1:
                        hospitalFacilityScore = 1;
                        break;
                    case R.id.radiobtn_rank_evaluate_hospital_facility_2:
                        hospitalFacilityScore = 2;
                        break;
                    case R.id.radiobtn_rank_evaluate_hospital_facility_3:
                        hospitalFacilityScore = 3;
                        break;
                    case R.id.radiobtn_rank_evaluate_hospital_facility_4:
                        hospitalFacilityScore = 4;
                        break;
                    case R.id.radiobtn_rank_evaluate_hospital_facility_5:
                        hospitalFacilityScore = 5;
                        break;
                }
            }
        });

        evaluateHospitalMealRadioGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radiobtn_rank_evaluate_hospital_meal_1:
                        hospitalMealScore = 1;
                        break;
                    case R.id.radiobtn_rank_evaluate_hospital_meal_2:
                        hospitalMealScore = 2;
                        break;
                    case R.id.radiobtn_rank_evaluate_hospital_meal_3:
                        hospitalMealScore = 3;
                        break;
                    case R.id.radiobtn_rank_evaluate_hospital_meal_4:
                        hospitalMealScore = 4;
                        break;
                    case R.id.radiobtn_rank_evaluate_hospital_meal_5:
                        hospitalMealScore = 5;
                        break;
                }
            }
        });

        evaluateHospitalScheduleRadioGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radiobtn_rank_evaluate_hospital_schedule_1:
                        hospitalScheduleScore = 1;
                        break;
                    case R.id.radiobtn_rank_evaluate_hospital_schedule_2:
                        hospitalScheduleScore = 2;
                        break;
                    case R.id.radiobtn_rank_evaluate_hospital_schedule_3:
                        hospitalScheduleScore = 3;
                        break;
                    case R.id.radiobtn_rank_evaluate_hospital_schedule_4:
                        hospitalScheduleScore = 4;
                        break;
                    case R.id.radiobtn_rank_evaluate_hospital_schedule_5:
                        hospitalScheduleScore = 5;
                        break;
                }
            }
        });

        evaluateHospitalCostRadioGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radiobtn_rank_evaluate_hospital_cost_1:
                        hospitalCostScore = 1;
                        break;
                    case R.id.radiobtn_rank_evaluate_hospital_cost_2:
                        hospitalCostScore = 2;
                        break;
                    case R.id.radiobtn_rank_evaluate_hospital_cost_3:
                        hospitalCostScore = 3;
                        break;
                    case R.id.radiobtn_rank_evaluate_hospital_cost_4:
                        hospitalCostScore = 4;
                        break;
                    case R.id.radiobtn_rank_evaluate_hospital_cost_5:
                        hospitalCostScore = 5;
                        break;
                }
            }
        });


        evaluateHospitalServiceRadioGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radiobtn_rank_evaluate_hospital_service_1:
                        hospitalServiceScore = 1;
                        break;
                    case R.id.radiobtn_rank_evaluate_hospital_service_2:
                        hospitalServiceScore = 2;
                        break;
                    case R.id.radiobtn_rank_evaluate_hospital_service_3:
                        hospitalServiceScore = 3;
                        break;
                    case R.id.radiobtn_rank_evaluate_hospital_service_4:
                        hospitalServiceScore = 4;
                        break;
                    case R.id.radiobtn_rank_evaluate_hospital_service_5:
                        hospitalServiceScore = 5;
                        break;
                }
            }
        });
    }

    public int getHospitalFacilityScore() {
        return hospitalFacilityScore;
    }

    public int getHospitalMealScore() {
        return hospitalMealScore;
    }

    public int getHospitalScheduleScore() {
        return hospitalScheduleScore;
    }

    public int getHospitalCostScore() {
        return hospitalCostScore;
    }

    public int getHospitalServiceScore() {
        return hospitalServiceScore;
    }

    public float getHospitalTotalScore() {
        hospitalTotalScore = evaluateHospitalTotalScoreRatingBar.getRating();
        return hospitalTotalScore;
    }

    public String getHospitalReview() {
        hospitalReview = evaluateHospitalReviewEdit.getText().toString();
        return hospitalReview;
    }
}
