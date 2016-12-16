package com.cacard.demo;

import android.util.Log;

/**
 * Created by cunqingli on 2016/9/19.
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    public static final String TAG = "InternalError";

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        try {
            bug();
        } catch (Throwable e) {
            Log.i("InternalError", "捕捉到");
        }
    }

    /**
     * 复现一个Bug
     * <p>
     * 当App Crash时（或者被杀死）————即，Runtime is shuttingdown，会触发这个UncaughtException。
     * 而且这里面再新开启一些线程（线程又开启一些线程），看会不会出现异常：
     * java.lang.InternalError: Thread starting during runtime shutdown
     * <p>
     * 这个异常是在Native层创建线程时，如果发现runntime is shutting down，就会抛出。
     */
    public static void bug() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i("InternalError", "->1");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("InternalError", "->2");
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                Log.i("InternalError", "->3");
                            }
                        }).start();
                    }
                }).start();
            }
        }).start();
    }
}
