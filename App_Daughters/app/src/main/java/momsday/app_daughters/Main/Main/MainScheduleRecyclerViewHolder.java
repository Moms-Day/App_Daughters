package momsday.app_daughters.Main.Main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import momsday.app_daughters.R;

public class MainScheduleRecyclerViewHolder extends RecyclerView.ViewHolder{

    public TextView scheduleStartTimeText, scheduleEndTimeText, scheduleWorkText;

    public MainScheduleRecyclerViewHolder(View itemView) {
        super(itemView);
        scheduleStartTimeText = (TextView) itemView.findViewById(R.id.text_recycler_schedule_start_time);
        scheduleEndTimeText = (TextView) itemView.findViewById(R.id.text_recycler_schedule_end_time);
        scheduleWorkText = (TextView) itemView.findViewById(R.id.text_main_recycler_schedule_work);
    }
}
