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

public class RankCareworkerFragment extends Fragment {
    public RankCareworkerFragment() {
    }
    RecyclerView rankMyCareworkerRecycler, rankCareworkerRecycler;
    LinearLayoutManager rankMyCareworkerLayoutManager, rankCareworkerLayoutManager;
    RankCareworkerRecyclerViewAdapter rankMyCareworkerRecyclerAdapter, rankCareworkerRecyclerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ConstraintLayout layout = (ConstraintLayout) inflater.inflate(R.layout.fragment_rank_careworker, container, false);

        //나의 요양병원
        rankMyCareworkerRecycler = (RecyclerView)layout.findViewById(R.id.recycler_main_rank_my_careworker);
        rankMyCareworkerLayoutManager = new LinearLayoutManager(getContext());
        rankMyCareworkerLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ArrayList<RankRecyclerCareworkerItem> rankRecyclerMyCareworkerItems = new ArrayList();
        rankRecyclerMyCareworkerItems.add(new RankRecyclerCareworkerItem("이종현","하늘요양병원",2));
        rankMyCareworkerRecycler.setLayoutManager(rankMyCareworkerLayoutManager);
        rankMyCareworkerRecycler.setItemAnimator(new DefaultItemAnimator());
        rankMyCareworkerRecyclerAdapter = new RankCareworkerRecyclerViewAdapter(rankRecyclerMyCareworkerItems);
        rankMyCareworkerRecycler.setAdapter(rankMyCareworkerRecyclerAdapter);

        //요양병원 순위
        rankCareworkerRecycler = (RecyclerView) layout.findViewById(R.id.recycler_main_rank_careworker);
        rankCareworkerLayoutManager = new LinearLayoutManager(getContext());
        rankCareworkerLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ArrayList<RankRecyclerCareworkerItem> rankRecyclerCareworkerItems = new ArrayList();
        rankRecyclerCareworkerItems.add(new RankRecyclerCareworkerItem("name","hospital",3));
        rankCareworkerRecycler.setLayoutManager(rankCareworkerLayoutManager);
        rankCareworkerRecycler.setItemAnimator(new DefaultItemAnimator());
        rankCareworkerRecyclerAdapter = new RankCareworkerRecyclerViewAdapter(rankRecyclerCareworkerItems);
        rankCareworkerRecycler.setAdapter(rankCareworkerRecyclerAdapter);

        return layout;
    }
}
