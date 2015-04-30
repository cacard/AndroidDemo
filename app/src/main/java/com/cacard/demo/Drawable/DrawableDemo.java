package com.cacard.demo.Drawable;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.cacard.demo.R;

/**
 * Created by cunqingli on 2015/4/28.
 */
public class DrawableDemo extends Activity {

    private static final String TAG = "DrawableDemo";
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout root = new FrameLayout(this);

        iv = new ImageView(this);
        iv.setImageResource(R.drawable.ic_launcher);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        iv.setLayoutParams(lp);

        root.addView(iv);
        this.setContentView(root);

        changeBounds();

    }

    private void changeBounds() {
        iv.getDrawable().setBounds(0, 0, 100, 100);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (hasFocus) {


            // ------------------------------------------
            // IntrinsicWidth / Bounds
            Drawable d = iv.getDrawable();
            Log.i(TAG, "drawable->iwidth:" + d.getIntrinsicWidth() + "/" + d.getIntrinsicHeight());

            Rect r = d.getBounds();
            Log.i(TAG, "rect->width:" + r.width() + ",height:" + r.height());

            Log.i(TAG, "imageView->width:" + iv.getWidth());

        }
    }


}
