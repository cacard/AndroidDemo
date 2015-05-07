package com.cacard.demo;

import android.app.Application;
import android.util.Log;

import com.cacard.demo.FloatWindow.FloatWindowManager;

/**
 * Created by cunqingli on 2015/5/7.
 */
public class MyApplication extends Application {

    public FloatWindowManager floatWindowManager= new FloatWindowManager();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.i("lcq", "Applicatoin onTerminate");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
