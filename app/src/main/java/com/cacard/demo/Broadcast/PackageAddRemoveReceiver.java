package com.cacard.demo.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * 静态注册的广播在进程被杀死后接收到广播，会启动一个新进程，并接收、处理广播。
 */
public class PackageAddRemoveReceiver extends BroadcastReceiver {

    private static final String TAG = PackageAddRemoveReceiver.class.getSimpleName();

    public PackageAddRemoveReceiver() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "get msg");
    }
}
