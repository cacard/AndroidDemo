package com.cacard.demo.Canvas.Paint.MaskFilter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.cacard.demo.Canvas.CanvasLayerActivity;
import com.cacard.demo.R;

/**
 * MaskFilter演示
 * <p/>
 * - BlurMaskFilter
 * <p/>
 * Created by cunqingli on 2015/5/11.
 */
public class MaskFilterDemoActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(Color.BLACK);

        MyView v = new MyView(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(lp);

        root.addView(v);
        this.setContentView(root);
    }

    public static class MyView extends View {

        private Context mContext;

        public MyView(Context context) {
            super(context);
            this.mContext = context;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.android_yellow);

            // image
            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint.setColor(0xFFffffff);
            paint.setMaskFilter(new BlurMaskFilter(60.0f, BlurMaskFilter.Blur.OUTER));
            canvas.drawBitmap(bitmap, 100, 100, paint);

            // text
            Paint pText = new Paint();
            pText.setColor(Color.YELLOW);
            pText.setTextSize(160);
            pText.setMaskFilter(new BlurMaskFilter(10.0f, BlurMaskFilter.Blur.OUTER));
            canvas.drawText("Hello", 100, 800, pText);
        }
    }
}
