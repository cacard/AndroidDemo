package com.cacard.demo.Event.Intercept.demo1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import com.cacard.demo.R;

/**
 * Created by cunqingli on 2016/7/21.
 */
public class InterceptDemoActivity extends Activity {

    public static final String TAG = InterceptDemoActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intercept_demo);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        InterceptDemoActivity.dump("[" + TAG + "]dispatchTouchEvent:"
                + MotionEvent.actionToString(ev.getAction()));
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        InterceptDemoActivity.dump("[" + TAG + "]onTouchEvent:"
                + MotionEvent.actionToString(ev.getAction()));

        //return true;

        final boolean b = super.onTouchEvent(ev);
        return b;
    }

    public static void dump(String msg) {
        Log.i(TAG, msg);
    }
}
