/**
 * 重点
 * 1 TODO 点击notification后，跳转到对应的Activity，并且不重复启动该App。
 * 2 使用TaskStackBuilder构造PendingIntent，处理回退按钮。
 */

package com.cacard.androiddemo.activity.ui;

import com.cacard.androiddemo.MainActivity;
import com.cacard.androiddemo.R;
import com.cacard.androiddemo.activity.ActivityA;
import com.cacard.androiddemo.activity.ActivityB;
import com.cacard.androiddemo.activity.ActivityC;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.TaskStackBuilder;

public class NotificationDemo {

    public static void testCreateNotification(Context ctx) {
        Notification.Builder b = new Notification.Builder(ctx);
        b.setContentTitle("title");
        b.setContentText("content text");
        b.setSmallIcon(R.drawable.ic_launcher);
        b.setNumber(1);
        Notification n = b.build();

        // 使用
        NotificationManager nm = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(0, n);

        // 更新
        b.setNumber(2);
        nm.notify(0, b.build());

        // pending intent
        Intent i1 = new Intent(ctx, MainActivity.class);
        Intent i2 = new Intent(ctx, ActivityA.class);
        Intent i3 = new Intent(ctx, ActivityB.class);
        Intent i4 = new Intent(ctx, ActivityC.class);

        TaskStackBuilder tsb = TaskStackBuilder.create(ctx);
        tsb.addNextIntent(i1).addNextIntent(i2)/*.addNextIntent(i3)*/.addNextIntent(i4);
        b.setContentIntent(tsb.getPendingIntent(2, PendingIntent.FLAG_CANCEL_CURRENT));
        b.setNumber(3);
        nm.notify(0, b.build());

    }

    public static void testPendingIntent() {

    }

}
