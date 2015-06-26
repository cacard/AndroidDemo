package com.cacard.demo.Service.BindOnCreate;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.cacard.demo.MyApplication;

/**
 * -> 仅仅Bind会调用Service的onCreate吗？
 * <p/>
 * Created by cunqingli on 2015/6/25.
 */
public class BindOnCreateService extends Service {
    private static final String TAG = BindOnCreateService.class.getSimpleName();

    private final Binder mBinder = new InnerBinder();

    public class InnerBinder extends Binder {
        public BindOnCreateService getService() {
            return BindOnCreateService.this;
        }
    }

    @Override
    public void onCreate() {
        log("onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        log("onStartCommand");
        return START_STICKY; //super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        log("onDestroy");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        log("onBind");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        log("onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        log("onRebind");
        super.onRebind(intent);
    }

    private void log(String msg) {
        Log.i(TAG, msg);
    }
}
