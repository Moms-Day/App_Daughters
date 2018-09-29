package momsday.app_daughters.RequestConnection;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import momsday.app_daughters.Main.Main.Main.MainActivity;
import momsday.app_daughters.R;
import momsday.app_daughters.SearchHospital.Careworker;
import momsday.app_daughters.SearchHospital.SearchHospitalActivity;

public class RequestConnectionActivity extends AppCompatActivity implements RequestConnectionContract.View{

    private Spinner careworkerNameSpinner;
    private ArrayAdapter spinnerAdapter;
    private EditText hospitalNameEdit, userNameEdit, patientNameEdit, patientAgeEdit;
    private RadioButton patientMaleBtn, patientFemaleBtn;
    private String hospitalName, userName, patientName, patientAge, careId;
    private Button requestConnectionBtn;
    private boolean patientGender;
    private ArrayList<Careworker> careworkers;
    private RequestConnectionContract.Presenter presenter;
    public static Context RequestConnectionContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_connection);
        RequestConnectionContext = this;
        presenter = new RequestConnectionPresenter();
        presenter.setView(this);

        careworkerNameSpinner = (Spinner) findViewById(R.id.spinner_request_connection_careworker_name);
        hospitalNameEdit = (EditText) findViewById(R.id.edit_request_connection_hospital_name);
        userNameEdit = (EditText) findViewById(R.id.edit_request_connection_my_name);
        patientNameEdit = (EditText) findViewById(R.id.edit_request_connection_parent_name);
        patientAgeEdit = (EditText) findViewById(R.id.edit_request_connection_parent_age);
        patientMaleBtn = (RadioButton) findViewById(R.id.radiobtn_request_connection_parent_male);
        patientFemaleBtn = (RadioButton) findViewById(R.id.radiobtn_request_connection_parent_female);
        requestConnectionBtn = (Button) findViewById(R.id.btn_request_connection);


        SharedPreferences preferences = getApplicationContext().getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE);
        userNameEdit.setText(preferences.getString("name",""));
        setHospitalName();

        hospitalNameEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSearchHospital();
            }
        });

        requestConnectionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName = userNameEdit.getText().toString();
                patientName = patientNameEdit.getText().toString();
                patientAge = patientAgeEdit.getText().toString();
                if(patientMaleBtn.isChecked()) patientGender = true;
                else if(patientFemaleBtn.isChecked()) patientGender=false;

                if(TextUtils.isEmpty(userName) || TextUtils.isEmpty(patientName) || TextUtils.isEmpty(patientAge))
                {
                    Toast.makeText(getApplicationContext(),"필수 항목을 모두 입력하세요.",Toast.LENGTH_SHORT).show();
                } else {
                    presenter.requestConnection(userName, patientName, patientAge, patientGender, careId);
                }
            }
        });
    }


    void setHospitalName() {
        hospitalName = getIntent().getStringExtra("hospitalName");
        careworkers = getIntent().getParcelableArrayListExtra("careworkers");
        hospitalNameEdit.setText(hospitalName);

        if(!TextUtils.isEmpty(hospitalName) && careworkers !=null) {
            final ArrayList<String> careworkerNameList = new ArrayList<>();
            for(int i=0;i<careworkers.size();i++) {
                careworkerNameList.add(careworkers.get(i).getName());
            }

            setCareworkerList(careworkerNameList);
        }
    }

    @Override
    public void startSearchHospital() {
        Intent intent = new Intent(RequestConnectionActivity.this, SearchHospitalActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void setCareworkerList(ArrayList<String> careworkerNameList) {
        spinnerAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, careworkerNameList);
        careworkerNameSpinner.setAdapter(spinnerAdapter);

        careworkerNameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                careId = careworkers.get(i).getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void startMainActivity() {
        Toast.makeText(getApplicationContext(),"연결 요청 성공!",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(RequestConnectionActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(getApplicationContext(),"오류",Toast.LENGTH_SHORT).show();
    }
}
