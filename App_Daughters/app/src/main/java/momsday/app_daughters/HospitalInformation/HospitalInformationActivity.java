package momsday.app_daughters.HospitalInformation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import momsday.app_daughters.CareworkerInformation.CareworkerInformationPresenter;
import momsday.app_daughters.R;

public class HospitalInformationActivity extends AppCompatActivity implements HospitalInformationContract.View {
    private TextView hospitalNameText, hospitalPhoneNumText, hospitalLocationText, hospitalIntroductionText, hospitalFacilityScoreText, hospitalMealScoreText, hospitalScheduleScoreText, hospitalCostScoreText, hospitalServiceScoreText, hospitalFirstReviewText, hospitalSecondReviewText, hospitalThirdReviewText;
    private RatingBar hospitalTotalScoreRatingBar;
    private HospitalInformationContract.Presenter presenter;
    private String hospitalCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_information);

        hospitalNameText = (TextView) findViewById(R.id.text_hospital_information_name);
        hospitalPhoneNumText = (TextView) findViewById(R.id.text_hospital_information_call);
        hospitalLocationText = (TextView) findViewById(R.id.text_hospital_information_location);
        hospitalIntroductionText = (TextView) findViewById(R.id.text_hospital_information_introduction);
        hospitalFacilityScoreText = (TextView) findViewById(R.id.text_hospital_information_facility_score);
        hospitalMealScoreText = (TextView) findViewById(R.id.text_hospital_information_meal_score);
        hospitalScheduleScoreText = (TextView) findViewById(R.id.text_hospital_information_schedule_score);
        hospitalCostScoreText = (TextView) findViewById(R.id.text_hospital_information_cost_score);
        hospitalServiceScoreText = (TextView) findViewById(R.id.text_hospital_information_service_score);
        hospitalFirstReviewText = (TextView) findViewById(R.id.text_hospital_information_first_review);
        hospitalSecondReviewText = (TextView) findViewById(R.id.text_hospital_information_second_review);
        hospitalThirdReviewText = (TextView) findViewById(R.id.text_hospital_information_third_review);
        hospitalTotalScoreRatingBar = (RatingBar) findViewById(R.id.ratingbar_hospital_information_total_score);

        presenter = new HospitalInformationPresenter();
        presenter.setView(this);
        Intent intent = getIntent();
        hospitalCode = intent.getStringExtra("hospitalCode");

        presenter.getHospitalInform(hospitalCode);
    }


    @Override
    public void setHospitalInform(String name, String phoneNumber, String location, String introduction, String facilityScore, String mealScore, String scheduleScore, String costScore, String serviceScore, String firstReview, String secondReview, String thirdReview, float overall) {
        hospitalNameText.setText(name);
        hospitalPhoneNumText.setText(phoneNumber);
        hospitalLocationText.setText(location);
        hospitalIntroductionText.setText(introduction);
        hospitalFacilityScoreText.setText(facilityScore);
        hospitalMealScoreText.setText(mealScore);
        hospitalScheduleScoreText.setText(scheduleScore);
        hospitalCostScoreText.setText(costScore);
        hospitalServiceScoreText.setText(serviceScore);
        hospitalFirstReviewText.setText(firstReview);
        hospitalSecondReviewText.setText(secondReview);
        hospitalThirdReviewText.setText(thirdReview);
        hospitalTotalScoreRatingBar.setRating(overall);
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(getApplicationContext(), "오류", Toast.LENGTH_SHORT).show();
    }
}
