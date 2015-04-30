package com.cacard.demo.Canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by cunqingli on 2015/4/30.
 */
public class CanvasDrawingText extends View {

    private String TAG = "CanvasDrawingText";

    public CanvasDrawingText(Context context) {
        super(context);
    }

    public CanvasDrawingText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CanvasDrawingText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CanvasDrawingText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        justDrawText(canvas);
    }

    private void justDrawText(Canvas canvas) {
        String str = "ABC汉字___，。、___,./如何换行？如何测量字符尺寸？如何换行？如何测量字符尺寸？如何换行？如何测量字符尺寸？如何换行？如何测量字符尺寸？如何换行？如何测量字符尺寸？";
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(Color.parseColor("#ff0000"));
        p.setTextSize(64);

        // 字体高度
        Paint.FontMetrics fm = p.getFontMetrics();
        float fontHeight = fm.bottom - fm.top;

        // 第一行基线
        int baseLineY = (int) fontHeight;

        // 所有字符的宽度
        float[] widths = new float[str.length()];
        p.getTextWidths(str, widths);
        float allWidth = 0;
        String msgWidth = "";
        for (float f : widths) {
            allWidth += f;
            msgWidth += "|" + f;
        }
        Log.i(TAG, "allWidth:" + allWidth + ",width:" + msgWidth);

        canvas.drawText(str, 0/*字体baseLine的x*/, fontHeight/*字体baseLine的y*/, p);
    }


}
