package momsday.app_daughters.Main.Rank.RankCareworker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import momsday.app_daughters.CareworkerInformation.CareworkerInformationActivity;
import momsday.app_daughters.R;
import momsday.app_daughters.RecyclerItemClickListener;

public class RankCareworkerFragment extends Fragment implements RankCareworkerContract.View{
    private RankCareworkerContract.Presenter presenter;
    public static Context RankCareworkerContext;

    public RankCareworkerFragment() {
    }
    private RecyclerView rankMyCareworkerRecycler, rankCareworkerRecycler;
    private LinearLayoutManager rankMyCareworkerLayoutManager, rankCareworkerLayoutManager;
    private RankCareworkerRecyclerViewAdapter rankMyCareworkerRecyclerAdapter, rankCareworkerRecyclerAdapter;
    private ArrayList<RankRecyclerCareworkerItem> rankRecyclerCareworkerItems;
    private ArrayList<RankRecyclerCareworkerItem> rankRecyclerMyCareworkerItems;
    private TextView myCareworkerNoneText;
    private SwipeRefreshLayout swipeRefreshLayout;
    private FragmentTransaction ft;
    private View layout;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RankCareworkerContext = getContext();
        layout = inflater.inflate(R.layout.fragment_rank_careworker,null);
        presenter = new RankCareworkerPresenter();
        presenter.setView(this);
        swipeRefreshLayout = (SwipeRefreshLayout) layout.findViewById(R.id.swipe_layout_rank_careworker);
        ft = getFragmentManager().beginTransaction();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();

            }
        });

        //나의 요양보호사
        rankMyCareworkerRecycler = (RecyclerView)layout.findViewById(R.id.recycler_main_rank_my_careworker);
        myCareworkerNoneText = (TextView)layout.findViewById(R.id.text_main_rank_careworker_my_careworker_none);
        rankMyCareworkerLayoutManager = new LinearLayoutManager(getContext()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        rankMyCareworkerLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rankRecyclerMyCareworkerItems = new ArrayList();
        rankMyCareworkerRecycler.setLayoutManager(rankMyCareworkerLayoutManager);
        rankMyCareworkerRecycler.setItemAnimator(new DefaultItemAnimator());
        rankMyCareworkerRecyclerAdapter = new RankCareworkerRecyclerViewAdapter(rankRecyclerMyCareworkerItems);
        rankMyCareworkerRecycler.setAdapter(rankMyCareworkerRecyclerAdapter);
        rankMyCareworkerRecycler.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), rankMyCareworkerRecycler, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.d("Debug","먀먀 "+ position);
                presenter.getMyCareworkerId(position);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));

        //요양보호사 순위
        rankCareworkerRecycler = (RecyclerView) layout.findViewById(R.id.recycler_main_rank_careworker);
        rankCareworkerLayoutManager = new LinearLayoutManager(getContext()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        rankCareworkerLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rankRecyclerCareworkerItems = new ArrayList();
        rankCareworkerRecycler.setLayoutManager(rankCareworkerLayoutManager);
        rankCareworkerRecycler.setItemAnimator(new DefaultItemAnimator());
        rankCareworkerRecyclerAdapter = new RankCareworkerRecyclerViewAdapter(rankRecyclerCareworkerItems);
        rankCareworkerRecycler.setAdapter(rankCareworkerRecyclerAdapter);
        rankCareworkerRecycler.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), rankCareworkerRecycler, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                presenter.getCareworkerId(position);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));


        presenter.getCareworkerRank();

        return layout;
    }

    @Override
    public void setMyCareworker(String rankMyCareworkerName, String rankMyCareworkerHospital, float rankMyCareworkerScore, String rankMyCareworkerImagePath) {
        rankRecyclerMyCareworkerItems.add(new RankRecyclerCareworkerItem(rankMyCareworkerName,rankMyCareworkerHospital,rankMyCareworkerScore, rankMyCareworkerImagePath));
        rankMyCareworkerRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void setCareworker(String rankCareworkerName, String rankCareworkerHospital, float rankCareworkerScore, String rankCareworkerImagePath) {
        rankRecyclerCareworkerItems.add(new RankRecyclerCareworkerItem(rankCareworkerName,rankCareworkerHospital,rankCareworkerScore, rankCareworkerImagePath));
        rankCareworkerRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void startCareworkerInform(String careworkerId) {
        Intent intent = new Intent(getContext(), CareworkerInformationActivity.class);
        intent.putExtra("careworkerId",careworkerId);
        startActivity(intent);
    }

    @Override
    public void setMyCareworkerNoneText() {
        myCareworkerNoneText.setVisibility(View.VISIBLE);
    }

    public void refresh() {
        ft.detach(this).attach(this).commit();
    }
}
