
package com.cacard.demo.Service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * IntentSerivce是封装好的StartedService，使用单独的工作线程处理请求
 */

public class StartedServiceIntentServiceDemo extends IntentService {

    public StartedServiceIntentServiceDemo() {
        super("test");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //String msg = intent.getStringExtra("msg");
        for (int i = 0; i < 10; i++) {
            Log.i("test", "@threadid:" + Thread.currentThread().getId() + "/msg:");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }

    }

}
