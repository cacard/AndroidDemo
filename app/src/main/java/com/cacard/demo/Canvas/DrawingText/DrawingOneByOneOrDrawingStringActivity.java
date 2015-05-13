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

    private static final String TITLE = "逐字符绘制和绘制字符串比较";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle(TITLE);

        FrameLayout root = new FrameLayout(this);
        MyView v = new MyView(this);
        root.addView(v);
        this.setContentView(root);
    }

    public static class MyView extends View {
        private static final String txt = "这是中文字符。";
        private static final int fontSize = 200;

        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Paint paintText = new Paint();
            paintText.setTextSize(fontSize);
            paintText.setColor(Color.BLACK);

            Paint paintLine = new Paint();
            paintLine.setColor(Color.RED);

            // 一次性绘制字符串
            canvas.drawText(txt, 0, fontSize, paintText);

            // 一个一个绘制字符
            canvas.translate(0, fontSize);
            char[] chars = txt.toCharArray();
            float[] widths = new float[chars.length];
            paintText.getTextWidths(txt, 0, txt.length(), widths);

            int len = chars.length;
            float xTemp = 0;
            for (int i = 0; i < len; i++) {
                canvas.drawLine(xTemp, 0, xTemp, fontSize, paintLine);// 垂直分割线
                canvas.drawText(chars, i, 1, xTemp, fontSize, paintText);
                xTemp += widths[i];
            }
        }
    }
}
