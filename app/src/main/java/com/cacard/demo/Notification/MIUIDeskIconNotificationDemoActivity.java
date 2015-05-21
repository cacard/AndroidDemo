package com.cacard.demo.Notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;

import com.cacard.demo.R;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by cunqingli on 2015/5/21.
 */
public class MIUIDeskIconNotificationDemoActivity extends Activity {

    private int mCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
            mCount++;
            notifyTest(mCount);
            return true;
        }

        return super.onTouchEvent(event);
    }

    private void notifyTest(int c) {
        NotificationManager mNotificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(this).setContentTitle("title").setContentText("test").setSmallIcon(R.drawable.android_yellow);
        Notification notification = builder.build();
        try {
            Field field = notification.getClass().getDeclaredField("extraNotification");
            Object extraNotification = field.get(notification);
            Method method = extraNotification.getClass().getDeclaredMethod("setMessageCount", int.class);
            method.invoke(extraNotification, c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mNotificationManager.notify(0, notification);
    }
}
