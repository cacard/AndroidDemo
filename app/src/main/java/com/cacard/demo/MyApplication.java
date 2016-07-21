package com.cacard.demo;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.cacard.demo.FloatWindow.FloatWindowManager;
import com.cacard.demo.Service.AfterAppKilledWillReStartService;
import com.cacard.demo.Service.BoundAndStartService;

import java.util.Random;
//import com.facebook.drawee.backends.pipeline.Fresco;

/**
 *
 *
 * Created by cunqingli on 2015/5/7.
 */
public class MyApplication extends com.reginald.tasklogger.TaskLoggerApplication {
    private static final String TAG = MyApplication.class.getSimpleName();
    public static boolean isAudioPlayerServiceRunning;
    public FloatWindowManager floatWindowManager = new FloatWindowManager();
    public static MyApplication instance;

    @Override
    public void onCreate() {
        Log.i(TAG, "->onCreate()");
        super.onCreate();
        instance = this;
        frescoInit();
        testAfterAppKilledWillReStartService();

        //allActivityCallback();
    }

    private void frescoInit() {
        //Fresco.initialize(this);
    }

    private void allActivityCallback() {
        final String tag = "activitylife";
        this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                Log.i(tag,"onActivityCreated->"+activity.toString());
            }

            @Override
            public void onActivityStarted(Activity activity) {
                Log.i(tag,"onActivityStarted->"+activity.toString());
            }

            @Override
            public void onActivityResumed(Activity activity) {
                Log.i(tag,"onActivityResumed->"+activity.toString());
            }

            @Override
            public void onActivityPaused(Activity activity) {
                Log.i(tag,"onActivityPaused->"+activity.toString());
            }

            @Override
            public void onActivityStopped(Activity activity) {
                Log.i(tag,"onActivityStopped->"+activity.toString());
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                Log.i(tag,"onActivityDestroyed->"+activity.toString());
            }
        });
    }

    /**
     * App被杀死后，该Service会自动重启
     */
    private void testAfterAppKilledWillReStartService() {
        ServiceConnection connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.i("service", "onServiceConnected");
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.i("service", "onServiceDisconnected");
            }
        };

        this.bindService(new Intent(this, AfterAppKilledWillReStartService.class), connection, 0);
    }

    /**
     * 测试BIND_AUTO_CREATE
     */
    private void testBindAutoCrate() {

        ServiceConnection connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.i("service", "onServiceConnected");
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.i("service", "onServiceDisconnected");
            }
        };

        this.bindService(new Intent(this, BoundAndStartService.class), connection, BIND_AUTO_CREATE);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.i(TAG, "Applicatoin onTerminate");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }


    public static synchronized String getImei() {


        String imei = "";


            if (Build.VERSION.SDK_INT < 23 ) {
                TelephonyManager tm = (TelephonyManager) MyApplication.instance
                        .getSystemService(Context.TELEPHONY_SERVICE);
                try {
                    imei = tm.getDeviceId();
                } catch (SecurityException e) {
                    throw e;
                }

            }

            // 6.0以上系统(SDK_INT>=23)且targetSdkVersion>=23时,
            // 直接使用Android_ID作为IMEI, 不获取 拨打电话 权限了

        return imei;
    }
}
