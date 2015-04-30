package com.cacard.demo.Util;

import android.util.Log;

public class LogHelper {

    private static final String TAG = "test";

    public static void write(String msg) {
        Log.i(TAG, msg);
    }
}
