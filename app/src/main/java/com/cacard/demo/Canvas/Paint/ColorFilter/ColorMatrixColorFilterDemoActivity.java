package com.cacard.demo.Canvas.Paint.ColorFilter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cacard.demo.Canvas.CanvasLayerActivity;
import com.cacard.demo.R;

/**
 * 颜色矩阵（ColorMatrixColorFilter）更改图片的颜色Demo
 * <p/>
 * - 颜色矩阵，即使用矩阵参数去修改Bitmap中每个像素
 * <p/>
 * Created by cunqingli on 2015/5/11.
 */
public class ColorMatrixColorFilterDemoActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);

        MyView v = new MyView(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
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
            Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.list_image);
            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            canvas.drawBitmap(bitmap, 0, 0, paint);

            ColorMatrixColorFilter filter = new ColorMatrixColorFilter(new float[]{
                    3, 0, 0, 0, 0, // 红色增强到3倍
                    0, 1, 0, 0, 0,
                    0, 0, 1, 0, 0,
                    0, 0, 0, 1, 0
            });
            paint.setColorFilter(filter);
            canvas.drawBitmap(bitmap, 0, bitmap.getHeight() + 5, paint);

            ColorMatrixColorFilter filter2 = new ColorMatrixColorFilter(new float[]{
                    1, 0, 0, 0, 0,
                    0, 3, 0, 0, 0, // 绿色增强到3倍
                    0, 0, 1, 0, 0,
                    0, 0, 0, 1, 0
            });
            paint.setColorFilter(filter2);
            canvas.drawBitmap(bitmap, 0, (bitmap.getHeight() + 5) * 2, paint);
        }
    }
}
