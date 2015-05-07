package com.cacard.demo.FloatWindow;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cacard.demo.MyApplication;
import com.cacard.demo.R;

/**
 * Created by cunqingli on 2015/5/7.
 */
public class ActivityFloatWindow extends Activity {

    TextView tvWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);

        Button btn1 = new Button(this);
        btn1.setText("Show");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayFloatWindow();
            }
        });

        Button btn2 = new Button(this);
        btn2.setText("Hide");
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideFloatWindow();
            }
        });

        root.addView(btn1);
        root.addView(btn2);
        this.setContentView(root);

        final View vRoot = root;

        root.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() {
            @Override
            public void onWindowFocusChanged(boolean hasFocus) {
                Rect r = new Rect();
                vRoot.getWindowVisibleDisplayFrame(r);
                int height = r.bottom - vRoot.getBottom();
                Log.i("lcq", "WindowVisibleDisplayFrame:" + r.top + "/" + r.bottom + ",vRoot:" + vRoot.getTop() + "/" + vRoot.getBottom());
            }
        });

    }

    private void hideFloatWindow() {
        //tvWindow.setVisibility(View.GONE);
        MyApplication application = (MyApplication) getApplication();
        View v = application.floatWindowManager.getGlobalFloatView();
        if (v != null) {
            ((WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE)).removeView(v);
        }
        application.floatWindowManager.setIsAddedToWindow(false);
        application.floatWindowManager.setGlobalFloatView(null);
    }

    private void displayFloatWindow() {
        MyApplication application = (MyApplication) getApplication();
        if (application.floatWindowManager.isAddedToWindow()) {
            return;
        }

        tvWindow = new TextView(getApplicationContext());
        tvWindow.setText("Floating");
        //tvWindow.setBackgroundColor(Color.parseColor("#ffff00"));
        tvWindow.setBackground(getResources().getDrawable(R.drawable.shape_ring));
        tvWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TextView) v).setText("Clicked");
            }
        });

        WindowManager windowManager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        lp.format = 1;
        lp.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE; // 不能抢占聚焦点
        lp.flags = lp.flags | WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH;
        lp.flags = lp.flags | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS; // 排版不受限制
        lp.alpha = 1.0f;

        lp.gravity = Gravity.RIGHT | Gravity.BOTTOM;
        //以屏幕左上角为原点，设置x、y初始值
        lp.x = 0;
        lp.y = 496; // 具体要计算虚拟键的高度

        //设置悬浮窗口长宽数据
        lp.width = 240;
        lp.height = 240;

        windowManager.addView(tvWindow, lp);

        application.floatWindowManager.setGlobalFloatView(tvWindow);
        application.floatWindowManager.setIsAddedToWindow(true);
    }
}
