package momsday.app_daughters.Main.Rank;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import momsday.app_daughters.R;

public class RankMyHospitalRecyclerViewAdapter extends RecyclerView.Adapter<RankMyHospitalRecyclerViewHolder> {

    private ArrayList<RankRecyclerMyHospitalItem> rankRecyclerMyHospitalItems;
    Context rankRecyclerMyHospitalContext;

    public RankMyHospitalRecyclerViewAdapter(ArrayList itemList) {
        rankRecyclerMyHospitalItems = itemList;
    }

    @Override
    public RankMyHospitalRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_recycler_rank, parent, false);
        rankRecyclerMyHospitalContext = parent.getContext();
        RankMyHospitalRecyclerViewHolder holder = new RankMyHospitalRecyclerViewHolder(v);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull RankMyHospitalRecyclerViewHolder holder, int position) {

        holder.myHospitalNameText.setText(rankRecyclerMyHospitalItems.get(position).rankMyHospitalName);
        holder.myHospitalLocationText.setText(rankRecyclerMyHospitalItems.get(position).rankMyHospitalLocation);
        holder.myHospitalScoreRatingBar.setNumStars(rankRecyclerMyHospitalItems.get(position).rankMyHospitalScore);
    }

    @Override
    public int getItemCount() {
        return rankRecyclerMyHospitalItems.size();
    }
}
