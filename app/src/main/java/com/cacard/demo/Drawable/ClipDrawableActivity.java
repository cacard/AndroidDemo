package com.cacard.demo.Drawable;

import android.app.Activity;
import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.cacard.demo.R;

/**
 * Created by cunqingli on 2015/4/27.
 */
public class ClipDrawableActivity extends Activity {

    private ClipDrawable cd;
    private int level;
    private int delay = 10;
    private static final int MAX = 10000; // max value of level
    private TextView tvLog;

    private Handler myHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (level > MAX) {
                return;
            }

            if (cd != null) {
                cd.setLevel(level);
                log(level);
                this.sendEmptyMessageDelayed(0, delay);
                level += 10;
            }
        }
    };

    private void log(final int level) {
        tvLog.post(new Runnable() {
            @Override
            public void run() {
                tvLog.setText("level:" + level);
            }
        });
        Log.i("lcq", "level=" + level);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_clip_drawable);

        ImageView iv = (ImageView) findViewById(R.id.iv);
        cd = (ClipDrawable) iv.getDrawable();
        cd.setLevel(0);

        tvLog = (TextView) findViewById(R.id.tvLog);
    }

    @Override
    protected void onStart() {
        super.onStart();
        myHandler.sendEmptyMessageDelayed(0, delay);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (myHandler != null) {
            myHandler.removeCallbacksAndMessages(null);
        }
    }


}
