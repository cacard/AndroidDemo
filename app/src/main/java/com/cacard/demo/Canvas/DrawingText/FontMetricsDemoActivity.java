package com.cacard.demo.Canvas.DrawingText;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.cacard.demo.Canvas.FlashDotDemoActivity;
import com.cacard.demo.Util.FontUtil;

/**
 * FontMetrics 演示
 * <p/>
 * 什么是FontMetrics？中英文有什么区别？
 * 绘制出这些信息，直观展示出来。
 * <p/>
 * Created by cunqingli on 2015/5/13.
 */
public class FontMetricsDemoActivity extends Activity {

    private static final String TITLE = "Canvas/FontMetrics演示";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle(TITLE);
        MyView v = new MyView(this);
        ((FrameLayout) this.getWindow().getDecorView().findViewById(android.R.id.content)).addView(v);
    }

    public class MyView extends View {

        private static final String TAG = "CanvasDrawingText_FontMetrics";
        private static final String text1 = "My English Text line 123";
        private static final String text2 = "这是中文字符串";
        private static final String text3 = "这是中英文englishText 123";

        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Paint pFont = new Paint(Paint.ANTI_ALIAS_FLAG);
            pFont.setTextSize(150);
            pFont.setColor(Color.BLACK);

            Paint pLine = new Paint(Paint.ANTI_ALIAS_FLAG);
            pLine.setColor(Color.RED);

            int baseLineY = 300;
            drawFontMetrics(text1, 0, baseLineY, pFont, pLine, canvas);

            baseLineY += 300;
            drawFontMetrics(text2, 0, baseLineY, pFont, pLine, canvas);

            baseLineY += 300;
            drawFontMetrics(text3, 0, baseLineY, pFont, pLine, canvas);

        }

        /**
         * 绘制出FontMetrics信息
         *
         * @param text      文字字符串
         * @param baseLineX 基线开始位置的x坐标
         * @param baseLineY 基线开始位置的y坐标
         * @param pFont     字体Paint
         * @param pLine     信息线Paint
         * @param canvas
         */
        private void drawFontMetrics(String text, int baseLineX, int baseLineY, Paint pFont, Paint pLine, Canvas canvas) {
            final int setp = 20;

            canvas.drawText(text, baseLineX, baseLineY, pFont);
            Paint.FontMetrics m = pFont.getFontMetrics();

            // 文字的左右边界
            final float startX = baseLineX;
            float stopX = startX + FontUtil.getStringWidth(text, pFont);

            // draw top
            float topY = baseLineY + m.top;
            canvas.drawLine(startX, (int) topY, stopX, (int) topY, pLine);

            // draw ascent
            topY = baseLineY + m.ascent;
            stopX += setp;
            canvas.drawLine(startX, (int) topY, stopX, (int) topY, pLine);

            // draw base
            Paint pBase = new Paint();
            pBase.setColor(Color.BLUE);
            topY = baseLineY;
            stopX += setp;
            canvas.drawLine(startX, (int) topY, stopX, (int) topY, pBase);

            // draw descent
            topY = baseLineY + m.descent;
            stopX += setp;
            canvas.drawLine(startX, (int) topY, stopX, (int) topY, pLine);

            // draw bottom
            topY = baseLineY + m.bottom;
            stopX += setp;
            canvas.drawLine(startX, (int) topY, stopX, (int) topY, pLine);
        }
    }
}
