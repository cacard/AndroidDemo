package com.cacard.androiddemo.Message;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.lang.reflect.Method;

/**
 * 异步消息，异步消息未开放给用户
 */
public class TestAsyncMessage {

    // 枚举Message的方法
    private static void testReflectMethod() {
        Message msg = Message.obtain();
        Method[] methods = msg.getClass().getMethods();
        if (methods != null && methods.length > 0) {
            for (Method m : methods) {
                Log.d("test", m.toString());
            }
        }
    }

    // 测试异步消息
    public static void test(Context ctx) {
        if (ctx == null) {
            return;
        }

        // testReflectMethod();

        final Handler handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg != null) {
                    // 模拟耗时
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Log.i("test", "->" + msg.what);
                }

                return true;
            }
        });

        Thread tWorker = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    Message msg = Message.obtain();
                    if (1 == 1) {
                        // msg.setAsynchronous(true); // 该方法是hide的
                        // 反射
                        try {
                            final String methodName = "setAsynchronous";
                            Class c = Class.forName("android.os.Message");
                            Method m = c.getMethod(methodName, new Class[]{boolean.class});
                            m.setAccessible(true);
                            m.invoke(msg, true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    final int id = i;

                    msg.what = id;
                    handler.sendMessage(msg);

                }
            }
        });

        tWorker.start();

    }

}
