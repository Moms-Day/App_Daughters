package momsday.app_daughters.SignUp;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import momsday.app_daughters.R;

public class FirstFragment extends Fragment {
    public static EditText signUpIdEdit, signUpPwEdit;
    public FirstFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ConstraintLayout layout = (ConstraintLayout) inflater.inflate(R.layout.fragment_sign_up_first, container, false);
        signUpIdEdit = (EditText) layout.findViewById(R.id.edit_signup_id);
        signUpPwEdit = (EditText) layout.findViewById(R.id.edit_signup_pw);

        return layout;
    }
}
