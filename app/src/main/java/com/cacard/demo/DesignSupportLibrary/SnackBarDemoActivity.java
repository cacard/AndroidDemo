package com.cacard.demo.DesignSupportLibrary;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 *- 不要复用一个SnackBar对象，因为它是通过动画来消失的，再次让它show，它是不会显示的。
 * Created by cunqingli on 2015/9/16.
 */
public class SnackBarDemoActivity extends Activity {

    private static final String TAG = SnackBarDemoActivity.class.getSimpleName();
    private RelativeLayout layout;

    private boolean isShowing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout layout = new RelativeLayout(this);
        this.setContentView(layout);

        final View decorView = this.getWindow().getDecorView();
        final View decorView2 = findViewById(android.R.id.content);
        Log.i(TAG, "decorView equls?" + (decorView == decorView2));

        Button btn = new Button(this);
        btn.setText(" CLICK ON ME ");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShowing){
                    return;
                }

                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content) /* no CoornaditorLayout */, "Hello", Snackbar.LENGTH_LONG).setDuration(Snackbar.LENGTH_LONG);
                snackbar.setCallback(new Snackbar.Callback() {
                    @Override
                    public void onDismissed(Snackbar snackbar, int event) {
                        super.onDismissed(snackbar, event);
                        isShowing = false;
                        Log.i(TAG, "->snackbar.onDismissed,event=" + event);
                    }

                    @Override
                    public void onShown(Snackbar snackbar) {
                        isShowing = true;
                        super.onShown(snackbar);
                        Log.i(TAG, "->snackbar.onShown,event=");
                    }
                });

                // 通过findViewById设置文本字体颜色
                TextView tvText = (TextView) snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);
                if (tvText != null) {
                    tvText.setTextColor(Color.RED);
                }

                snackbar.show();
            }
        });

        layout.addView(btn);
    }
}
