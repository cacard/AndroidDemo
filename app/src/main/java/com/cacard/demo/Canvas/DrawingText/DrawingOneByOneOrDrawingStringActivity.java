package com.cacard.demo.Canvas.DrawingText;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

/**
 * 逐字符绘制和绘制字符串比较，在字符间距和总宽度上有区别吗？
 * <p/>
 * 结论：完全相同
 * <p/>
 * Created by cunqingli on 2015/5/13.
 */
public class DrawingOneByOneOrDrawingStringActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("逐字符绘制和绘制字符串比较");
        FrameLayout root = new FrameLayout(this);

        MyView v = new MyView(this);

        root.addView(v);
        this.setContentView(root);
    }

    public static class MyView extends View {

        private String txt = "这是中文字符。";

        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {

            final int fontSize = 200;

            Paint p = new Paint();
            p.setTextSize(fontSize);
            p.setColor(Color.BLACK);

            // 一次性绘制字符串
            canvas.drawText(txt, 0, fontSize, p);

            // 一个一个绘制字符
            canvas.translate(0, fontSize);

            Paint pLine = new Paint();
            pLine.setColor(Color.RED);

            char[] chars = txt.toCharArray();
            float[] widths = new float[chars.length];
            p.getTextWidths(txt, 0, txt.length(), widths);
            float xTemp = 0;
            for (int i = 0; i < chars.length; i++) {
                // 垂直分割线示意图
                canvas.drawLine(xTemp, 0, xTemp, fontSize, pLine);
                canvas.drawText(chars, i, 1, xTemp, fontSize, p);
                xTemp += widths[i];
            }

        }
    }
}
