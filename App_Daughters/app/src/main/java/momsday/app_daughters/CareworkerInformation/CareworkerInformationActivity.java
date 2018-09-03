package momsday.app_daughters.CareworkerInformation;

import android.content.Context;
import android.content.Intent;
import android.media.Rating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import momsday.app_daughters.R;

public class CareworkerInformationActivity extends AppCompatActivity implements CareworkerInformationContract.View{
    private TextView careworkerNameText, careworkerHospitalText, careworkerPatientNumberText, careworkerCareerText, careworkerIntroductionText, careworkerSincerityScore, careworkerKindnessScore, careworkerFirstReview, careworkerSecondReview, careworkerThirdReview;
    private RatingBar careworkerOverallRatingBar;
    private String careworkerId;
    private CareworkerInformationContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_careworker_information);
        careworkerNameText = (TextView) findViewById(R.id.text_careworker_information_name);
        careworkerHospitalText = (TextView) findViewById(R.id.text_careworker_information_hospital_name);
        careworkerPatientNumberText = (TextView) findViewById(R.id.text_careworker_information_patient_number);
        careworkerCareerText = (TextView) findViewById(R.id.text_careworker_information_career);
        careworkerIntroductionText = (TextView) findViewById(R.id.text_careworker_information_introduction);
        careworkerSincerityScore = (TextView) findViewById(R.id.text_careworker_information_sincerity_score);
        careworkerKindnessScore = (TextView) findViewById(R.id.text_careworker_information_kindness_score);
        careworkerFirstReview = (TextView) findViewById(R.id.text_careworker_information_first_review);
        careworkerSecondReview = (TextView) findViewById(R.id.text_careworker_information_second_review);
        careworkerThirdReview = (TextView) findViewById(R.id.text_careworker_information_third_review);
        careworkerOverallRatingBar = (RatingBar) findViewById(R.id.ratingbar_careworker_information_total_score);
        presenter = new CareworkerInformationPresenter();
        Intent intent = getIntent();
        careworkerId = intent.getStringExtra("careworkerId");

        presenter.getCareworkerInform(careworkerId);

    }

    @Override
    public void setCareworkerInform(String name, String hospitalName, String career, String patientNumber, String introduction, String sincerityScore, String kindnessScore, int overall, String firstReview, String secondReview, String thirdReview) {
        careworkerNameText.setText(name);
        careworkerHospitalText.setText(hospitalName);
        careworkerCareerText.setText(career);
        careworkerPatientNumberText.setText(patientNumber);
        careworkerIntroductionText.setText(introduction);
        careworkerSincerityScore.setText(sincerityScore);
        careworkerKindnessScore.setText(kindnessScore);
        careworkerFirstReview.setText(firstReview);
        careworkerSecondReview.setText(secondReview);
        careworkerThirdReview.setText(thirdReview);

        careworkerOverallRatingBar.setNumStars(overall);
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(getApplicationContext(),"오류",Toast.LENGTH_SHORT).show();
    }
}
