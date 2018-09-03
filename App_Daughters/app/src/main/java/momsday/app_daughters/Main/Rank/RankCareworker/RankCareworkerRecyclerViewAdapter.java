package momsday.app_daughters.Main.Rank.RankCareworker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import momsday.app_daughters.R;

public class RankCareworkerRecyclerViewAdapter extends RecyclerView.Adapter<RankCareworkerRecyclerViewHolder> {

    private ArrayList<RankRecyclerCareworkerItem> rankRecyclerCareworkerItems;
    Context rankRecyclerCareworkerContext;

    public RankCareworkerRecyclerViewAdapter(ArrayList itemList) {
        rankRecyclerCareworkerItems = itemList;
    }

    @Override
    public RankCareworkerRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_recycler_rank_careworker, parent, false);
        rankRecyclerCareworkerContext = parent.getContext();
        RankCareworkerRecyclerViewHolder holder = new RankCareworkerRecyclerViewHolder(v);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull RankCareworkerRecyclerViewHolder holder, int position) {

        holder.careworkerNameText.setText(rankRecyclerCareworkerItems.get(position).rankCareworkerName);
        holder.careworkerHospitalText.setText(rankRecyclerCareworkerItems.get(position).rankCareworkerHospital);
        holder.careworkerScoreRatingBar.setNumStars(rankRecyclerCareworkerItems.get(position).rankCareworkerScore);
    }

    @Override
    public int getItemCount() {
        return rankRecyclerCareworkerItems.size();
    }
}
