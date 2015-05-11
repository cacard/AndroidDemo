package com.cacard.demo.Canvas;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;

import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 音乐波浪控件Demo
 * - 采用Canvase动态绘制而成
 * <p/>
 * Created by cunqingli on 2015/5/11.
 */
public class MusicWaveAnimationActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("音乐波浪控件");

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);

        MusicWaveView v = new MusicWaveView(this, Color.WHITE, Color.GRAY, 4, 0.01f);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(300, 300);
        v.setLayoutParams(lp);

        MusicWaveView v2 = new MusicWaveView(this, Color.WHITE, Color.GRAY, 4, 0.03f);
        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(600, 600);
        v2.setLayoutParams(lp2);

        MusicWaveView v3 = new MusicWaveView(this, Color.WHITE, Color.GRAY, 7, 0.05f);
        LinearLayout.LayoutParams lp3 = new LinearLayout.LayoutParams(300, 300);
        v3.setLayoutParams(lp3);

        MusicWaveView v4 = new MusicWaveView(this, Color.WHITE, Color.GRAY, 10, 0.05f);
        LinearLayout.LayoutParams lp4 = new LinearLayout.LayoutParams(900, 300);
        v4.setLayoutParams(lp4);

        root.addView(v);
        root.addView(v2);
        root.addView(v3);
        root.addView(v4);
        this.setContentView(root);
    }

    /**
     * 音乐波浪控件
     */
    public static class MusicWaveView extends View {

        private int count = 4; // 波柱数量
        private float setpPercent = 0.05f; // 每次绘制更新的高度该变量，影响波柱的变化速度
        private int heightStep;// 高度每次改变数量
        private int color = Color.WHITE; // 波柱颜色
        private int colorBg = Color.GRAY; // 背景色
        private Paint paint;
        private RectStat[] rectStats;


        public MusicWaveView(Context context, int color, int colorBg, int count, float setpPercent) {
            super(context);
            this.count = count;
            this.color = color;
            this.colorBg = colorBg;
            this.setpPercent = setpPercent;

            init();
        }

        private void init() {
            paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint.setColor(color);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            final int widthView = getMeasuredWidth();
            final int heightView = getMeasuredHeight();
            final float w = (float) widthView / (float) (count * 2 - 1);

            if (rectStats == null) { // 初始化一次各个Rect的状态
                heightStep = (int) (heightView * setpPercent);
                initRectStats(w, heightView);
            }

            canvas.drawColor(colorBg);

            int c = count * 2 - 1;
            for (int i = 0; i < c; i++) {
                if (i % 2 != 0) {
                    canvas.translate(w, 0);
                    continue;
                } else {
                    final int rectIndex = i / 2;
                    canvas.drawRect(rectStats[rectIndex].rect, paint);
                    canvas.translate(w, 0);
                }
            }

            // 这里采用了每次绘制后立刻更新状态
            updateRectStats();
            invalidate();
        }

        /**
         * 初始化波柱Rect的初始状态
         *
         * @param w 波柱宽度
         * @param h 波柱最高时的高度
         */
        private void initRectStats(float w, float h) {

            this.rectStats = new RectStat[count];

            final float hHalf = h / 2;

            for (int i = 0; i < count; i++) {
                final int randomHeight = new Random(System.nanoTime()).nextInt((int) h);

                // 方向策略
                int direction = RectStat.DWON;
                if (randomHeight < hHalf) {
                    direction = RectStat.UP;
                }

                rectStats[i] = new RectStat(new RectF(0, randomHeight, w, h), direction, heightStep, getMeasuredHeight());
            }
        }

        /**
         * 每次重绘之前要更新一次波柱Rect
         */
        private void updateRectStats() {
            if (rectStats == null) {
                return;
            }

            for (int i = 0; i < count; i++) {
                rectStats[i].update();
            }
        }

        /**
         * 波柱初始状态
         */
        private static class RectStat {
            public static final int DWON = 0; // 变化方向为向下
            public static final int UP = 1;// 变化方向为向上
            private int direction; // 变化方向
            private RectF rect; // 波柱对应的矩形
            private int step; // 每次变化的该变量
            private float maxHeight; // 最大高度

            public RectStat(RectF initRect, int initDirection, int step, float maxHeight) {
                this.rect = new RectF(initRect);
                this.direction = initDirection;
                this.step = step;
                this.maxHeight = maxHeight;
            }

            public void update() {
                if (direction == UP) {
                    rect.top -= step;
                    if (rect.top <= 0) {
                        direction = DWON;
                        rect.top += step;
                    }
                } else {
                    rect.top += step;
                    if (rect.top >= maxHeight) {
                        direction = UP;
                        rect.top -= step;
                    }
                }
            }

        }

    }

}
