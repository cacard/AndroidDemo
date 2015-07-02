package com.cacard.demo;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import com.cacard.demo.FloatWindow.FloatWindowManager;
import com.cacard.demo.Service.AfterAppKilledWillReStartService;
import com.cacard.demo.Service.BoundAndStartService;
import com.facebook.drawee.backends.pipeline.Fresco;

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
    }

    private void frescoInit() {
        Fresco.initialize(this);
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
}
