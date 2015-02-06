package com.cacard.androiddemo.systemservice;

import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;

public class WakeLockDemo {

    /**
     * 获取WakeLock一段时间
     */
    public static void acquireWakLockSomeTime(final Activity ctx, long minutes) {
        PowerManager pm = (PowerManager) ctx.getSystemService(Context.POWER_SERVICE);
        WakeLock lock = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "wakelock demo");
        lock.acquire(1000 * 60 * minutes);
    }


    public static void testWakeLock(final Activity ctx) {
        acquireWakLockSomeTime(ctx, 15);


        // 测试后台线程在灭屏后（休眠）是否依然运行。注意，要在非调试状态下测试。
        // 分别在1）无WakeLock下，2)有PartialWakeLock下，3）在FULL_WAKE_LOCK下。
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    // 更新数据到UI
                    ctx.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ctx.setTitle(new Date().toString());
                        }
                    });

                    // 记录到Log
                    Log.i("test", "->");
                    try {
                        Thread.sleep(1000 * 5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        t1.start();

    }

}
