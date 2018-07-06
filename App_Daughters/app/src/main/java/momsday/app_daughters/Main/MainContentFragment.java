package momsday.app_daughters.Main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import momsday.app_daughters.R;


public class MainContentFragment extends Fragment {

    public MainContentFragment() { }

    View rootView = null;
    RecyclerView mainScheduleRecycler, mainConditionRecycler;
    LinearLayoutManager mainScheduleLayoutManager, mainConditionLayoutManager;
    MainScheduleRecyclerViewAdapter mainScheduleRecyclerAdapter;
    MainConditionRecyclerViewAdapter mainConditionRecyclerAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main_content,null);


        mainScheduleRecycler = (RecyclerView)rootView.findViewById(R.id.recycler_main_schedule);
        mainScheduleLayoutManager = new LinearLayoutManager(getContext());
        mainScheduleLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ArrayList<MainRecyclerScheduleItem> mainRecyclerScheduleItems = new ArrayList();

        mainRecyclerScheduleItems.add(new MainRecyclerScheduleItem("6","7","ㄹㄹ"));
        mainRecyclerScheduleItems.add(new MainRecyclerScheduleItem("7","8","바보"));
        mainScheduleRecycler.setLayoutManager(mainScheduleLayoutManager);
        mainScheduleRecycler.setItemAnimator(new DefaultItemAnimator());

        mainScheduleRecyclerAdapter = new MainScheduleRecyclerViewAdapter(mainRecyclerScheduleItems);
        mainScheduleRecycler.setAdapter(mainScheduleRecyclerAdapter);


        mainConditionRecycler = (RecyclerView)rootView.findViewById(R.id.recycler_main_condition);
        mainConditionLayoutManager = new LinearLayoutManager(getContext());
        mainConditionLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ArrayList<MainRecyclerConditionItem> mainRecyclerConditionItems = new ArrayList<>();

        mainRecyclerConditionItems.add(new MainRecyclerConditionItem("활동량 감소","저체온","고열"));
        mainRecyclerConditionItems.add(new MainRecyclerConditionItem("고혈압","저혈압","수면 부족"));
        mainRecyclerConditionItems.add(new MainRecyclerConditionItem("식욕 감퇴","폭식","설사"));
        mainRecyclerConditionItems.add(new MainRecyclerConditionItem("변비","구토","배뇨활동 불편"));
        mainRecyclerConditionItems.add(new MainRecyclerConditionItem("인지력 감퇴","빈혈","기침"));
        //객혈추가
        mainConditionRecycler.setLayoutManager(mainConditionLayoutManager);
        mainConditionRecycler.setItemAnimator(new DefaultItemAnimator());

        mainConditionRecyclerAdapter = new MainConditionRecyclerViewAdapter(mainRecyclerConditionItems);
        mainConditionRecycler.setAdapter(mainConditionRecyclerAdapter);

        return rootView;
    }
}
