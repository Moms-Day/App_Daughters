package momsday.app_daughters.HospitalInformation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import momsday.app_daughters.R;

public class HospitalInformationActivity extends AppCompatActivity implements HospitalInformationContract.View {
    private TextView hospitalNameText, hospitalPhoneNumText, hospitalLocationText, hospitalIntroductionText, hospitalFacilityScoreText, hospitalMealScoreText, hospitalScheduleScoreText, hospitalCostScoreText, hospitalServiceScoreText, hospitalFirstReviewText, hospitalSecondReviewText, hospitalThirdReviewText;
    private RatingBar hospitalTotalScoreRatingBar;
    private ImageView hospitalImage;
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
        hospitalImage = (ImageView) findViewById(R.id.image_hospital_information);

        presenter = new HospitalInformationPresenter();
        presenter.setView(this);
        Intent intent = getIntent();
        hospitalCode = intent.getStringExtra("hospitalCode");

        presenter.getHospitalInform(hospitalCode);
    }


    @Override
    public void setHospitalInform(String name, String phoneNumber, String location, String introduction, float facilityScore, float mealScore, float scheduleScore, float costScore, float serviceScore, String firstReview, String secondReview, String thirdReview, float overall, String imagePath) {
        hospitalNameText.setText(name);
        hospitalPhoneNumText.setText(phoneNumber);
        hospitalLocationText.setText(location);
        hospitalIntroductionText.setText(introduction);
        hospitalFacilityScoreText.setText(Float.toString(facilityScore));
        hospitalMealScoreText.setText(Float.toString(mealScore));
        hospitalScheduleScoreText.setText(Float.toString(scheduleScore));
        hospitalCostScoreText.setText(Float.toString(costScore));
        hospitalServiceScoreText.setText(Float.toString(serviceScore));
        hospitalFirstReviewText.setText(firstReview);
        hospitalSecondReviewText.setText(secondReview);
        hospitalThirdReviewText.setText(thirdReview);
        hospitalTotalScoreRatingBar.setRating(overall);
        Glide.with(getApplicationContext()).load(imagePath).into(hospitalImage);

    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(getApplicationContext(), "오류", Toast.LENGTH_SHORT).show();
    }
}
