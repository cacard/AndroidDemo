package com.cacard.demo.Event.Intercept.demo1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by cunqingli on 2016/7/21.
 */
public class VG1 extends FrameLayout {

    private static final String TAG = VG1.class.getSimpleName();

    public VG1(Context context) {
        super(context);
    }

    public VG1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VG1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        InterceptDemoActivity.dump("[" + TAG + "]dispatchTouchEvent:"
                + MotionEvent.actionToString(ev.getAction()));
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        InterceptDemoActivity.dump("[" + TAG + "]onInterceptTouchEvent:"
                + MotionEvent.actionToString(ev.getAction()));
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InterceptDemoActivity.dump("[" + TAG + "]onTouchEvent:"
                + MotionEvent.actionToString(event.getAction()));
        return super.onTouchEvent(event);
    }
}
