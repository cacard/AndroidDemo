/**
 * 测试 Message/MessageQueue/Handler/Looper/HandlerThread
 */

package com.cacard.androiddemo.thread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class LooperDemo {


    /**
     * 测试发送消息
     * 1 message + handler => MessageQueue => handler处理message
     * 2 [message + runnable] + handler => MessageQueue => 调用runnable(同线程)
     */
    public static void testMessage(final Activity ctx) {

        // 创建消息
        Message m = new Message();
        m.arg1 = 1;
        m.arg2 = 2;
        m.obj = new Object();
        m.setData(new Bundle());

        // 从m复制消息
        Message m2 = Message.obtain(m);

        // 处理Message的Handler
        MyHandler h = new MyHandler();


        // 设置Message的target为handler
        m.setTarget(h);
        m.sendToTarget();
        // OR
        // h.sendMessage(m);

        // 发送Runnable
        h.post(new Runnable() {
            @Override
            public void run() {
                ctx.setTitle("runnable");
                Log.i("test", "runnable executed." + ",thread id" + Thread.currentThread().getId()); // 主线程ID
            }
        });

    }

    /**
     * 测试Looper
     * 1 使用主线程Looper发送消息
     * 2 使用自定义Looper线程处理消息
     * 3 使用HandlerThread
     */
    public static void testLooper() {
        // ----------------------
        // 在主线程的Looper中处理消息
        Handler h1 = new Handler(new Handler.Callback() {

            @Override
            public boolean handleMessage(Message msg) {
                Log.i("test", "[main looper] get a message");
                return true;
            }
        });
        h1.sendEmptyMessage(0);

        // ----------------------
        // 在新Looper中处理消息（简单实现）
        MyLooperThread t = new MyLooperThread();
        t.start();

        // 等待 looper 被创建
        while (t.isLooperAlready == false) {
            // wait
        }

        Handler h = new Handler(t.looper, new Handler.Callback() {

            @Override
            public boolean handleMessage(Message msg) {
                Log.i("test", "[my looper] get a message");
                return true;
            }
        });

        h.sendEmptyMessage(0);

        // -----------------------
        // 使用 HandlerThread
        HandlerThread ht = new HandlerThread("thread name");
        ht.start();

        Handler _h = new Handler(ht.getLooper(), new Handler.Callback() {

            @Override
            public boolean handleMessage(Message msg) {
                Log.i("test", "[Handler Thread] get a message");
                return true;
            }
        });
        _h.sendEmptyMessage(0);

    }

}

/**
 * 自定义Handler
 */
class MyHandler extends Handler {
    @Override
    public void handleMessage(Message msg) {
        Log.i("test", "handleMessage executed." + String.valueOf(msg.arg1) + ",thread id" + Thread.currentThread().getId());

    }
}

/**
 * 自定义带有Looper的Thread
 */
class MyLooperThread extends Thread {
    public Looper looper;
    public boolean isLooperAlready = false;

    @Override
    public void run() {
        Log.i("test", "[]threadid:" + Thread.currentThread().getId());

        // 准备。为当前线程创建Looper对象
        Looper.prepare();

        looper = Looper.myLooper();
        isLooperAlready = true;


        Looper.loop(); // 一直循环。
        Log.i("test", "looper exit");
    }
}