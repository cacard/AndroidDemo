package com.cacard.androiddemo.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class MySimpleLinearLayout extends LinearLayout {

    private final String logTag = "test";
    private final String logClassName = "MySimpleLinearLayout";

    public MySimpleLinearLayout(Context context) {
        super(context);
        Log.i(logTag, logClassName + " ctor1");
    }

    public MySimpleLinearLayout(Context context, AttributeSet attr) {
        super(context, attr);
        Log.i("test", logClassName + " ctor2");
    }


    // ************************
    // measure/layout/draw相关
    // ************************

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    // ************************
    // 事件相关
    // ************************

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i(logTag, logClassName + " onInterceptTouchEvent(),event.getAction=" + ev.getAction());
        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i(logTag, logClassName + " dispatchTouchEvent(),event.getAction=" + event.getAction());
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(logTag, logClassName + " onTouchEvent(),event.getAction=" + event.getAction());
        super.onTouchEvent(event);
        return false;
    }

}
