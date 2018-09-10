package momsday.app_daughters.SearchHospital;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import momsday.app_daughters.R;
import momsday.app_daughters.RequestConnection.RequestConnectionActivity;
import momsday.app_daughters.RecyclerItemClickListener;

public class SearchHospitalActivity extends AppCompatActivity implements SearchHospitalContract.View{

    private RecyclerView searchHospitalListRecycler;
    private LinearLayoutManager searchHospitalListLayoutManager;
    private String hospitalName;
    private EditText hospitalNameEdit;
    private SearchHospitalListRecyclerViewAdapter searchHospitalListRecyclerViewAdapter;
    private ArrayList<SearchHospitalListRecyclerItem> searchHospitalListRecyclerItems;
    private ImageButton searchHospitalBtn;
    private SearchHospitalContract.Presenter presenter;
    public static Context searchHospitalContext;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_hospital);

        searchHospitalContext = this;
        presenter = new SearchHospitalPresenter();
        presenter.setView(this);

        searchHospitalBtn = (ImageButton) findViewById(R.id.imagebtn_search_hospital);
        searchHospitalListRecycler = (RecyclerView) findViewById(R.id.recycler_search_hospital);
        searchHospitalListLayoutManager = new LinearLayoutManager(this);
        searchHospitalListRecyclerItems = new ArrayList();
        hospitalNameEdit = (EditText) findViewById(R.id.edit_search_hospital_name);

        searchHospitalListLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        searchHospitalListRecycler.setLayoutManager(searchHospitalListLayoutManager);
        searchHospitalListRecycler.setItemAnimator(new DefaultItemAnimator());

        searchHospitalListRecyclerViewAdapter = new SearchHospitalListRecyclerViewAdapter(searchHospitalListRecyclerItems);
        searchHospitalListRecycler.setAdapter(searchHospitalListRecyclerViewAdapter);
        searchHospitalListRecycler.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), searchHospitalListRecycler, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                hospitalName = searchHospitalListRecyclerItems.get(position).hospitalName;
                intent = new Intent(SearchHospitalActivity.this, RequestConnectionActivity.class);

                ArrayList<Careworker> careworkersList = presenter.getCareworkers(position);
                intent.putExtra("hospitalName",hospitalName);
                intent.putExtra("careworkers",careworkersList);
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
                hospitalName = hospitalNameEdit.getText().toString();
                if(TextUtils.isEmpty(hospitalName)) {
                    Toast.makeText(getApplicationContext(),"요양병원 이름을 입력하세요.",Toast.LENGTH_SHORT).show();
                } else {
                    presenter.searchFacility(hospitalName);
                }
            }
        });
    }

    @Override
    public void setHospitalNameList(String hospitalName, String hospitalLocation) {
        searchHospitalListRecyclerItems.add(new SearchHospitalListRecyclerItem(hospitalName, hospitalLocation));
        searchHospitalListRecyclerViewAdapter.notifyDataSetChanged();
    }


}
