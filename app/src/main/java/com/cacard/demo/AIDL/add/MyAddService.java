package com.cacard.demo.AIDL.add;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.cacard.demo.IAdd;

/**
 * 1, dingyid
 * <p>
 * Created by cunqingli on 2016/11/15.
 */

public class MyAddService extends Service {

    private static final String TAG = "MyAddService";

    /**
     * Here need a binder.
     * So we can return our custom binder.
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        // !! main thread
        log("->onBind(),tName:" + Thread.currentThread().getName());

        IBinder binderAdd = new IAdd.Stub() {

            /**
             * This method runing on remote, but impled by we!!!
             */
            @Override
            public int add(int a, int b) throws RemoteException {

                // !!! at Binder_2 thread
                log("->add(),tName:" + Thread.currentThread().getName());

                return a + b;
            }
        };
        return binderAdd;
    }

    public static void log(String msg) {
        Log.i(TAG, msg);
    }
}
