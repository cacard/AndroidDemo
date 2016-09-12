//package com.cacard.demo.AndroidN.Notification;
//
//import android.annotation.TargetApi;
//import android.content.Intent;
//import android.os.IBinder;
//import android.service.quicksettings.TileService;
//import android.widget.Toast;
//
///**
// * Created by cunqingli on 2016/8/3.
// */
//@TargetApi(24)
//public class AndroidNTileService extends TileService {
//
//    private static final String TAG = AndroidNTileService.class.getSimpleName();
//
//    @Override
//    public void onDestroy() {
//        dump("onDestroy");
//        super.onDestroy();
//    }
//
//    @Override
//    public void onTileAdded() {
//        dump("onTileAdded");
//        super.onTileAdded();
//    }
//
//    @Override
//    public void onTileRemoved() {
//        dump("onTileRemoved");
//        super.onTileRemoved();
//    }
//
//    @Override
//    public void onStartListening() {
//        dump("onStartListening");
//        super.onStartListening();
//    }
//
//    @Override
//    public void onStopListening() {
//        dump("onStopListening");
//        super.onStopListening();
//    }
//
//    @Override
//    public void onClick() {
//        dump("onClick");
//        super.onClick();
//    }
//
//    @Override
//    public IBinder onBind(Intent intent) {
//        dump("onBind");
//        return super.onBind(intent);
//    }
//
//    private void dump(String msg) {
//        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
//    }
//}
