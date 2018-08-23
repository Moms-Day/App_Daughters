package momsday.app_daughters.RequestConnection;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import momsday.app_daughters.R;

public class RequestConnectionDialog extends Dialog {
    private TextView text1, moveRankText;
    private Button moveConnectText;
    private View.OnClickListener moveRankClickListener, moveConnectClickListener;

    public RequestConnectionDialog(@NonNull Context context, View.OnClickListener moveRankClickListener, View.OnClickListener moveConnectClickListener) {
        super(context);
        this.moveRankClickListener = moveRankClickListener;
        this.moveConnectClickListener = moveConnectClickListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);
        setContentView(R.layout.dialog_request_connection);

        text1 = (TextView) findViewById(R.id.text_dialog_request_connection);
        moveRankText = (TextView) findViewById(R.id.text_dialog_request_connection_move_rank);
        moveConnectText = (Button) findViewById(R.id.btn_dialog_request_connection_move_connect);

        text1.setText("해당 기능을 이용하기 위해선\n요양보호사와 연결이 되어있어야 합니다.");

        if(moveRankClickListener != null) {
            moveRankText.setOnClickListener(moveRankClickListener);
        }
        if(moveConnectClickListener != null) {
            moveConnectText.setOnClickListener(moveConnectClickListener);
        }
    }
}
