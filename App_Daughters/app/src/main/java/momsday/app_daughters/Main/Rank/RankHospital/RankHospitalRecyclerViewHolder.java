package momsday.app_daughters.Main.Rank.RankHospital;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import momsday.app_daughters.R;

public class RankHospitalRecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView myHospitalNameText, myHospitalLocationText;
    public RatingBar myHospitalScoreRatingBar;
    public ImageView myHospitalImageView;

    public RankHospitalRecyclerViewHolder(View itemView) {
        super(itemView);

        myHospitalNameText = (TextView) itemView.findViewById(R.id.text_main_rank_hospital_name);
        myHospitalLocationText = (TextView)itemView.findViewById(R.id.text_main_rank_hospital_location);
        myHospitalScoreRatingBar = (RatingBar)itemView.findViewById(R.id.ratingbar_main_rank_hopital_score);
    }
}
