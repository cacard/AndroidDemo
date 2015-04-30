/**
 * 自定义ViewGroup
 */

package com.cacard.demo.CustomControl;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class MySimpleViewGroup extends ViewGroup {

    public MySimpleViewGroup(Context context) {
        super(context);
    }

    public MySimpleViewGroup(Context context, AttributeSet attr) {
        super(context, attr);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

}
