package com.cacard.demo.Canvas;

import android.app.Activity;
import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by cunqingli on 2015/5/12.
 */
public class FlashDotDemoActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);

        MyView v = new MyView(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(600, 600);
        v.setLayoutParams(lp);
        v.setBackgroundColor(Color.parseColor("#dddddd"));
        v.setLayerType(View.LAYER_TYPE_SOFTWARE, null); // 关闭硬件加速，让Blur效果生效

        ll.addView(v);
        this.setContentView(ll);
    }

    public static class MyView extends View {

        private float r = 50.0f; // 圆点半径
        private float rBlurMax = 250; // 最大虚化半径
        private float rBlurMin = 0.1f; // 最小虚化半径
        private float rBlur = rBlurMin; // 临时量

        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            //canvas.drawColor(Color.GRAY);
            final int w = getMeasuredWidth();
            final int h = getMeasuredHeight();
            final float wCenter = (float) w / 2.0f;
            final float hCenter = (float) h / 2.0f;

            Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
            p.setColor(Color.BLACK);

            if (rBlur <= rBlurMax) {
                p.setMaskFilter(new BlurMaskFilter(rBlur, BlurMaskFilter.Blur.OUTER));
                rBlur += 0.5f;
            } else {
                rBlur = rBlurMin;
            }

            canvas.drawCircle(wCenter, hCenter, r, p);

            invalidate();
        }
    }
}
