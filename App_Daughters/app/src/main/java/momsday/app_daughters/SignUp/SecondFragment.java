package momsday.app_daughters.SignUp;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import momsday.app_daughters.R;

public class SecondFragment extends Fragment {
    public static EditText signUpPhoneNumberEdit, signUpCertifyCodeEdit, signUpNameEdit, signUpAgeEdit;
    public static Button signUpCertifyCodeBtn;
    public SecondFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ConstraintLayout layout = (ConstraintLayout) inflater.inflate(R.layout.fragment_sign_up_second, container, false);

        signUpPhoneNumberEdit = (EditText) layout.findViewById(R.id.edit_signup_phone_number);
        signUpCertifyCodeEdit = (EditText) layout.findViewById(R.id.edit_signup_certification);
        signUpNameEdit = (EditText) layout.findViewById(R.id.edit_signup_name);
        signUpAgeEdit = (EditText) layout.findViewById(R.id.edit_signup_age);
        signUpCertifyCodeBtn = (Button) layout.findViewById(R.id.btn_signup_certify);

        return layout;
    }

}
