package com.cacard.androiddemo;

import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by cunqingli on 2015/1/9.
 */
public class MyInstrumentation extends Instrumentation {

    private static final String TAG = "MyInstrumentation";

    private void log(String msg) {
        Log.i(TAG, msg);
    }

    @Override
    public Application newApplication(ClassLoader cl, String className, Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        log("newApplication");
        return super.newApplication(cl, className, context);
    }

    @Override
    public void callApplicationOnCreate(Application app) {
        super.callApplicationOnCreate(app);
    }

    @Override
    public Activity newActivity(Class<?> clazz, Context context, IBinder token, Application application, Intent intent, ActivityInfo info, CharSequence title, Activity parent, String id, Object lastNonConfigurationInstance) throws InstantiationException, IllegalAccessException {
        return super.newActivity(clazz, context, token, application, intent, info, title, parent, id, lastNonConfigurationInstance);
    }

    @Override
    public Activity newActivity(ClassLoader cl, String className, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return super.newActivity(cl, className, intent);
    }

    @Override
    public void callActivityOnCreate(Activity activity, Bundle icicle) {
        log("callActivityOnCreate");
        super.callActivityOnCreate(activity, icicle);
    }

    @Override
    public void callActivityOnDestroy(Activity activity) {
        super.callActivityOnDestroy(activity);
    }

    @Override
    public void callActivityOnRestoreInstanceState(Activity activity, Bundle savedInstanceState) {
        super.callActivityOnRestoreInstanceState(activity, savedInstanceState);
    }

    @Override
    public void callActivityOnPostCreate(Activity activity, Bundle icicle) {
        super.callActivityOnPostCreate(activity, icicle);
    }

    @Override
    public void callActivityOnNewIntent(Activity activity, Intent intent) {
        super.callActivityOnNewIntent(activity, intent);
    }

    @Override
    public void callActivityOnStart(Activity activity) {
        super.callActivityOnStart(activity);
    }

    @Override
    public void callActivityOnRestart(Activity activity) {
        super.callActivityOnRestart(activity);
    }

    @Override
    public void callActivityOnResume(Activity activity) {
        super.callActivityOnResume(activity);
    }

    @Override
    public void callActivityOnStop(Activity activity) {
        super.callActivityOnStop(activity);
    }

    @Override
    public void callActivityOnSaveInstanceState(Activity activity, Bundle outState) {
        super.callActivityOnSaveInstanceState(activity, outState);
    }

    @Override
    public void callActivityOnPause(Activity activity) {
        super.callActivityOnPause(activity);
    }

    @Override
    public void callActivityOnUserLeaving(Activity activity) {
        super.callActivityOnUserLeaving(activity);
    }
}
