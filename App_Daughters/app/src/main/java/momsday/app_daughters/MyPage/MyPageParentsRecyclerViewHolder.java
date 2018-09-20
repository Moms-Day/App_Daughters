package momsday.app_daughters.MyPage;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import momsday.app_daughters.R;

public class MyPageParentsRecyclerViewHolder extends RecyclerView.ViewHolder {
    public EditText parentNameEdit, parentAgeEdit;
    public RadioButton parentMaleRadioBtn, parentFemaleRadioBtn;

    public MyPageParentsRecyclerViewHolder(View itemView) {
        super(itemView);

        parentNameEdit = (EditText) itemView.findViewById(R.id.edit_my_page_parent_name);
        parentAgeEdit = (EditText) itemView.findViewById(R.id.edit_my_page_parent_age);
        parentMaleRadioBtn = (RadioButton) itemView.findViewById(R.id.radiobtn_my_page_parent_male);
        parentFemaleRadioBtn = (RadioButton) itemView.findViewById(R.id.radiobtn_my_page_parent_female);
    }
}
