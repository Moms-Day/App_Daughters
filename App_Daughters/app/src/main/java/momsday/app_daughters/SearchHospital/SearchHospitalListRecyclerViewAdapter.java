package momsday.app_daughters.SearchHospital;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import momsday.app_daughters.R;

public class SearchHospitalListRecyclerViewAdapter extends RecyclerView.Adapter<SearchHospitalListRecyclerViewHolder> {

    private ArrayList<SearchHospitalListRecyclerItem> searchHospitalListRecyclerItems;
    public SearchHospitalListRecyclerViewAdapter(ArrayList itemList) {
        searchHospitalListRecyclerItems = itemList;
    }

    @NonNull
    @Override
    public SearchHospitalListRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_hospital_recycler, parent, false);
        SearchHospitalListRecyclerViewHolder holder = new SearchHospitalListRecyclerViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchHospitalListRecyclerViewHolder holder, int position) {

        holder.hospitalNameText.setText(searchHospitalListRecyclerItems.get(position).hospitalName);
        holder.hospitalLoacationText.setText(searchHospitalListRecyclerItems.get(position).hospitalLocation);
    }

    @Override
    public int getItemCount() {
        return searchHospitalListRecyclerItems.size();
    }
}
