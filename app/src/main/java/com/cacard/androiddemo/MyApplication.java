package com.cacard.androiddemo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.cacard.androiddemo.activity.ActivityInstrumentationTest;

/**
 * 自定义的Application
 */
public class MyApplication extends Application {

    public static final String TAG = "test";

    /**
     * 全局日志，TAG为“test”
     *
     * @param msg
     */
    public static void log(String msg) {
        Log.i(TAG, msg);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        log("application onCreate()");

        final MyInstrumentation myInstrumentation = new MyInstrumentation();
        myInstrumentation.start();
        myInstrumentation.addMonitor(new Instrumentation.ActivityMonitor(ActivityInstrumentationTest.class.toString(), null, false));

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            registerDebug();
        }

    }

    /**
     * 跟踪所有Activity的生命周期
     */
    @TargetApi(14)
    private void registerDebug() {
        // android 4.0 +
        // 可全局性的跟踪所有Activity的lifecycle
        this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {

            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                log(activity.toString() + " onActivityCreated");
            }

            @Override
            public void onActivityStarted(Activity activity) {
                log(activity.toString() + " onActivityStarted");
            }

            @Override
            public void onActivityResumed(Activity activity) {
                log(activity.toString() + " onActivityResumed");
            }

            @Override
            public void onActivityPaused(Activity activity) {
                log(activity.toString() + " onActivityPaused");
            }

            @Override
            public void onActivityStopped(Activity activity) {
                log(activity.toString() + " onActivityStopped");
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                log(activity.toString() + " onActivitySaveInstanceState");
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                log(activity.toString() + " onActivityDestroyed");
            }
        });
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        log("application onTerminate()");
    }

}
