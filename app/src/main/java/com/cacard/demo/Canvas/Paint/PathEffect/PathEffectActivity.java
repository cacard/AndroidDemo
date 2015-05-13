package com.cacard.demo.Canvas.Paint.PathEffect;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;

import com.cacard.demo.R;

/**
 * Created by cunqingli on 2015/5/11.
 */
public class PathEffectActivity extends Activity {
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

            Paint pPath = new Paint();
            pPath.setStyle(Paint.Style.STROKE);
            pPath.setStrokeWidth(2);
            pPath.setColor(Color.RED);

            // 普通线
            canvas.drawPath(p, pPath);

            // 圆角线：CornerPathEffect
            canvas.translate(0, 200);
            CornerPathEffect cornerPathEffect = new CornerPathEffect(50);
            pPath.setPathEffect(cornerPathEffect);
            canvas.drawPath(p, pPath);

            // 虚线：DashPathEffect
            canvas.translate(0, 200);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{20, 20}, 0);
            pPath.setPathEffect(dashPathEffect);
            canvas.drawPath(p, pPath);
        }
    }
}
