package momsday.app_daughters.MyPage;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import momsday.app_daughters.R;

public class ChangePwDialog extends Dialog {

    private ImageButton changePwCancelBtn;
    private Button changePwChangeBtn;
    private View.OnClickListener changePwCancelClickListener, changePwChangeClickListener;

    public ChangePwDialog(@NonNull Context context, View.OnClickListener changePwCancelClickListener, View.OnClickListener changePwChangeClickListener) {
        super(context);
        this.changePwCancelClickListener = changePwCancelClickListener;
        this.changePwChangeClickListener = changePwChangeClickListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);
        setContentView(R.layout.dialog_change_pw);

        changePwCancelBtn = (ImageButton) findViewById(R.id.btn_change_pw_cancel);
        changePwChangeBtn = (Button) findViewById(R.id.btn_change_pw_change);

        if(changePwCancelClickListener != null) {
            changePwCancelBtn.setOnClickListener(changePwCancelClickListener);
        }
        if(changePwChangeClickListener != null) {
            changePwChangeBtn.setOnClickListener(changePwChangeClickListener);
        }
    }
}
