package com.cacard.demo.Canvas;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

/**
 * Canvas支持图层，相关方法包括：
 * - saveLayer()
 * - saveLayerAlpha()
 * <p/>
 * Created by cunqingli on 2015/5/11.
 */
public class CanvasLayerActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyView v = new MyView(this);
        this.setContentView(v);

        this.setTitle("Canvas Layer");
    }


    // 自定义View
    public static class MyView extends View {

        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {

            Paint pText = new Paint();
            pText.setColor(Color.BLACK);
            pText.setTextSize(60);

            // 默认层
            canvas.drawColor(Color.BLUE);
            canvas.drawText("layout default", 0, 80, pText);

            // 新建透明层
            canvas.saveLayerAlpha(new RectF(0, 0, 500, 500), 0x99, Canvas.ALL_SAVE_FLAG);
            final Paint p = new Paint();
            p.setColor(Color.RED);
            canvas.drawRect(new RectF(0, 0, 200, 200), p);
        }
    }
}
