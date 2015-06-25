package com.cacard.demo.Service.Sticky;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Lifecycle:
 * #1,1st time:startService -> [onCreate] -> [onStartCommand]
 * #2,service alreay started:startService -> [onStartCommand]
 * #3,stopService -> [onDestroy]
 * #4,kill app
 * -  1, START_STICKY [default]，-> [onCreate] -> [onStartCommand] intent is null
 * -  2, START_NOT_STICKY -> no create
 * <p/>
 * Created by cunqingli on 2015/6/25.
 */
public class MyStartedService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
