package momsday.app_daughters.Main.Main.MainContent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
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
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import momsday.app_daughters.R;

import static momsday.app_daughters.Main.Main.MainContent.MainFragment.MainContentContext;


public class MainContentFragment extends Fragment implements MainContentContract.View{

    public MainContentFragment() {
    }

    private SwipeRefreshLayout swipeRefreshLayout;
    private View rootView = null;
    private RecyclerView mainScheduleRecycler, mainConditionRecycler;
    private LinearLayoutManager mainScheduleLayoutManager, mainConditionLayoutManager;
    private MainScheduleRecyclerViewAdapter mainScheduleRecyclerAdapter;
    private MainConditionRecyclerViewAdapter mainConditionRecyclerAdapter;
    private ArrayList<MainRecyclerScheduleItem> mainRecyclerScheduleItems;
    private ArrayList<MainRecyclerConditionItem> mainRecyclerConditionItems;
    private TextView breakfastText, lunchText, dinnerText, snackText, dateText, photoCommentText, descriptionText, scheduleNoneText, conditionNoneText;
    private ImageView mainImageView;
    private String breakfast, lunch, dinner;
    private int position;
    private MainContentContract.Presenter presenter;
    private FragmentTransaction ft;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main_content, null);
        presenter = new MainContentPresenter();

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
        descriptionText = (TextView) rootView.findViewById(R.id.text_main_content_explain);
        scheduleNoneText = (TextView) rootView.findViewById(R.id.text_main_content_schedule_none);
        conditionNoneText = (TextView) rootView.findViewById(R.id.text_main_content_condition_none);
        swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_layout_main_content);
        ft = getFragmentManager().beginTransaction();



        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();

            }
        });

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

        presenter.setView(this);
        presenter.getMainModel(position);


        return rootView;
    }

    @Override
    public void setForm(Form form) {
        Log.d("Debug", "form" + form.toString());
        if (form.getSchedules().size() != 0) {
            for (int i = 0; i < form.getSchedules().size(); i++) {
                mainRecyclerScheduleItems.add(new MainRecyclerScheduleItem(form.getSchedules().get(i).getTime(), form.getSchedules().get(i).getWork()));
            }
        } else {
            scheduleNoneText.setVisibility(View.VISIBLE);
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
            Glide.with(this).load("http://" + form.getPhoto().getPhotoPath().replace("\\", "")).into(mainImageView);
        photoCommentText.setText(form.getPhoto().getComment());

        if (form.getCondition() != null) {
            mainRecyclerConditionItems.add(new MainRecyclerConditionItem("활동량 감소", "저체온", "고열", checkCondition(form.getCondition().isActivityReduction()), checkCondition(form.getCondition().isLowTemparature()), checkCondition(form.getCondition().isHighFever())));
            mainRecyclerConditionItems.add(new MainRecyclerConditionItem("고혈압", "저혈압", "수면 부족", checkCondition(form.getCondition().isBloodPressureincrease()), checkCondition(form.getCondition().isBloodPressureReduction()), checkCondition(form.getCondition().isLackOfSleep())));
            mainRecyclerConditionItems.add(new MainRecyclerConditionItem("식욕 감퇴", "폭식", "설사", checkCondition(form.getCondition().isLoseAppetite()), checkCondition(form.getCondition().isBingeEating()), checkCondition(form.getCondition().isDiarrhea())));
            mainRecyclerConditionItems.add(new MainRecyclerConditionItem("변비", "구토", "배뇨활동 불편", checkCondition(form.getCondition().isConstipation()), checkCondition(form.getCondition().isVomiting()), checkCondition(form.getCondition().isUrinationInconvenient())));
            mainRecyclerConditionItems.add(new MainRecyclerConditionItem("인지력 감퇴", "빈혈", "기침", checkCondition(form.getCondition().isHumanPowerReduction()), checkCondition(form.getCondition().isPovertyOfBlood()), checkCondition(form.getCondition().isCough())));
            mainConditionRecyclerAdapter.notifyDataSetChanged();
        } else {
            conditionNoneText.setVisibility(View.VISIBLE);
        }
        snackText.setText(form.getMeal().getSnack());
        descriptionText.setText(form.getAdditional().getDescription());
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(MainContentContext, "오류",Toast.LENGTH_SHORT).show();
    }

    public boolean checkCondition(Boolean condition) {
        return condition;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void refresh() {
        ft.detach(this).attach(this).commit();
    }
}
