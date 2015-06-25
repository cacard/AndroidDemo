package com.cacard.demo.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * App被杀死后自动重启的Service
 * <p/>
 * Created by cunqingli on 2015/6/25.
 */
public class AfterAppKilledWillReStartService extends Service {

    private static final String TAG = AfterAppKilledWillReStartService.class.getSimpleName();

    private final IBinder mBinder = new XXXBinder();

    public class XXXBinder extends Binder {
        public AfterAppKilledWillReStartService getSerivice() {
            return AfterAppKilledWillReStartService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        log("->onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        log("->onStartCommand");
        return START_STICKY;

    }

    @Override
    public void onDestroy() {
        log("->onDestroy");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        log("->onBind");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        log("->onUnbind");
        return super.onUnbind(intent);
    }

    private void log(String msg) {
        Log.i(TAG, msg);
    }
}
