

package com.cacard.demo.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * Bound-Serivce（绑定型Service）测试
 * 多个component可同时绑定。都解除绑定，则destroy。
 */
public class BoundServiceDemo extends Service {

    private final IBinder mBinder = new XXXBinder();

    public class XXXBinder extends Binder {
        public BoundServiceDemo getSerivice() {
            return BoundServiceDemo.this;
        }

        ;
    }

    @Override
    public IBinder onBind(Intent intnet) {
        return mBinder;
    }

    // 供Client调用的方法
    public int XXXMethod1() {
        return 1;
    }

    public int XXXMethod2() {
        return 2;
    }


}
