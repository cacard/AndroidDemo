package com.cacard.demo.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.cacard.demo.MyApplication;

/**
 * 屏幕尺寸信息
 */
public class ActivityScreenSize extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("ScreenInformation");

        TextView tv = new TextView(this);
        tv.setMovementMethod(ScrollingMovementMethod.getInstance());
        tv.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        setContentView(tv);

        StringBuilder sb = new StringBuilder();

        //使用Application WindowService
        WindowManager windowsManager = (WindowManager) MyApplication.instance.
                getSystemService(Context.WINDOW_SERVICE);
        sb.append("Application getWindowService getDefaultDisplay getWidth:\n");
        sb.append("widthPixels" + windowsManager.getDefaultDisplay().getWidth() + "\n");
        sb.append("heightPixels" + windowsManager.getDefaultDisplay().getHeight() + "\n");

        sb.append("Application getWindowService getDefaultDisplay getMetrics getWidth:\n");
        DisplayMetrics dm = new DisplayMetrics();
        windowsManager.getDefaultDisplay().getMetrics(dm);
        sb.append("widthPixels" + dm.widthPixels + "\n");
        sb.append("heightPixels" + dm.heightPixels + "\n");

        //还有一个叫做getRealMetrics
        dm = new DisplayMetrics();
        windowsManager.getDefaultDisplay().getRealMetrics(dm);
        sb.append("widthPixels" + dm.widthPixels + "\n");
        sb.append("heightPixels" + dm.heightPixels + "\n");


        //使用Activity getWindowManager
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        sb.append("\n\nActivity getWindowManager getDefaultDisplay getMetrics:\n");
        sb.append("densityDpi:" + metrics.densityDpi + "\n");
        sb.append("density:" + metrics.density + "\n");


        sb.append("widthPixels" + metrics.widthPixels + "\n");
        sb.append("heightPixels" + metrics.heightPixels + "\n");

        //使用Resources.getSystem().getDisplayMetrics();
        sb.append("\n\nResources.getSystem().getDisplayMetrics():\n");
        dm = Resources.getSystem().getDisplayMetrics();
        sb.append("widthPixels" + dm.widthPixels + "\n");
        sb.append("heightPixels" + dm.heightPixels + "\n");


        tv.setText(sb.toString());
    }

}
