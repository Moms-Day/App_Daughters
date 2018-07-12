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
    // 필수 오버라이드 : View 생성, ViewHolder 호출
    @Override
    public MainScheduleRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_recycler_schedule, parent, false);
        mainRecyclerScheduleContext = parent.getContext();
        MainScheduleRecyclerViewHolder holder = new MainScheduleRecyclerViewHolder(v);
        return holder;
    }
    // 필수 오버라이드 : 재활용되는 View 가 호출, Adapter 가 해당 position 에 해당하는 데이터를 결합
    @Override
    public void onBindViewHolder(MainScheduleRecyclerViewHolder holder, final int position) {
        // 해당 position 에 해당하는 데이터 결합
        holder.scheduleStartTimeText.setText(mainRecyclerScheduleItems.get(position).startTime);
        holder.scheduleEndTimeText.setText(mainRecyclerScheduleItems.get(position).endTime);
        holder.scheduleWorkText.setText(mainRecyclerScheduleItems.get(position).work);

    }
    // 필수 오버라이드 : 데이터 갯수 반환
    @Override
    public int getItemCount() {
        return mainRecyclerScheduleItems.size();
    }
}
