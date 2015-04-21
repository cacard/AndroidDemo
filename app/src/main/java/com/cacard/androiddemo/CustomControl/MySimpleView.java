/**
 * 自定义View
 * 
 * 
 */

package com.cacard.androiddemo.CustomControl;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MySimpleView extends View {

	public MySimpleView(Context context) {
		super(context);

	}

	public MySimpleView(Context context, AttributeSet attr/* XML布局包含熟悉时，调用该ctor */) {
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

		boolean b = super.dispatchTouchEvent(event);
		Log.i("test", "MySimpleView.dispatch(),return" + b);
		return b;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		boolean b = super.onTouchEvent(event);
		Log.i("test", "MySimpleView.onTouchEvent(),return" + b);
		return b;
	}
}
