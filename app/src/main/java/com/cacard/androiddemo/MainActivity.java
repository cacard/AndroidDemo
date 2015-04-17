package com.cacard.androiddemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;

import com.cacard.androiddemo.activity.ActivityPageableHorizonalScrollView;
import com.cacard.androiddemo.activity.singleinstance.Activity1;
import com.cacard.androiddemo.event.ActivityMotionEvent;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.main_activity); // 使用super而不是this，可减少方法数
        super.setTitle("Main");

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            gotoActivity(ActivityPageableHorizonalScrollView.class);
            return true;
        }

        return super.onTouchEvent(event);
    }

    private void gotoActivity(Class<?> clazz) {
        this.startActivity(new Intent(this, clazz));
    }

    private void log(String msg) {
        Log.i("lcq", msg);
    }

    /**
     * 监视ViewThree
     */
    private void addViewThreeObServer(View v) {
        if (v == null) {
            return;
        }

        ViewTreeObserver ob = v.getViewTreeObserver();
        if (ob == null) {
            return;
        }

        if (ob.isAlive()) {
            ob.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    log("->ob.addOnGlobalLayoutListener");
                }
            });
        }
    }
}
