package momsday.app_daughters.Main.Rank.RankHospital;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
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

        holder.hospitalNameText.setText(rankRecyclerHospitalItems.get(position).rankHospitalName);
        holder.hospitalLocationText.setText(rankRecyclerHospitalItems.get(position).rankHospitalLocation);
        holder.hospitalScoreRatingBar.setRating(rankRecyclerHospitalItems.get(position).rankHospitalScore);
        Glide.with(rankRecyclerMyHospitalContext).load(rankRecyclerHospitalItems.get(position).rankHospitalImagePath).into(holder.hospitalImageView);
    }

    @Override
    public int getItemCount() {
        return rankRecyclerHospitalItems.size();
    }
}
