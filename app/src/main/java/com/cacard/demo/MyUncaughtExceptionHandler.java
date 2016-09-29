package com.cacard.demo;

import android.util.Log;

/**
 * Created by cunqingli on 2016/9/19.
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        bug();
    }

    /**
     * 复现一个Bug
     * <p>
     * 当App Crash时（或者被杀死），会触发这个UncaughtException。
     * 但这里面再新开启一些线程（线程又开启一些线程），看会不会出现异常：
     * java.lang.InternalError: Thread starting during runtime shutdown
     * <p>
     * 这个异常是在Native层创建线程时，如果发现runntime is shutting down，就会抛出。
     */
    private void bug() {
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
