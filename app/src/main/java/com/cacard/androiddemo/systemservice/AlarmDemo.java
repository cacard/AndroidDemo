package com.cacard.androiddemo.systemservice;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;

import com.cacard.androiddemo.broadcast.BroadcastReceiverSimple;
import com.cacard.androiddemo.service.StartedServiceDemo;

public class AlarmDemo {

    public static void testAlarm(final Activity ctx) {
        AlarmManager mgr = (AlarmManager) ctx
                .getSystemService(Activity.ALARM_SERVICE);

        // 构造一个PendingIntent，启动Service
        Intent i = new Intent(ctx, StartedServiceDemo.class);
        PendingIntent pi = PendingIntent.getService(ctx, 0, i, 0);


        // 调用广播
//		IntentFilter filter = new IntentFilter();
//		filter.addAction("simple");
//		ctx.registerReceiver(new BroadcastReceiverSimple(), filter);
        Intent intentForBroadcast = new Intent(ctx, BroadcastReceiverSimple.class);
        intentForBroadcast.setAction("simple");
        PendingIntent pi2 = PendingIntent.getBroadcast(ctx, 0, intentForBroadcast, PendingIntent.FLAG_UPDATE_CURRENT);

        // mgr.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
        // SystemClock.elapsedRealtime()+10000,pi );

        // 循环触发闹钟
        mgr.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() + 10000, 5000, pi2);

    }

}
