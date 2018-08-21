package momsday.app_daughters.Main.Rank;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import momsday.app_daughters.R;

public class RankHospitalFragment extends Fragment {
    public RankHospitalFragment() {
    }
    RecyclerView rankMyHospitalRecycler, rankHospitalRecycler;
    LinearLayoutManager rankMyHospitalLayoutManager, rankHospitalLayoutManager;
    RankHospitalRecyclerViewAdapter rankMyHospitalRecyclerAdapter, rankHospitalRecyclerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ConstraintLayout layout = (ConstraintLayout) inflater.inflate(R.layout.fragment_rank_hospital, container, false);

        //나의 요양병원
        rankMyHospitalRecycler = (RecyclerView)layout.findViewById(R.id.recycler_main_rank_my_hospital);
        rankMyHospitalLayoutManager = new LinearLayoutManager(getContext());
        rankMyHospitalLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ArrayList<RankRecyclerHospitalItem> rankRecyclerMyHospitalItems = new ArrayList();
        rankRecyclerMyHospitalItems.add(new RankRecyclerHospitalItem("종현병원","종현이왼팔",2));
        rankMyHospitalRecycler.setLayoutManager(rankMyHospitalLayoutManager);
        rankMyHospitalRecycler.setItemAnimator(new DefaultItemAnimator());
        rankMyHospitalRecyclerAdapter = new RankHospitalRecyclerViewAdapter(rankRecyclerMyHospitalItems);
        rankMyHospitalRecycler.setAdapter(rankMyHospitalRecyclerAdapter);

        //요양병원 순위
        rankHospitalRecycler = (RecyclerView) layout.findViewById(R.id.recycler_main_rank_hospital);
        rankHospitalLayoutManager = new LinearLayoutManager(getContext());
        rankHospitalLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ArrayList<RankRecyclerHospitalItem> rankRecyclerHospitalItems = new ArrayList();
        rankRecyclerHospitalItems.add(new RankRecyclerHospitalItem("hospitalname","location",3));
        rankHospitalRecycler.setLayoutManager(rankHospitalLayoutManager);
        rankHospitalRecycler.setItemAnimator(new DefaultItemAnimator());
        rankHospitalRecyclerAdapter = new RankHospitalRecyclerViewAdapter(rankRecyclerHospitalItems);
        rankHospitalRecycler.setAdapter(rankHospitalRecyclerAdapter);

        return layout;
    }
}
