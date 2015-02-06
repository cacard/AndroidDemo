package com.cacard.androiddemo.service;

import com.cacard.androiddemo.service.BoundServiceDemo.XXXBinder;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

public class ServiceDemo {

    private BoundServiceDemo mService;
    private boolean mBound = false;

    /**
     * 测试 bound-service
     *
     * @param ctx
     */
    public void testBoundService(final Context ctx) {
        // connection
        Intent i = new Intent(ctx, BoundServiceDemo.class);
        ctx.bindService(i, mConnection, Context.BIND_AUTO_CREATE); // non-blocking

        // 延迟几秒，等待Connection建立
        Handler h = new Handler(new Handler.Callback() {

            @Override
            public boolean handleMessage(Message msg) {
                if (mBound && mService != null) {
                    // invoke
                    Log.i("test", "invoke result:" + mService.XXXMethod1());
                } else {
                    Log.i("test", "mBound = false,mService==null?" + (mService == null));
                }
                return true;
            }
        });

        h.sendMessageDelayed(Message.obtain(), 1000 * 5);


        // 关闭连接
        ctx.unbindService(mConnection);
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            // 转化IBinder为XXXService实例了
            ServiceDemo.this.mService = ((XXXBinder) service).getSerivice();
            ServiceDemo.this.mBound = true;
            Log.i("test", "connection ok.threadid:" + Thread.currentThread().getId());
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {


        }
    };


}
