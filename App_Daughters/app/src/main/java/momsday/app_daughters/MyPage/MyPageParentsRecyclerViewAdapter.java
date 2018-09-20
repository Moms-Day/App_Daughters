package momsday.app_daughters.MyPage;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import momsday.app_daughters.R;
import momsday.app_daughters.SearchHospital.SearchHospitalListRecyclerViewHolder;

public class MyPageParentsRecyclerViewAdapter extends RecyclerView.Adapter<MyPageParentsRecyclerViewHolder> {

    private ArrayList<MyPageParentsRecyclerItem> myPageParentsRecyclerItems;

    public MyPageParentsRecyclerViewAdapter(ArrayList itemList) {
        myPageParentsRecyclerItems = itemList;
    }

    @NonNull
    @Override
    public MyPageParentsRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_page_parent_inform, parent, false);
        MyPageParentsRecyclerViewHolder holder = new MyPageParentsRecyclerViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyPageParentsRecyclerViewHolder holder, int position) {
        holder.parentNameEdit.setText(myPageParentsRecyclerItems.get(position).parentName);
        holder.parentAgeEdit.setText(myPageParentsRecyclerItems.get(position).parentAge);
        if(myPageParentsRecyclerItems.get(position).parentGender) holder.parentMaleRadioBtn.setChecked(true);
        else holder.parentFemaleRadioBtn.setChecked(true);
    }

    @Override
    public int getItemCount() {
        return myPageParentsRecyclerItems.size();
    }
}
