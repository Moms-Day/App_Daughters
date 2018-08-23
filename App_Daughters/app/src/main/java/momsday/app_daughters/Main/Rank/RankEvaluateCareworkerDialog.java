package momsday.app_daughters.Main.Rank;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import momsday.app_daughters.R;

public class RankEvaluateCareworkerDialog extends Dialog {
    private TextView evaluateCareworkerDialogCancelText;
    private View.OnClickListener careworkerDialogCancelClickListener;

    public RankEvaluateCareworkerDialog(@NonNull Context context, View.OnClickListener careworkerDialogCancelClickListener) {
        super(context);
        this.careworkerDialogCancelClickListener = careworkerDialogCancelClickListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);
        setContentView(R.layout.dialog_rank_evaluate_careworker);

        evaluateCareworkerDialogCancelText = (TextView) findViewById(R.id.text_rank_evaluate_careworker_cancel);

        if(careworkerDialogCancelClickListener != null) {
            evaluateCareworkerDialogCancelText.setOnClickListener(careworkerDialogCancelClickListener);
        }
    }
}
