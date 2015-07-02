package com.cacard.demo.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * 最简单的广播示例
 */
public class BroadcastReceiverSimple extends BroadcastReceiver {

    private static final String TAG = BroadcastReceiverSimple.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "BroadcastReceiverSimple->Received a message.");
    }
}
