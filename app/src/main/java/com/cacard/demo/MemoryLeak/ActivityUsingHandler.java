/**
 * Handler引起的Activity内存泄露
 *
 *
 */

package com.cacard.demo.MemoryLeak;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class ActivityUsingHandler extends Activity {

    private final Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            Log.i("test", "handler's callback");
            return false;
        }
    });

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 故意让message包含一个callback，不会调用handler的callback
        Message msg = Message.obtain(handler, new Runnable() {
            @Override
            public void run() {
                Log.i("test", "message's callback");

            }
        });
        msg.what = 2;

        handler.sendMessageDelayed(msg, 5000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

}
