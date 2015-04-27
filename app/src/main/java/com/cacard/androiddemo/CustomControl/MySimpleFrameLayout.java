package com.cacard.androiddemo.CustomControl;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.cacard.androiddemo.util.MeasureSpecUtil;

/**
 * Created by cunqingli on 2015/4/10.
 */
public class MySimpleFrameLayout extends FrameLayout {

    private static final String TAG = "MySimpleFrameLayout";

    public MySimpleFrameLayout(Context context) {
        super(context);
    }

    public MySimpleFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MySimpleFrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int wMode = MeasureSpec.getMode(widthMeasureSpec);
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int hMode = MeasureSpec.getMode(heightMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);

        log("[tag:" + this.getTag() + "]widthMode:" + MeasureSpecUtil.getModeString(wMode) + "/width:" + w);

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void measureChildren(int widthMeasureSpec, int heightMeasureSpec) {
        int wMode = MeasureSpec.getMode(widthMeasureSpec);
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int hMode = MeasureSpec.getMode(heightMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);
        super.measureChildren(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void measureChild(View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) {
        int wMode = MeasureSpec.getMode(parentWidthMeasureSpec);
        int w = MeasureSpec.getSize(parentWidthMeasureSpec);
        int hMode = MeasureSpec.getMode(parentHeightMeasureSpec);
        int h = MeasureSpec.getSize(parentHeightMeasureSpec);
        super.measureChild(child, parentWidthMeasureSpec, parentHeightMeasureSpec);
    }

    @Override
    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        int wMode = MeasureSpec.getMode(parentWidthMeasureSpec);
        int w = MeasureSpec.getSize(parentWidthMeasureSpec);
        int hMode = MeasureSpec.getMode(parentHeightMeasureSpec);
        int h = MeasureSpec.getSize(parentHeightMeasureSpec);
        super.measureChildWithMargins(child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    private void log(String msg) {
        Log.i("lcq", TAG + "->" + msg);
    }
}
