package com.cacard.demo.Event.Intercept.demo1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by cunqingli on 2016/7/21.
 */
public class TV1 extends TextView {

    private static final String TAG = "TV";

    public TV1(Context context) {
        super(context);
    }

    public TV1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TV1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        InterceptDemoActivity.dump("[" + TAG + "]dispatchTouchEvent:"
                + MotionEvent.actionToString(event.getAction()));
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InterceptDemoActivity.dump("[" + TAG + "]onTouchEvent:"
                + MotionEvent.actionToString(event.getAction()));
        return super.onTouchEvent(event);
    }
}
