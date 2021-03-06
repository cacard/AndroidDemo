package com.cacard.demo.Canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * 最简单的使用Canvas绘制的Demo
 * <p/>
 * Created by cunqingli on 2015/4/30.
 */
public class CanvasSimple extends View {
    public CanvasSimple(Context context) {
        super(context);
    }

    public CanvasSimple(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CanvasSimple(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CanvasSimple(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        // 绘制背景色
        canvas.drawRGB(200, 200, 200);

        // 直线
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#ff0000"));
        paint.setStrokeWidth(5);
        canvas.drawLine(0, 0, 100, 100, paint);

        // 矩形
        Paint pRect = new Paint();
        pRect.setColor(Color.BLUE);
        canvas.drawRect(new Rect(0, 0, 200, 400), pRect);

        // 圆
        canvas.drawCircle(200, 100, 100, paint);
    }
}
