package com.cacard.demo.Canvas.DrawingText;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 带有波浪线标记的TextView
 * <p/>
 * Created by cunqingli on 2015/5/13.
 */
public class WaveTextViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("带有波浪线标记的TextView");

        String txt = "这是测试文本，要断行，并且可设定下划波浪线，" +
                "包含英文字符（This is english string），数字（1,2,3,4,5,6），也可以包含其他更多特殊字符。";
        int lineVerticalPadding = 10;
        int fontSize = 80;
        int txtColor = Color.BLACK;
        int waveColor = Color.RED;

        List<Pair<Integer, Integer>> waveIndexs = new ArrayList<>();
        waveIndexs.add(new Pair<Integer, Integer>(1, 3));
        waveIndexs.add(new Pair<Integer, Integer>(3, 4));
        waveIndexs.add(new Pair<Integer, Integer>(6, 13));
        waveIndexs.add(new Pair<Integer, Integer>(8, 10));
        waveIndexs.add(new Pair<Integer, Integer>(15, 26));
        waveIndexs.add(new Pair<Integer, Integer>(32, 59));

        WaveTextView v = new WaveTextView(this, txt, lineVerticalPadding,
                fontSize, txtColor, waveIndexs, waveColor);

        ((ViewGroup) this.getWindow().getDecorView().findViewById(android.R.id.content))
                .addView(v);
    }


    public static class WaveTextView extends View {

        private Context mContext;
        private String txt = "";
        private int fontSize = 50;
        private int txtColor = Color.BLACK;
        private int lineVerticalPadding = 10;
        private Paint paintText;
        private List<Pair<Integer, Integer>> waveIndexs;

        private int waveColor = Color.RED;
        private Paint paintWave;
        private int paintWaveStrokeWidth = 5;
        float waveStepX = 20;
        float waveStepY = 10;
        private CornerPathEffect cornerPathEffect;

        private int lineCount = 0; // 行数
        private float lineHeight = 0; // 每行高

        private int viewMeasuredWidth;
        private int viewMeasuredHeight;

        private List<CharInfo> charInfos;

        /**
         * @param context
         * @param txt                 文本
         * @param lineVerticalPadding 每行文字在垂直方向的padding
         * @param fontSize            字体大小
         * @param txtColor            字体颜色
         * @param waveIndexs          波浪线开始结束集合
         * @param waveColor           波浪线颜色
         */
        public WaveTextView(Context context, String txt, int lineVerticalPadding, int fontSize,
                            int txtColor, List<Pair<Integer, Integer>> waveIndexs, int waveColor) {
            super(context);

            this.mContext = context;
            this.txt = txt;
            this.fontSize = fontSize;
            this.waveIndexs = waveIndexs;
            this.waveColor = waveColor;
            this.txtColor = txtColor;
            this.lineVerticalPadding = lineVerticalPadding;

            paintText = new Paint(Paint.ANTI_ALIAS_FLAG);
            paintText.setColor(txtColor);
            paintText.setTextSize(fontSize);

            paintWave = new Paint(Paint.ANTI_ALIAS_FLAG);
            paintWave.setColor(waveColor);
            paintWave.setStrokeWidth(paintWaveStrokeWidth);
            paintWave.setStyle(Paint.Style.STROKE);
            cornerPathEffect = new CornerPathEffect(waveStepY < waveStepX ? waveStepY : waveStepX);

            if (txt != null && txt.length() > 0) {
                charInfos = new ArrayList<>(txt.length());
            }
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            final int w = MeasureSpec.getSize(widthMeasureSpec);

            final float totalWidth = paintText.measureText(txt);
            lineCount = (int) Math.ceil(totalWidth / w);
            lineHeight = paintText.getFontMetrics().bottom - paintText.getFontMetrics().top;

            float h = lineCount * (lineVerticalPadding * 2 + lineHeight);

            viewMeasuredWidth = w;
            viewMeasuredHeight = (int) Math.ceil(h);

            setMeasuredDimension(viewMeasuredWidth, viewMeasuredHeight);
        }

        @Override
        protected void onDraw(Canvas canvas) {

            // draw text
            char[] chars = txt.toCharArray();
            float[] widths = new float[chars.length];
            paintText.getTextWidths(txt, 0, txt.length(), widths);

            int len = chars.length;
            float xTemp = 0;
            float yTemp = lineHeight + lineVerticalPadding;
            for (int i = 0; i < len; i++) {
                float xNext = xTemp + widths[i];
                if (xNext >= viewMeasuredWidth) { // enter
                    xTemp = 0;
                    yTemp += (lineHeight + lineVerticalPadding);
                }

                CharInfo ci = new CharInfo();
                ci.position = new PointF(xTemp, yTemp);
                ci.width = widths[i];
                //ci.txt=chars[i];
                charInfos.add(ci);

                canvas.drawText(chars, i, 1, xTemp, yTemp, paintText);
                xTemp += widths[i];
            }

            // draw wave
            for (Pair<Integer, Integer> pair : waveIndexs) {
                if (pair != null) {

                    if (pair.first < 0 || pair.first >= txt.length()
                            || pair.second < 0 || pair.second > txt.length()) {
                        continue;
                    }

                    final PointF pointStart = charInfos.get(pair.first).position;
                    final PointF pointEnd = charInfos.get(pair.second).position;

                    int diff = new Random(System.nanoTime()).nextInt(10); // 随机向下稍许偏移，防止重复线完全重复

                    if (pointEnd.y == pointStart.y) {
                        //canvas.drawLine(pointStart.x, pointStart.y, pointEnd.x, pointEnd.y, paintWave);
                        drawWave(pointStart.x,
                                pointEnd.x + charInfos.get(pair.second).width,
                                pointStart.y + diff, canvas, paintWave);
                    } else {
                        // 直线
                        //canvas.drawLine(pointStart.x, pointStart.y, viewMeasuredWidth, pointStart.y, paintWave);
                        //canvas.drawLine(0, pointEnd.y, pointEnd.x, pointEnd.y, paintWave);
                        // 波浪线
                        drawWave(pointStart.x, viewMeasuredWidth, pointStart.y + diff, canvas, paintWave);
                        drawWave(0, pointEnd.x + charInfos.get(pair.second).width, pointEnd.y + diff, canvas, paintWave);
                    }
                }
            }
        }

        /**
         * 水平直线变成波浪线
         *
         * @param x1
         * @param x2
         * @param y      共用
         * @param canvas
         * @param paint
         */
        private void drawWave(float x1, float x2, float y, Canvas canvas, Paint paint) {

            Path path = new Path();
            path.moveTo(x1, y);

            float xTemp = x1 + waveStepX;
            boolean flag = true;
            while (xTemp < x2) {
                if (flag) {
                    path.lineTo(xTemp, y - waveStepY);
                    flag = false;
                } else {
                    path.lineTo(xTemp, y + waveStepY);
                    flag = true;
                }
                xTemp += waveStepX;
            }

            path.lineTo(x2, y);
            paint.setPathEffect(cornerPathEffect);
            canvas.drawPath(path, paint);
        }

        /**
         * 每个字符的信息
         */
        public static class CharInfo {
            public PointF position;
            public float width;
            public float height;
            public char txt;
        }

    }
}
