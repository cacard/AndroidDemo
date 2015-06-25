package com.cacard.demo.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by cunqingli on 2015/6/23.
 */
public class BoundAndStartService extends Service {
    private static final String TAG = BoundAndStartService.class.getSimpleName();
    private final Binder mBinder = new InnerBinder();

    public class InnerBinder extends Binder {
        public BoundAndStartService getService() {
            return BoundAndStartService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        log("onBind()");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        log("onUnbind()");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        log("onStartCommand");
        return START_STICKY;

        /*




         */
    }

    @Override
    public void onCreate() {
        super.onCreate();
        log("onCreate()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        log("onDestroy()");
    }

    private void log(String msg) {
        Log.i(TAG, msg);
    }
}
