package momsday.app_daughters.SearchHospital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;

import momsday.app_daughters.HospitalInformation.HospitalInformationActivity;
import momsday.app_daughters.Main.Main.MainRecyclerScheduleItem;
import momsday.app_daughters.Main.Main.MainScheduleRecyclerViewAdapter;
import momsday.app_daughters.R;
import momsday.app_daughters.RequestConnection.RequestConnectionActivity;

public class SearchHospitalActivity extends AppCompatActivity implements SearchHospitalContract.View{

    private RecyclerView searchHospitalListRecycler;
    private LinearLayoutManager searchHospitalListLayoutManager;
    private String hospitalName;
    private EditText hospitalNameEdit; //todo hospitalnameEdit부터 하기
    private SearchHospitalListRecyclerViewAdapter searchHospitalListRecyclerViewAdapter;
    private ArrayList<SearchHospitalListRecyclerItem> searchHospitalListRecyclerItems;
    private ImageButton searchHospitalBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_hospital);
        init();

        //test
        searchHospitalListRecyclerItems.add(new SearchHospitalListRecyclerItem("하늘요양병원","위치"));
        searchHospitalListRecyclerItems.add(new SearchHospitalListRecyclerItem("요양병원","위치"));


    }


    private void init() {
        searchHospitalBtn = (ImageButton) findViewById(R.id.imagebtn_search_hospital);
        searchHospitalListRecycler = (RecyclerView) findViewById(R.id.recycler_search_hospital);
        searchHospitalListLayoutManager = new LinearLayoutManager(this);
        searchHospitalListRecyclerItems = new ArrayList();

        searchHospitalListLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        searchHospitalListRecycler.setLayoutManager(searchHospitalListLayoutManager);
        searchHospitalListRecycler.setItemAnimator(new DefaultItemAnimator());

        searchHospitalListRecyclerViewAdapter = new SearchHospitalListRecyclerViewAdapter(searchHospitalListRecyclerItems);
        searchHospitalListRecycler.setAdapter(searchHospitalListRecyclerViewAdapter);
        searchHospitalListRecycler.addOnItemTouchListener(new SearchHospitalListRecyclerClickListener(getApplicationContext(), searchHospitalListRecycler, new SearchHospitalListRecyclerClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                hospitalName = searchHospitalListRecyclerItems.get(position).hospitalName;

                Intent intent = new Intent(SearchHospitalActivity.this, RequestConnectionActivity.class);
                Log.d("Debug","SearchHospitalActivity hospitalName : "+ hospitalName);
                intent.putExtra("hospitalName",hospitalName);
                startActivity(intent);

                finish();
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }) {

        });

        searchHospitalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public void setHospitalNameList(String hospitalName, String hospitalLocation) {
        searchHospitalListRecyclerItems.add(new SearchHospitalListRecyclerItem(hospitalName, hospitalLocation));
    }
}
