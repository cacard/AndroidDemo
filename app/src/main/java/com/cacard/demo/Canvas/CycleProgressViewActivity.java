package com.cacard.demo.Canvas;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;

/**
 * Created by cunqingli on 2015/5/7.
 */
public class CycleProgressViewActivity extends Activity {

    private CycleProgressView cycleView;
    private CycleProgressView cycleView2;
    private float progress = 0;
    private int DELAY = 100;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (progress >= 1.0f) {
                return;
            } else {
                progress += 0.001;
                cycleView.updateProgress(progress);
                cycleView2.updateProgress(progress);
                sendEmptyMessageDelayed(0, DELAY);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout root = new FrameLayout(this);

        // View是正方形
        cycleView = new CycleProgressView(this);
        cycleView.setLayoutParams(new FrameLayout.LayoutParams(500, 500));

        // View是非正方形
        cycleView2 = new CycleProgressView(this);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(800, 500);
        lp.topMargin = 600;
        cycleView2.setLayoutParams(lp);
        cycleView2.setBackgroundColor(Color.parseColor("#55dddddd"));

        // 模拟进度
        Button btn = new Button(this);
        FrameLayout.LayoutParams lpBtn = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lpBtn.gravity = Gravity.BOTTOM;
        btn.setText("Start");
        btn.setLayoutParams(lpBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startProgress();
            }
        });

        root.addView(cycleView);
        root.addView(cycleView2);
        root.addView(btn);
        this.setContentView(root);
    }

    private void startProgress() {
        mHandler.sendEmptyMessageDelayed(0, DELAY);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mHandler != null) {
            mHandler.removeCallbacksAndMessages(null);
        }
    }


}
