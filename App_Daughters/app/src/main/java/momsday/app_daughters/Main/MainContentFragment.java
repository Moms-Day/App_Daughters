package momsday.app_daughters.Main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import momsday.app_daughters.R;


public class MainContentFragment extends Fragment {

    public MainContentFragment() { }

    View rootView = null;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.KOREAN);
    Date date = new Date();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main_content,null);
        return rootView;
    }
}
