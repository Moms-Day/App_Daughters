package momsday.app_daughters.Main.Rank.RankHospital;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import momsday.app_daughters.HospitalInformation.HospitalInformationActivity;
import momsday.app_daughters.Main.Rank.RankCareworker.RankCareworkerContract;
import momsday.app_daughters.Main.Rank.RankCareworker.RankCareworkerPresenter;
import momsday.app_daughters.Main.Rank.RankContract;
import momsday.app_daughters.R;
import momsday.app_daughters.RecyclerItemClickListener;

public class RankHospitalFragment extends Fragment implements RankHospitalContract.View {
    public RankHospitalFragment() {
    }

    private RecyclerView rankMyHospitalRecycler, rankHospitalRecycler;
    private LinearLayoutManager rankMyHospitalLayoutManager, rankHospitalLayoutManager;
    private RankHospitalRecyclerViewAdapter rankMyHospitalRecyclerAdapter, rankHospitalRecyclerAdapter;
    private ArrayList<RankRecyclerHospitalItem> rankRecyclerMyHospitalItems;
    private ArrayList<RankRecyclerHospitalItem> rankRecyclerHospitalItems;
    private RankHospitalContract.Presenter presenter;
    public static Context RankHospitalContext;
    private TextView myHospitalNoneText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RankHospitalContext = getContext();
        ConstraintLayout layout = (ConstraintLayout) inflater.inflate(R.layout.fragment_rank_hospital, container, false);
        presenter = new RankHospitalPresenter();
        presenter.setView(this);
        //나의 요양병원
        rankMyHospitalRecycler = (RecyclerView) layout.findViewById(R.id.recycler_main_rank_my_hospital);
        myHospitalNoneText = (TextView) layout.findViewById(R.id.text_main_rank_hospital_my_hospital_none);
        rankMyHospitalLayoutManager = new LinearLayoutManager(getContext());
        rankMyHospitalLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rankRecyclerMyHospitalItems = new ArrayList();
        rankMyHospitalRecycler.setLayoutManager(rankMyHospitalLayoutManager);
        rankMyHospitalRecycler.setItemAnimator(new DefaultItemAnimator());
        rankMyHospitalRecyclerAdapter = new RankHospitalRecyclerViewAdapter(rankRecyclerMyHospitalItems);
        rankMyHospitalRecycler.setAdapter(rankMyHospitalRecyclerAdapter);
        rankMyHospitalRecycler.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), rankMyHospitalRecycler, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                presenter.getHospitalCode(position);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));

        //요양병원 순위
        rankHospitalRecycler = (RecyclerView) layout.findViewById(R.id.recycler_main_rank_hospital);
        rankHospitalLayoutManager = new LinearLayoutManager(getContext());
        rankHospitalLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rankRecyclerHospitalItems = new ArrayList();
        rankHospitalRecycler.setLayoutManager(rankHospitalLayoutManager);
        rankHospitalRecycler.setItemAnimator(new DefaultItemAnimator());
        rankHospitalRecyclerAdapter = new RankHospitalRecyclerViewAdapter(rankRecyclerHospitalItems);
        rankHospitalRecycler.setAdapter(rankHospitalRecyclerAdapter);
        rankHospitalRecycler.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), rankHospitalRecycler, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                presenter.getHospitalCode(position);
            }

            @Override
            public void onLongItemClick(View view, int position) {
            }
        }));

        presenter.getHospitalRank();

        return layout;
    }

    @Override
    public void setMyHospital(String myHospitalName, String myHospitalLocation, float myHospitalOverall, String myHospitalImagepath) {
        rankRecyclerMyHospitalItems.add(new RankRecyclerHospitalItem(myHospitalName, myHospitalLocation, myHospitalOverall, myHospitalImagepath));
        rankHospitalRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void setHospital(String hospitalName, String hospitalLocation, float hospitalOverall, String hospitalImagePath) {
        rankRecyclerHospitalItems.add(new RankRecyclerHospitalItem(hospitalName, hospitalLocation, hospitalOverall, hospitalImagePath));
        rankHospitalRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void startHospitalInform(String hospitalCode) {
        Intent intent = new Intent(getContext(), HospitalInformationActivity.class);
        intent.putExtra("hospitalCode", hospitalCode);
        startActivity(intent);
    }

    @Override
    public void setMyHospitalNoneText() {
        myHospitalNoneText.setVisibility(View.VISIBLE);
    }
}
