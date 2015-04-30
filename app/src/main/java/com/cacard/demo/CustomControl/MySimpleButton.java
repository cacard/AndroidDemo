/**
 * 自定义Button
 *
 * 用来跟踪事件相关函数
 */

package com.cacard.demo.CustomControl;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

public class MySimpleButton extends Button {

    public MySimpleButton(Context context) {
        super(context);

    }

    public MySimpleButton(Context context, AttributeSet attr) {
        super(context, attr);

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
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i("test", "MySimpleButton.dispatchTouchEvent(),action=" + event.getActionMasked());
        return super.dispatchTouchEvent(event);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("test", "MySimpleButton.onTouchEvent(),action=" + event.getActionMasked());
        return super.onTouchEvent(event);
    }

}
