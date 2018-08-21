package momsday.app_daughters.Main.Rank;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import momsday.app_daughters.R;

public class RankHospitalRecyclerViewAdapter extends RecyclerView.Adapter<RankHospitalRecyclerViewHolder> {

    private ArrayList<RankRecyclerHospitalItem> rankRecyclerHospitalItems;
    Context rankRecyclerMyHospitalContext;

    public RankHospitalRecyclerViewAdapter(ArrayList itemList) {
        rankRecyclerHospitalItems = itemList;
    }

    @Override
    public RankHospitalRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_recycler_rank_hospital, parent, false);
        rankRecyclerMyHospitalContext = parent.getContext();
        RankHospitalRecyclerViewHolder holder = new RankHospitalRecyclerViewHolder(v);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull RankHospitalRecyclerViewHolder holder, int position) {

        holder.myHospitalNameText.setText(rankRecyclerHospitalItems.get(position).rankMyHospitalName);
        holder.myHospitalLocationText.setText(rankRecyclerHospitalItems.get(position).rankMyHospitalLocation);
        holder.myHospitalScoreRatingBar.setNumStars(rankRecyclerHospitalItems.get(position).rankMyHospitalScore);
    }

    @Override
    public int getItemCount() {
        return rankRecyclerHospitalItems.size();
    }
}
