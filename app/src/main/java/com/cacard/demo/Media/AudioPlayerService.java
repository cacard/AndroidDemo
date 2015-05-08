package com.cacard.demo.Media;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.cacard.demo.MyApplication;
import com.cacard.demo.R;

/**
 * Started(后台运行) + Bound(交互)
 * <p/>
 * Service包含一个mediaPlayer，提供该接口向外暴露mediaPlayer。
 * 尽可能保持该Service的简单性——即，为多个Activity提供后台媒体播放服务。
 * <p/>
 * Created by cunqingli on 2015/5/7.
 */
public class AudioPlayerService extends Service {

    private static final String TAG = "AudioPlayerService";
    private MediaPlayer player;
    private final Binder mBinder = new InnerBinder();

    public class InnerBinder extends Binder {
        public AudioPlayerService getService() {
            return AudioPlayerService.this;
        }
    }

    @Override
    public void onCreate() {
        log("onCreate()");
        super.onCreate();
        ((MyApplication) getApplication()).isAudioPlayerServiceRunning = false;

        createPlayer4Local("");

        PlayerWindowManager.getInstance().createAndShowWindow();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        log("onStartCommand()");

        if (player == null) {
            createPlayer4Local("");
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        log("onBind()");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        log("onUnbind()");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        log("onRebind()");
        super.onRebind(intent);
    }

    private void createPlayer4Internet(String url) {
        if (player != null) {
            player.reset();
        } else {
            player = new MediaPlayer();
        }
    }

    private void createPlayer4Local(String path) {
        player = MediaPlayer.create(this, R.raw.music);
    }

    public void releasePlayer() {
        if (player != null) {
            player.release();
            player = null;
        }
    }

    public MediaPlayer getPlayer() {
        return player;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        releasePlayer();
        ((MyApplication) getApplication()).isAudioPlayerServiceRunning = false;
        PlayerWindowManager.getInstance().removeWindow();
        log("onDestroy()");
    }

    private void log(String msg) {
        Log.i(TAG, msg);
    }

}