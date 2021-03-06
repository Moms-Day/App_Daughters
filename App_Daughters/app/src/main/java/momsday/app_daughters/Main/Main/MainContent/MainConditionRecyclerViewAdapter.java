package momsday.app_daughters.Main.Main.MainContent;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import momsday.app_daughters.R;

public class MainConditionRecyclerViewAdapter extends RecyclerView.Adapter<MainConditionRecyclerViewHolder>{
    private ArrayList<MainRecyclerConditionItem> mainRecyclerConditionItems;
    Context mainRecyclerConditionContext;
    public MainConditionRecyclerViewAdapter(ArrayList itemList) {
        mainRecyclerConditionItems = itemList;
    }
    @Override
    public MainConditionRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_recycler_condition, parent, false);
        mainRecyclerConditionContext = parent.getContext();
        MainConditionRecyclerViewHolder holder = new MainConditionRecyclerViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainConditionRecyclerViewHolder holder, int position) {
        holder.checkbox1.setText(mainRecyclerConditionItems.get(position).checkbox1Name);
        holder.checkbox2.setText(mainRecyclerConditionItems.get(position).checkbox2Name);
        holder.checkbox3.setText(mainRecyclerConditionItems.get(position).checkbox3Name);
        holder.checkbox1.setChecked(mainRecyclerConditionItems.get(position).checkbox1Checked);
        holder.checkbox2.setChecked(mainRecyclerConditionItems.get(position).checkbox2Checked);
        holder.checkbox3.setChecked(mainRecyclerConditionItems.get(position).checkbox3Checked);
    }
    @Override
    public int getItemCount() {
        return mainRecyclerConditionItems.size();
    }
}
