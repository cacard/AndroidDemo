
package com.cacard.demo.Drawable;

import com.cacard.demo.R;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * Drawing Cache
 * <p/>
 * - 实现对LinearLayout的“截屏”。
 */

public class DrawingCacheCaptureActivity extends Activity {

    private View layout = null;
    private ImageView imageView = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawing_cache_demo);
        layout = this.findViewById(R.id.v);
        imageView = (ImageView) this.findViewById(R.id.imageView);
        layout.setDrawingCacheEnabled(true);
        layout.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
    }

    public void btnClick(View v) {
        Bitmap b = layout.getDrawingCache();

        if (b == null) {
            Log.i("test", "drawing cache is null");
            return;
        }

        imageView.setImageBitmap(b);
        imageView.setAlpha(0.2f);
    }
}
