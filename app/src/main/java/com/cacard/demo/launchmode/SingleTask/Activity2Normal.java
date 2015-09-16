package com.cacard.demo.launchmode.SingleTask;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by cunqingli on 2015/8/21.
 */
public class Activity2Normal extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        log("onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        log("onDestroy");
    }

    private void log(String msg) {
        Log.i("Activity2Normal", msg);
    }
}
