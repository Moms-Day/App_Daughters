package momsday.app_daughters.Main.Rank.RankCareworker;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import momsday.app_daughters.R;

public class RankCareworkerRecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView careworkerNameText, careworkerHospitalText;
    public RatingBar careworkerScoreRatingBar;
    public ImageView careworkerImageView;

    public RankCareworkerRecyclerViewHolder(View itemView) {
        super(itemView);

        careworkerNameText = (TextView) itemView.findViewById(R.id.text_main_rank_careworker_name);
        careworkerHospitalText = (TextView)itemView.findViewById(R.id.text_main_rank_careworker_hospital);
        careworkerScoreRatingBar = (RatingBar)itemView.findViewById(R.id.ratingbar_main_rank_careworker_score);
        careworkerImageView = (ImageView) itemView.findViewById(R.id.image_main_rank_careworker);
    }
}
