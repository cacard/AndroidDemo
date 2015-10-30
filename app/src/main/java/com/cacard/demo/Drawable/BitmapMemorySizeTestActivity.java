package com.cacard.demo.Drawable;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cacard.demo.R;

/**
 * Created by cunqingli on 2015/10/29.
 *
 * 一张图片加载屏幕里面所占的内存下列因素有关：
 * - 图片固有的像素尺寸 x * y
 * - 所在目录的dpi
 * - 显示屏幕的dpi
 * - 解码模式（ARGB_8888等）
 *
 * 运行时所占内存是：
 *
 * scale = 屏幕dpi / 所在目录dpi
 * (x * scale) * (y * scale) * 4
 *
 *
 * 更精确的公式是：
 * (x * scale + 0.5) * (y * scale + 0.5) * 4
 *
 */
public class BitmapMemorySizeTestActivity extends Activity {

    private static final String TAG = "BitmapMemorySizeTestActivity";
    ImageView imgView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout ll = new LinearLayout(this);

        imgView = new ImageView(this);
        imgView.setImageResource(R.drawable.logo);

        ll.addView(imgView);

        Button btn = new Button(this);
        btn.setText("TEST");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test();
            }
        });

        ll.addView(btn);

        this.setContentView(ll);

    }


    private void test () {
        Drawable drawable = imgView.getDrawable();
        if (drawable instanceof BitmapDrawable) {
            Bitmap bm = ((BitmapDrawable) drawable).getBitmap();
            if (bm != null) {
                Log.i(TAG,"size="+bm.getByteCount());
            }
        }
    }
}
