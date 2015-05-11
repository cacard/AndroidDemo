package com.cacard.demo.Canvas;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

/**
 * 画布操纵
 * - translate 平移
 * - scale
 * - rotate 旋转
 * - skew
 * Created by cunqingli on 2015/5/11.
 */
public class CanvasOperationActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Canvas Translate,");

        this.setContentView(new MyView(this));
    }

    public static class MyView extends View {

        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {

            canvas.save();

            // ---------- translate ----------
            // 平移过程中绘制几个图形
            Paint pRect = new Paint(Paint.ANTI_ALIAS_FLAG);
            pRect.setColor(Color.RED);
            final Rect rect = new Rect(0, 0, 300, 300);
            final float d = 100;
            for (int i = 0; i < 3; i++) {
                canvas.drawRect(rect, pRect);
                canvas.translate(d, d);
            }

            canvas.restore();
            canvas.translate(400, 0);

            // ---------- skew ----------
            canvas.skew(1, 0);
            pRect.setColor(Color.BLUE);
            canvas.drawRect(rect, pRect);

        }


    }
}
