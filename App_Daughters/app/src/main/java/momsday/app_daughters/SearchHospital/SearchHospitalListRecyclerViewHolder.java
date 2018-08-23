package momsday.app_daughters.SearchHospital;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import momsday.app_daughters.R;

public class SearchHospitalListRecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView hospitalNameText, hospitalLoacationText;

    public SearchHospitalListRecyclerViewHolder(View itemView) {
        super(itemView);

        hospitalNameText = (TextView) itemView.findViewById(R.id.text_search_hospital_name);
        hospitalLoacationText = (TextView) itemView.findViewById(R.id.text_search_hospital_location);
    }
}
