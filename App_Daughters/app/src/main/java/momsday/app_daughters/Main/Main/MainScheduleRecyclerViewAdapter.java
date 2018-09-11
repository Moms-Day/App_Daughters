package momsday.app_daughters.Main.Main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import momsday.app_daughters.R;

public class MainScheduleRecyclerViewAdapter extends RecyclerView.Adapter<MainScheduleRecyclerViewHolder>{
    private ArrayList<MainRecyclerScheduleItem> mainRecyclerScheduleItems;
    Context mainRecyclerScheduleContext;
    public MainScheduleRecyclerViewAdapter(ArrayList itemList) {
        mainRecyclerScheduleItems = itemList;
    }

    @Override
    public MainScheduleRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_recycler_schedule, parent, false);
        mainRecyclerScheduleContext = parent.getContext();
        MainScheduleRecyclerViewHolder holder = new MainScheduleRecyclerViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MainScheduleRecyclerViewHolder holder, final int position) {
        // 해당 position 에 해당하는 데이터 결합
        holder.scheduleTimeText.setText(mainRecyclerScheduleItems.get(position).time);
        holder.scheduleWorkText.setText(mainRecyclerScheduleItems.get(position).work);

    }

    @Override
    public int getItemCount() {
        return mainRecyclerScheduleItems.size();
    }
}
