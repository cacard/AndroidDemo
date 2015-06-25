package com.cacard.demo.Service.Sticky;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by cunqingli on 2015/6/25.
 */
public class StartNotStickyService extends Service {

    private static final String TAG = StartNotStickyService.class.getSimpleName();

    @Override
    public void onCreate() {
        log("onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        log("onStartCommand");
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        log("onDestroy");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void log(String msg) {
        Log.i(TAG, msg);
    }
}
