/**
 * 屏幕尺寸相关
 *
 */

package com.cacard.androiddemo.activity;

import com.cacard.androiddemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class ActivityScreenSize extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_screen_size);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        log("densityDpi" + metrics.densityDpi);
        log("density" + metrics.density);
        log("widthPixels" + metrics.widthPixels);
        log("heightPixels" + metrics.heightPixels);


        final LinearLayout ll = (LinearLayout) this.findViewById(R.id.root);
        ll.post(new Runnable() {
            @Override
            public void run() {
                log("" + ll.getRight() + "," + ll.getBottom());

            }
        });

    }

    private void log(String str) {
        Log.i("test", str);
    }

}
