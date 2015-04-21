/**
 * 自定义ViewGroup
 *
 */

package com.cacard.androiddemo.CustomControl;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;

public class MySimpleViewGroup extends ViewGroup {

    public MySimpleViewGroup(Context context) {
        super(context);
    }

    public MySimpleViewGroup(Context context, AttributeSet attr) {
        super(context, attr);

    }


    // ************************
    // measure/layout/draw相关
    // ************************

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    // ViewGroup的onLayout是abstract的
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        //super.onLayout(changed, left, top, right, bottom);
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
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

}
