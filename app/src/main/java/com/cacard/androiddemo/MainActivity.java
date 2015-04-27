package com.cacard.androiddemo;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.cacard.androiddemo.CustomControl.PageableHorizonalScrollView.ActivityPageableHorizonalScrollView;
import com.cacard.androiddemo.DrawableAndImage.ClipDrawableActivity;
import com.cacard.androiddemo.GestureDetectorDemo.GestureDetectorDemoActivity;
import com.cacard.androiddemo.ViewDragHelperDemo.VDHActivity;
import com.cacard.androiddemo.activity.ActivityTestRootMeasureSpec;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //super.setContentView(R.layout.main_activity); // 使用super而不是this，可减少方法数
        super.setTitle("Main");
        setContentView(R.layout.test_layout);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        View vParent = findViewById(R.id.parent);
        View vChild = findViewById(R.id.child);

        Log.i("lcq", "vParent:" + vParent.getMeasuredWidth() + "/" + vParent.getMeasuredHeight() + "," + vParent.getWidth());
        Log.i("lcq", "vChild:" + vChild.getMeasuredWidth() + "/" + vChild.getMeasuredHeight() + "," + vChild.getWidth());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            gotoActivity(ClipDrawableActivity.class);
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
