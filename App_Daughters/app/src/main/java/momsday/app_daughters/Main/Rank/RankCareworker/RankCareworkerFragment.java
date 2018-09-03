package momsday.app_daughters.Main.Rank.RankCareworker;

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

import java.util.ArrayList;

import momsday.app_daughters.CareworkerInformation.CareworkerInformationActivity;
import momsday.app_daughters.HospitalInformation.HospitalInformationActivity;
import momsday.app_daughters.Main.Rank.RankContract;
import momsday.app_daughters.R;
import momsday.app_daughters.RecyclerItemClickListener;

public class RankCareworkerFragment extends Fragment implements RankCareworkerContract.View{
    private RankCareworkerContract.Presenter presenter;
    public static Context RankCareworkerContext;

    public RankCareworkerFragment() {
    }
    RecyclerView rankMyCareworkerRecycler, rankCareworkerRecycler;
    LinearLayoutManager rankMyCareworkerLayoutManager, rankCareworkerLayoutManager;
    RankCareworkerRecyclerViewAdapter rankMyCareworkerRecyclerAdapter, rankCareworkerRecyclerAdapter;
    ArrayList<RankRecyclerCareworkerItem> rankRecyclerCareworkerItems;
    ArrayList<RankRecyclerCareworkerItem> rankRecyclerMyCareworkerItems;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RankCareworkerContext = getContext();
        ConstraintLayout layout = (ConstraintLayout) inflater.inflate(R.layout.fragment_rank_careworker, container, false);
        presenter = new RankCareworkerPresenter();
        presenter.setView(this);
        //나의 요양보호사
        rankMyCareworkerRecycler = (RecyclerView)layout.findViewById(R.id.recycler_main_rank_my_careworker);
        rankMyCareworkerLayoutManager = new LinearLayoutManager(getContext());
        rankMyCareworkerLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rankRecyclerMyCareworkerItems = new ArrayList();
        rankRecyclerMyCareworkerItems.add(new RankRecyclerCareworkerItem("이종현","하늘요양병원",2));
        rankMyCareworkerRecycler.setLayoutManager(rankMyCareworkerLayoutManager);
        rankMyCareworkerRecycler.setItemAnimator(new DefaultItemAnimator());
        rankMyCareworkerRecyclerAdapter = new RankCareworkerRecyclerViewAdapter(rankRecyclerMyCareworkerItems);
        rankMyCareworkerRecycler.setAdapter(rankMyCareworkerRecyclerAdapter);
        rankMyCareworkerRecycler.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), rankMyCareworkerRecycler, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                presenter.getCareworkerId(position);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));

        //요양보호사 순위
        rankCareworkerRecycler = (RecyclerView) layout.findViewById(R.id.recycler_main_rank_careworker);
        rankCareworkerLayoutManager = new LinearLayoutManager(getContext());
        rankCareworkerLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rankRecyclerCareworkerItems = new ArrayList();
        rankRecyclerCareworkerItems.add(new RankRecyclerCareworkerItem("name","hospital",3));
        rankCareworkerRecycler.setLayoutManager(rankCareworkerLayoutManager);
        rankCareworkerRecycler.setItemAnimator(new DefaultItemAnimator());
        rankCareworkerRecyclerAdapter = new RankCareworkerRecyclerViewAdapter(rankRecyclerCareworkerItems);
        rankCareworkerRecycler.setAdapter(rankCareworkerRecyclerAdapter);
        rankCareworkerRecycler.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), rankCareworkerRecycler, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getContext(), CareworkerInformationActivity.class);
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));


        presenter.getCareworkerRank();

        return layout;
    }

    @Override
    public void setMyCareworker(String rankCareworkerName, String rankCareworkerHospital, int rankCareworkerScore) {
        rankRecyclerMyCareworkerItems.add(new RankRecyclerCareworkerItem(rankCareworkerName,rankCareworkerHospital,rankCareworkerScore));
    }

    @Override
    public void setCareworker(String rankCareworkerName, String rankCareworkerHospital, int rankCareworkerScore) {
        rankRecyclerCareworkerItems.add(new RankRecyclerCareworkerItem(rankCareworkerName,rankCareworkerHospital,rankCareworkerScore));
    }

    @Override
    public void startCareworkerInform(String careworkerId) {
        Intent intent = new Intent(getContext(), CareworkerInformationActivity.class);
        intent.putExtra("careworkerId",careworkerId);
        startActivity(intent);
    }
}
