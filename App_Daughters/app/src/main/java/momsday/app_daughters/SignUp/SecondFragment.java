package momsday.app_daughters.SignUp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import momsday.app_daughters.R;

public class SecondFragment extends Fragment {
    public SecondFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ConstraintLayout layout = (ConstraintLayout) inflater.inflate(R.layout.fragment_second, container, false);
        TextView signUpInformParentText = (TextView) layout.findViewById(R.id.text_signup_inform_parent);
        String str = "*부모정보(선택)";
        SpannableStringBuilder ssb = new SpannableStringBuilder(str);
        ssb.setSpan(new ForegroundColorSpan(Color.parseColor("#ff5858")), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        signUpInformParentText.setText(ssb);
        return layout;
    }

}
