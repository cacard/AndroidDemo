package com.cacard.demo.Canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * 圆形进度条
 * 可指定开始角度，颜色，宽度
 * <p/>
 * Created by cunqingli on 2015/5/7.
 */
public class CycleProgressView extends View {

    private int mAngleStart = 0; // 0:left,90:top,180:right,360:bottom
    private int mColorBottom = Color.GRAY;
    private int mColorArc = Color.RED;
    private int mColorTop = Color.BLACK;
    private float mWeightPercent = 0.2f; // 宽度占半径的百分比
    private float mProgressPercent = 0.1f; // 进度百分比

    public CycleProgressView(Context context) {
        super(context);
    }

    public CycleProgressView(Context context, int angleStart, int colorBottom, int colorArc, int colorTop, float weightPercent) {
        super(context);
        this.mAngleStart = angleStart;
        this.mColorBottom = colorBottom;
        this.mColorArc = colorArc;
        this.mColorTop = colorTop;
        this.mWeightPercent = weightPercent;
    }

    public CycleProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CycleProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CycleProgressView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        final int w = getWidth();
        final int h = getHeight();
        final float r = getR(w, h);

        final float xCenter = (float) w / 2.0f;
        final float yCenter = (float) h / 2.0f;

        // 底层圆形
        final Paint pBottom = new Paint(Paint.ANTI_ALIAS_FLAG);
        pBottom.setColor(mColorBottom);
        canvas.drawCircle(xCenter, yCenter, r, pBottom);

        // 进度圆形
        final Paint pArc = new Paint(Paint.ANTI_ALIAS_FLAG);
        pArc.setColor(mColorArc);
        RectF rectF = new RectF();
        if (w == h) {
            rectF.left = 0;
            rectF.top = 0;
            rectF.right = w;
            rectF.bottom = h;
        } else {
            rectF.left = xCenter - r;
            rectF.top = yCenter - r;
            rectF.right = xCenter + r;
            rectF.bottom = yCenter + r;
        }
        canvas.drawArc(rectF, mAngleStart + 180, 360 * mProgressPercent, true, pArc);

        // 上层圆形
        final Paint pTop = new Paint(Paint.ANTI_ALIAS_FLAG);
        pTop.setColor(mColorTop);
        canvas.drawCircle(xCenter, yCenter, r * (1 - mWeightPercent), pTop);

    }

    /**
     * 半径
     *
     * @param w
     * @param h
     * @return
     */
    private float getR(int w, int h) {
        if (w >= h) {
            return (float) h / 2.0f;
        } else {
            return (float) w / 2.0f;
        }
    }

    /**
     * 更新进度
     *
     * @param percent
     */
    public void updateProgress(float percent) {
        this.mProgressPercent = percent;
        invalidate();
    }
}
