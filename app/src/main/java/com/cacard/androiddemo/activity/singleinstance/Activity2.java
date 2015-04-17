package com.cacard.androiddemo.activity.singleinstance;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by cunqingli on 2015/4/13.
 */
public class Activity2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Activity2");
    }

    private void log(String msg) {
        Log.i("lcq", msg);
    }
}
