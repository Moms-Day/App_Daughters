package momsday.app_daughters.Main.Main.MainContent;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import momsday.app_daughters.R;

public class MainScheduleRecyclerViewHolder extends RecyclerView.ViewHolder{

    public TextView scheduleTimeText, scheduleWorkText;

    public MainScheduleRecyclerViewHolder(View itemView) {
        super(itemView);
        scheduleTimeText = (TextView) itemView.findViewById(R.id.text_main_recycler_shedule_time);
        scheduleWorkText = (TextView) itemView.findViewById(R.id.text_main_recycler_schedule_work);
    }
}
