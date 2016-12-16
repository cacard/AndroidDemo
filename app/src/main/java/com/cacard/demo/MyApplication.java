package com.cacard.demo;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.cacard.demo.Activity.NoRegisterActivity;
import com.cacard.demo.FloatWindow.FloatWindowManager;
import com.cacard.demo.Service.AfterAppKilledWillReStartService;
import com.cacard.demo.Service.BoundAndStartService;
//import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by cunqingli on 2015/5/7.
 */
public class MyApplication extends Application {
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

        testBug();

        //allActivityCallback();

        // 注册一个关闭钩子
        // OK!
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.i("shutdown", "Hello, tName" + Thread.currentThread().getName());
            }
        }));

        // 未在Manifest中注册的Activity也可以开启使用?
        NoRegisterActivity.enable(this);
    }

    private void testBug() {
        Thread.currentThread().setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
    }

    private void crash() {
        int i = 0;
        int m = 1;
        int x = m / i;
    }

    private void frescoInit() {
        //Fresco.initialize(this);
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


        if (Build.VERSION.SDK_INT < 23) {
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
