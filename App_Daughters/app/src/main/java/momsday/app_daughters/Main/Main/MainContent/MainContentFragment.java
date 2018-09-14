package momsday.app_daughters.Main.Main.MainContent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import momsday.app_daughters.R;


public class MainContentFragment extends Fragment {

    public MainContentFragment() {
    }

    private View rootView = null;
    private RecyclerView mainScheduleRecycler, mainConditionRecycler;
    private LinearLayoutManager mainScheduleLayoutManager, mainConditionLayoutManager;
    private MainScheduleRecyclerViewAdapter mainScheduleRecyclerAdapter;
    private MainConditionRecyclerViewAdapter mainConditionRecyclerAdapter;
    private ArrayList<MainRecyclerScheduleItem> mainRecyclerScheduleItems;
    private ArrayList<MainRecyclerConditionItem> mainRecyclerConditionItems;
    private Form form;
    private TextView breakfastText, lunchText, dinnerText, snackText, dateText, photoCommentText;
    private ImageView mainImageView;
    private String breakfast, lunch, dinner;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main_content, null);

        breakfast = "";
        lunch = "";
        dinner = "";
        mainScheduleRecycler = (RecyclerView) rootView.findViewById(R.id.recycler_main_schedule);
        mainScheduleLayoutManager = new LinearLayoutManager(getContext());
        mainScheduleLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mainRecyclerScheduleItems = new ArrayList();
        breakfastText = (TextView) rootView.findViewById(R.id.text_main_content_breakfast);
        lunchText = (TextView) rootView.findViewById(R.id.text_main_content_lunch);
        dinnerText = (TextView) rootView.findViewById(R.id.text_main_content_dinner);
        snackText = (TextView) rootView.findViewById(R.id.text_main_content_snack);
        dateText = (TextView) rootView.findViewById(R.id.text_main_content_date);
        mainImageView = (ImageView) rootView.findViewById(R.id.image_main_content_image);
        photoCommentText = (TextView) rootView.findViewById(R.id.text_main_content_photo_comment);
//todo         mainImageView = (ImageView) rootView.findViewById()

        mainScheduleRecycler.setLayoutManager(mainScheduleLayoutManager);
        mainScheduleRecycler.setItemAnimator(new DefaultItemAnimator());

        mainScheduleRecyclerAdapter = new MainScheduleRecyclerViewAdapter(mainRecyclerScheduleItems);
        mainScheduleRecycler.setAdapter(mainScheduleRecyclerAdapter);


        mainConditionRecycler = (RecyclerView) rootView.findViewById(R.id.recycler_main_condition);
        mainConditionLayoutManager = new LinearLayoutManager(getContext());
        mainConditionLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mainRecyclerConditionItems = new ArrayList<>();

        mainConditionRecycler.setLayoutManager(mainConditionLayoutManager);
        mainConditionRecycler.setItemAnimator(new DefaultItemAnimator());

        mainConditionRecyclerAdapter = new MainConditionRecyclerViewAdapter(mainRecyclerConditionItems);
        mainConditionRecycler.setAdapter(mainConditionRecyclerAdapter);

        return rootView;
    }

    public void setForm(Form form) {
        this.form = form;
        Log.d("Debug", "form" + form.toString());
        if(form.getSchedules().size() != 0) {
            for (int i = 0; i < form.getSchedules().size(); i++) {
                mainRecyclerScheduleItems.add(new MainRecyclerScheduleItem(form.getSchedules().get(i).getTime(), form.getSchedules().get(i).getWork()));
            }
        }

        mainScheduleRecyclerAdapter.notifyDataSetChanged();

        if (form.getMeal().getBreakfast() != null) {
            for (int i = 0; i < form.getMeal().getBreakfast().length; i++) {
                breakfast += form.getMeal().getBreakfast()[i] + "\n";
                breakfastText.setText(breakfast);
            }
        }
        if (form.getMeal().getLunch() != null) {
            for (int i = 0; i < form.getMeal().getLunch().length; i++) {
                lunch += form.getMeal().getLunch()[i] + "\n";
                lunchText.setText(lunch);
            }
        }
        if (form.getMeal().getDinner() != null) {
            for (int i = 0; i < form.getMeal().getDinner().length; i++) {
                dinner += form.getMeal().getDinner()[i] + "\n";
                dinnerText.setText(dinner);
            }
        }
        dateText.setText(form.getDate());
        if (!TextUtils.isEmpty(form.getPhoto().getPhotoPath()))
            Glide.with(getContext()).load("http://" + form.getPhoto().getPhotoPath().replace("\\", "")).into(mainImageView);
        photoCommentText.setText(form.getPhoto().getComment());

        if(form.getConditions().size() != 0) {
            mainRecyclerConditionItems.add(new MainRecyclerConditionItem("활동량 감소", "저체온", "고열", checkCondition(form.getConditions().get(0).isActivityReduction()), checkCondition(form.getConditions().get(0).isLowTemparature()), checkCondition(form.getConditions().get(0).isHighFever())));
            mainRecyclerConditionItems.add(new MainRecyclerConditionItem("고혈압", "저혈압", "수면 부족", checkCondition(form.getConditions().get(0).isBloodPressureincrease()), checkCondition(form.getConditions().get(0).isBloodPressureReduction()), checkCondition(form.getConditions().get(0).isLackOfSleep())));
            mainRecyclerConditionItems.add(new MainRecyclerConditionItem("식욕 감퇴", "폭식", "설사", checkCondition(form.getConditions().get(0).isLoseAppetite()), checkCondition(form.getConditions().get(0).isBingeEating()), checkCondition(form.getConditions().get(0).isDiarrhea())));
            mainRecyclerConditionItems.add(new MainRecyclerConditionItem("변비", "구토", "배뇨활동 불편", checkCondition(form.getConditions().get(0).isConstipation()), checkCondition(form.getConditions().get(0).isVomiting()), checkCondition(form.getConditions().get(0).isUrinationInconvenient())));
            mainRecyclerConditionItems.add(new MainRecyclerConditionItem("인지력 감퇴", "빈혈", "기침", checkCondition(form.getConditions().get(0).isHumanPowerReduction()), checkCondition(form.getConditions().get(0).isPovertyOfBlood()), checkCondition(form.getConditions().get(0).isCough())));
        }
        init();
    }

    public void init() {
        mainRecyclerScheduleItems = new ArrayList();
        breakfast = "";
        lunch = "";
        dinner = "";
    }

    public boolean checkCondition(Boolean condition) {
        if(condition == null) {
            return false;
        } else
            return true;
    }
}
