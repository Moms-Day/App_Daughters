package momsday.app_daughters.Main.Rank.RankHospital;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import momsday.app_daughters.R;

public class RankHospitalRecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView hospitalNameText, hospitalLocationText;
    public RatingBar hospitalScoreRatingBar;
    public ImageView hospitalImageView, hospitalImageNoneView;

    public RankHospitalRecyclerViewHolder(View itemView) {
        super(itemView);

        hospitalNameText = (TextView) itemView.findViewById(R.id.text_main_rank_hospital_name);
        hospitalLocationText = (TextView)itemView.findViewById(R.id.text_main_rank_hospital_location);
        hospitalScoreRatingBar = (RatingBar)itemView.findViewById(R.id.ratingbar_main_rank_hopital_score);
        hospitalImageView = (ImageView)itemView.findViewById(R.id.image_main_rank_hospital);
        hospitalImageNoneView = (ImageView) itemView.findViewById(R.id.image_main_rank_hospital_none);
    }
}
