package com.cacard.androiddemo.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BroadcastReceiverSimple extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //if (intent != null && intent.getAction() != null
        //&& intent.getAction().equals("simple")) {
        Log.i("test", "BroadcastReceiverSimple->Received a message.");
        //}

    }

}
