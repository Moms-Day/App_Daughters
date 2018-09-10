package momsday.app_daughters.Main.Rank.RankEvaluteCareworker;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.Rating;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import momsday.app_daughters.R;

public class RankEvaluateCareworkerDialog extends Dialog {
    private TextView evaluateCareworkerDialogCancelText, evaluateCareworkerDialogEvaluateText, careworkerNameText;
    private View.OnClickListener careworkerDialogCancelClickListener, careworkerDialogEvaluateClickListener;
    private RadioGroup evaluateCareworkerSincerityRadioGrp, evaluateCareworkerKindnessRadioGrp;
    private int careworkerSincerityScore, careworkerKindnessScore;
    private float careworkerTotalScore;
    private String careworkerReview, careworkerName;
    private RatingBar careworkerTotalScoreRatingBar;
    private EditText careworkerReviewEdit;
    private SharedPreferences preferences;

    public RankEvaluateCareworkerDialog(@NonNull Context context, View.OnClickListener careworkerDialogCancelClickListener, View.OnClickListener careworkerDialogevaluateClickListener) {
        super(context);
        this.careworkerDialogCancelClickListener = careworkerDialogCancelClickListener;
        this.careworkerDialogEvaluateClickListener = careworkerDialogevaluateClickListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);
        setContentView(R.layout.dialog_rank_evaluate_careworker);

        evaluateCareworkerDialogCancelText = (TextView) findViewById(R.id.text_rank_evaluate_careworker_cancel);
        evaluateCareworkerDialogEvaluateText = (TextView) findViewById(R.id.text_rank_evaluate_careworker_ok);
        evaluateCareworkerSincerityRadioGrp = (RadioGroup) findViewById(R.id.radiogrp_rank_evaluate_careworker_sincerity);
        evaluateCareworkerKindnessRadioGrp = (RadioGroup) findViewById(R.id.radiogrp_rank_evaluate_careworker_kindness);
        careworkerTotalScoreRatingBar = (RatingBar) findViewById(R.id.ratingbar_rank_evaluate_careworker_score);
        careworkerReviewEdit = (EditText) findViewById(R.id.edit_rank_evaluate_careworker_review);

        preferences = getContext().getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE);
        careworkerName = preferences.getString("careworkerName", "");
        careworkerNameText.setText(careworkerName);

        evaluateCareworkerSincerityRadioGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radiobtn_rank_evaluate_careworker_sincerity_1:
                        careworkerSincerityScore = 1;
                        break;
                    case R.id.radiobtn_rank_evaluate_careworker_sincerity_2:
                        careworkerSincerityScore = 2;
                        break;
                    case R.id.radiobtn_rank_evaluate_careworker_sincerity_3:
                        careworkerSincerityScore = 3;
                        break;
                    case R.id.radiobtn_rank_evaluate_careworker_sincerity_4:
                        careworkerSincerityScore = 4;
                        break;
                    case R.id.radiobtn_rank_evaluate_careworker_sincerity_5:
                        careworkerSincerityScore = 5;
                        break;
                }
            }
        });
        evaluateCareworkerKindnessRadioGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radiobtn_rank_evaluate_careworker_kindness_1:
                        careworkerKindnessScore = 1;
                        break;
                    case R.id.radiobtn_rank_evaluate_careworker_kindness_2:
                        careworkerKindnessScore = 2;
                        break;
                    case R.id.radiobtn_rank_evaluate_careworker_kindness_3:
                        careworkerKindnessScore = 3;
                        break;
                    case R.id.radiobtn_rank_evaluate_careworker_kindness_4:
                        careworkerKindnessScore = 4;
                        break;
                    case R.id.radiobtn_rank_evaluate_careworker_kindness_5:
                        careworkerKindnessScore = 5;
                        break;
                }
            }
        });

        if(careworkerDialogCancelClickListener != null) {
            evaluateCareworkerDialogCancelText.setOnClickListener(careworkerDialogCancelClickListener);
        }
        if(careworkerDialogEvaluateClickListener != null) {
            evaluateCareworkerDialogEvaluateText.setOnClickListener(careworkerDialogEvaluateClickListener);
        }


    }

    public int getCareworkerSincerityScore() {
        return careworkerSincerityScore;
    }

    public int getCareworkerKindnessScore() {
        return careworkerKindnessScore;
    }

    public float getCareworkerTotalScore() {
        careworkerTotalScore = careworkerTotalScoreRatingBar.getRating();
        return careworkerTotalScore;
    }

    public String getCareworkerReview() {
        careworkerReview = careworkerReviewEdit.getText().toString();
        return careworkerReview;
    }
}
