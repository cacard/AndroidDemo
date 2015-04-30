package com.cacard.demo.Util;

import android.content.Context;
import android.view.WindowManager;

public class ScreenUtil {

    public static int getScreenWidth(Context ctx) {
        return ((WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getWidth();
    }

    public static int getScreenHeight(Context ctx) {
        return ((WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getHeight();
    }

}
