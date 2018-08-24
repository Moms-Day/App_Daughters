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

public class WithdrawalDialog extends Dialog {

    private ImageButton withdrawalDialogCancelBtn;
    private Button withdrawalDialogWithdrawalBtn;
    private View.OnClickListener withdrawalCancelClickListenr, withdrawalClickListener;

    public WithdrawalDialog(@NonNull Context context, View.OnClickListener withdrawalCancelClickListenr, View.OnClickListener withdrawalClickListener) {
        super(context);
        this.withdrawalCancelClickListenr = withdrawalCancelClickListenr;
        withdrawalClickListener = withdrawalClickListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);
        setContentView(R.layout.dialog_withdrawal);

        withdrawalDialogCancelBtn = (ImageButton) findViewById(R.id.btn_withdrawal_cancel);
        withdrawalDialogWithdrawalBtn = (Button) findViewById(R.id.btn_withdrawal);

        if(withdrawalCancelClickListenr != null) {
            withdrawalDialogCancelBtn.setOnClickListener(withdrawalCancelClickListenr);
        }
        if(withdrawalClickListener != null) {
            withdrawalDialogWithdrawalBtn.setOnClickListener(withdrawalClickListener);
        }
    }
}
