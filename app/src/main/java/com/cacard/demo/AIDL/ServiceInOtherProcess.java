package com.cacard.demo.AIDL;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by cunqingli on 2016/11/15.
 */

public class ServiceInOtherProcess extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
