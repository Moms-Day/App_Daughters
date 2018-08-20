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
    RecyclerView rankMyHospitalRecycler;
    LinearLayoutManager rankMyHospitalLayoutManager;
    RankMyHospitalRecyclerViewAdapter rankMyHospitalRecyclerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ConstraintLayout layout = (ConstraintLayout) inflater.inflate(R.layout.fragment_rank_hospital, container, false);
        rankMyHospitalRecycler = (RecyclerView)layout.findViewById(R.id.recycler_main_rank_my_hospital);
        rankMyHospitalLayoutManager = new LinearLayoutManager(getContext());
        rankMyHospitalLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ArrayList<RankRecyclerMyHospitalItem> rankRecyclerMyHospitalItems = new ArrayList();

        rankRecyclerMyHospitalItems.add(new RankRecyclerMyHospitalItem("종현병원","종현이왼팔",2));
        rankMyHospitalRecycler.setLayoutManager(rankMyHospitalLayoutManager);
        rankMyHospitalRecycler.setItemAnimator(new DefaultItemAnimator());

        rankMyHospitalRecyclerAdapter = new RankMyHospitalRecyclerViewAdapter(rankRecyclerMyHospitalItems);
        rankMyHospitalRecycler.setAdapter(rankMyHospitalRecyclerAdapter);
        return layout;
    }
}
