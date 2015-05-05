package com.cacard.demo.Activity;

import com.cacard.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActivityScreenSize extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("ScreenInformation");

        TextView tv = new TextView(this);
        tv.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        setContentView(tv);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        StringBuilder sb = new StringBuilder();
        sb.append("densityDpi:" + metrics.densityDpi + "\n");
        sb.append("density:" + metrics.density + "\n");
        sb.append("widthPixels" + metrics.widthPixels + "\n");
        sb.append("heightPixels" + metrics.heightPixels + "\n");

        tv.setText(sb.toString());
    }

}
