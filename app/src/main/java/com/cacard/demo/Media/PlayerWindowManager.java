package com.cacard.demo.Media;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.cacard.demo.Canvas.CycleProgressView;
import com.cacard.demo.MyApplication;
import com.cacard.demo.R;

/**
 * 音频播放小窗口管理器
 * Created by cunqingli on 2015/5/8.
 */
public class PlayerWindowManager {

    private static PlayerWindowManager instance = new PlayerWindowManager();
    private boolean isShowing = false; // 是否正在显示
    private CycleProgressView view; // 窗口承载的View

    private PlayerWindowManager() {
    }

    public static PlayerWindowManager getInstance() {
        return instance;
    }

    /**
     * 创建并显示小窗
     */
    public void createAndShowWindow() {
        if (isShowing) {
            return;
        }

        view = new CycleProgressView(MyApplication.instance);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        WindowManager windowManager = (WindowManager) MyApplication.instance.getSystemService(Context.WINDOW_SERVICE);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        lp.format = 1;
        lp.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        lp.flags = lp.flags | WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH;
        lp.flags = lp.flags | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS;
        lp.alpha = 0.7f;

        lp.gravity = Gravity.RIGHT | Gravity.BOTTOM;
        lp.x = 0;
        lp.y = 200; // 具体要计算虚拟键的高度

        lp.width = 240;
        lp.height = 240;

        windowManager.addView(view, lp);

        isShowing = true;
    }

    /**
     * 销毁小窗
     */
    public void removeWindow() {
        if (isShowing && view != null) {
            ((WindowManager) MyApplication.instance.getSystemService(Context.WINDOW_SERVICE)).removeView(view);
        }

        isShowing = false;
        view = null;
    }

}
