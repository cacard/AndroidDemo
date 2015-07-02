package com.cacard.demo.Canvas;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

/**
 * 测试Path
 * Created by cunqingli on 2015/5/11.
 */
public class PathActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        MyView v = new MyView(this);
        ll.addView(v);
        this.setContentView(ll);
    }

    public static class MyView extends View {

        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Path p = new Path();
            p.moveTo(0, 0);
            p.lineTo(100, 100);
            p.lineTo(200, 100);

            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(2);
            paint.setColor(Color.RED);

            // 普通线
            canvas.drawPath(p, paint);
        }
    }

}
