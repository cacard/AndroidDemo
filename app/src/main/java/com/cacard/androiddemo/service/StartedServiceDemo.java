

package com.cacard.androiddemo.service;

import android.R;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * StartedService（启动型Service）测试
 * <p/>
 * 多次请求均采用一个Looper处理消息
 */
public class StartedServiceDemo extends Service {

    private HandlerThread hThread;
    private boolean isCreate = false;
    private AtomicInteger requestCount = new AtomicInteger(0);
    private AtomicInteger createCount = new AtomicInteger(0);

    /**
     * 创建HandlerThread
     */
    @Override
    public void onCreate() {
        Log.i("test", "StartedService onCreate.");
        createCount.getAndIncrement();
        hThread = new HandlerThread("thread name");
        hThread.start();


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("test", "acquire WakeLock:Full wake lock");
        // 亮起屏幕
        PowerManager pm = (PowerManager) this.getSystemService(Context.POWER_SERVICE);
        WakeLock lock = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "wakelock2");
        lock.acquire(1000 * 60 * 1);

        String msg = intent.getStringExtra("msg");
        if (msg != null && msg.equals("stop")) {
            this.stopSelf(startId);
        }

        // 常驻通知栏
        Notification.Builder b = new Notification.Builder(this);
        b.setContentTitle("TEST");
        b.setSmallIcon(R.drawable.btn_default);

        this.startForeground(1, b.build());


        Log.i("test", "StartedService onStartCommand.startId:" + startId);

        requestCount.getAndIncrement();

        Handler h = new Handler(hThread.getLooper(), new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                Log.i("test", "get a message,requestCount=" + requestCount.get() + "/createCount=" + createCount.get());
                return true;
            }
        });

        h.sendEmptyMessage(0);

        return Service.START_STICKY; // 此处返回后，服务继续运行，直到手动停止
    }

    @Override
    public void onDestroy() {
        Log.i("test", "StartedService destroy.");

        this.stopForeground(true);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;// 非BoundService，返回null
    }

}
