package momsday.app_daughters.RequestConnection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import momsday.app_daughters.R;

public class RequestConnectionActivity extends AppCompatActivity {

    private Spinner careworkerNameSpinner;
    private ArrayAdapter spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_connection);

        careworkerNameSpinner = (Spinner) findViewById(R.id.spinner_request_connection_careworker_name);


        final ArrayList<String> careworkerNameList = new ArrayList<>();
        careworkerNameList.add("이종현");
        careworkerNameList.add("정다은");

        spinnerAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, careworkerNameList);

        careworkerNameSpinner.setAdapter(spinnerAdapter);

        careworkerNameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(RequestConnectionActivity.this,"선택된 아이템 : "+careworkerNameSpinner.getItemAtPosition(i),Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
