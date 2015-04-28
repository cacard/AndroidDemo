/**
 *  在Activity内部新开线程发生MemoryLeak的演示
 *
 *  - 内部线程是内部类（匿名内部类），持有外部类实例的引用。如果线程长时间运行未销毁，则外部类实例也不会被销毁。
 *
 */

package com.cacard.androiddemo.MemoryLeak;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class ActivityWithThread extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(new Button(this.getApplicationContext()));
        Log.i("test", "start");

        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i < 50) {
                    Log.i("test", "thread running");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    i++;
                }

            }
        }).start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("test", "destroy");
    }

}
