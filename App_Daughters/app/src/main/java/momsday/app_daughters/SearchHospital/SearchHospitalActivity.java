package momsday.app_daughters.SearchHospital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import momsday.app_daughters.HospitalInformation.HospitalInformationActivity;
import momsday.app_daughters.Main.Main.MainRecyclerScheduleItem;
import momsday.app_daughters.Main.Main.MainScheduleRecyclerViewAdapter;
import momsday.app_daughters.R;

public class SearchHospitalActivity extends AppCompatActivity {

    private RecyclerView searchHospitalListRecycler;
    private LinearLayoutManager searchHospitalListLayoutManager;
    SearchHospitalListRecyclerViewAdapter searchHospitalListRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_hospital);

        searchHospitalListRecycler = (RecyclerView) findViewById(R.id.recycler_search_hospital);
        searchHospitalListLayoutManager = new LinearLayoutManager(this);
        searchHospitalListLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ArrayList<SearchHospitalListRecyclerItem> searchHospitalListRecyclerItems = new ArrayList();

        //test
        searchHospitalListRecyclerItems.add(new SearchHospitalListRecyclerItem("요양병원이름","위치"));
        searchHospitalListRecyclerItems.add(new SearchHospitalListRecyclerItem("요양병원이름","위치"));

        searchHospitalListRecycler.setLayoutManager(searchHospitalListLayoutManager);
        searchHospitalListRecycler.setItemAnimator(new DefaultItemAnimator());

        searchHospitalListRecyclerViewAdapter = new SearchHospitalListRecyclerViewAdapter(searchHospitalListRecyclerItems);
        searchHospitalListRecycler.setAdapter(searchHospitalListRecyclerViewAdapter);
        searchHospitalListRecycler.addOnItemTouchListener(new SearchHospitalListRecyclerClickListener(getApplicationContext(), searchHospitalListRecycler, new SearchHospitalListRecyclerClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(SearchHospitalActivity.this, HospitalInformationActivity.class);
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }) {

        });
    }
}
