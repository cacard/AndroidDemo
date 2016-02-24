package com.cacard.demo.Messenger;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by cunqingli on 2016/2/24.
 */
public class ServiceInOtherProcess extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("messenger", "Service->onStartCommand()");
        if (intent != null) {
            Messenger messenger = intent.getParcelableExtra("messenger");
            if (messenger != null) {
                Message msg = Message.obtain();
                msg.what = 0;
                //msg.obj = this;
                try {
                    messenger.send(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("messenger", e.getMessage());
                }
            } else {
                Log.i("messenger", "Service->onStartCommand(), messenger is null");
            }
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void sayHello() {
        Log.i("messenger", "Service->'hello'.");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
