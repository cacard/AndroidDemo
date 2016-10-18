package com.cacard.demo.DesignSupportLibrary.CoornaditorLayout;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.UiThread;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.cacard.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * CoornaditorLayout与Fab的互动
 * <p>
 * - SnackBar使用的view应是CoornaditorLayout，否者无法实现“交互”。
 * - 不要复用一个SnackBar对象，因为它是通过动画来消失的，再次让它show，它是不会显示的。
 * <p>
 * Created by cunqingli on 2015/9/17.
 */
public class CoornaditorLayoutAndFABActivity extends Activity {

    private static final String TAG = "CoornaditorLayoutAndFABActivity";

    @Bind(R.id.fab)
    FloatingActionButton fab;

    @Bind(R.id.root)
    CoordinatorLayout root;

    boolean isShowing = false;
    @UiThread
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coornditor_and_fab);
        ButterKnife.bind(this);

        // fab点击动作
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i(TAG, "->fab click.snackbar");

                    if (isShowing) {
                        return;
                    }

                    Snackbar snackbar = Snackbar.make(root/* ! */, "Hello", Snackbar.LENGTH_LONG).setDuration(Snackbar.LENGTH_LONG);
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
        }
    }
}
