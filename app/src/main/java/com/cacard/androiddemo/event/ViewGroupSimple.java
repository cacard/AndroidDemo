package com.cacard.androiddemo.event;

/**
 * Created by cunqingli on 2015/2/5.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import com.cacard.androiddemo.MyApplication;

public class ViewGroupSimple extends FrameLayout/* 可在布局中添加子View */ {

    private static final String TAG = "ViewGroupSimple";

    public ViewGroupSimple(Context context) {
        super(context);
    }

    public ViewGroupSimple(Context context, AttributeSet attr) {
        super(context, attr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    // ViewGroup的onLayout是abstract的
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
    public boolean dispatchTouchEvent(MotionEvent event) {
        MyApplication.log("," + TAG + "->dispatchTouchEvent(),action:" + event.getAction());
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        MyApplication.log("," + TAG + "->onInterceptTouchEvent(),action:" + ev.getAction());
        return super.onInterceptTouchEvent(ev);
        //return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        MyApplication.log("," + TAG + "->onTouchEvent(),action:" + event.getAction());
        return super.onTouchEvent(event);
    }

}

