package momsday.app_daughters.Main.Main.MainContent;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;

import momsday.app_daughters.R;

public class MainConditionRecyclerViewHolder extends RecyclerView.ViewHolder{

    public CheckBox checkbox1, checkbox2, checkbox3;

    public MainConditionRecyclerViewHolder(View itemView) {
        super(itemView);
        checkbox1 = (CheckBox) itemView.findViewById(R.id.checkbox1_main_condition);
        checkbox2 = (CheckBox) itemView.findViewById(R.id.checkbox2_main_condition);
        checkbox3 = (CheckBox) itemView.findViewById(R.id.checkbox3_main_condition);
    }
}
