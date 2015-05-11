package com.cacard.demo.Media;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.cacard.demo.MyApplication;

/**
 * Created by cunqingli on 2015/5/7.
 */
public class ActivityAudioPlayerUsingService extends Activity {

    private static final String TAG = "ActivityAudioPlayerUsingService";
    private Intent intentAudioService;
    private AudioPlayerService mService;
    private boolean isBound; // 是否已绑定
    private boolean isNeedPlayAfterBound; // 是否在绑定后开始播放

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            log("onServiceConnected");
            isBound = true;
            mService = ((AudioPlayerService.InnerBinder) service).getService();

            if (isNeedPlayAfterBound) {
                addListener();
                playLocalMusic();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            log("onServiceDisconnected");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        intentAudioService = new Intent(this, AudioPlayerService.class);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);

        Button btnPlay = new Button(this);
        btnPlay.setText("Play");
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBound) {
                    addListener();
                    playLocalMusic();
                } else {
                    isNeedPlayAfterBound = true;
                    startAndBindService();
                }
            }
        });

        Button btnStop = new Button(this);
        btnStop.setText("Stop");
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopPlayer();
            }
        });

        Button btnStopService = new Button(this);
        btnStopService.setText("StopService");
        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService();
            }
        });

        Button btnNextPage = new Button(this);
        btnNextPage.setText("Next Page");
        btnNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityAudioPlayerUsingService.this, ActivityAudioPlayerUsingService2.class));
            }
        });

        root.addView(btnPlay);
        root.addView(btnStop);
        root.addView(btnStopService);
        root.addView(btnNextPage);

        this.setContentView(root);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // 如果服务运行就尝试绑定，否者在Play时启动并绑定服务
        if (((MyApplication) getApplication()).isAudioPlayerServiceRunning && !isBound) {
            tryBindService();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        tryUnbindService();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tryUnbindService();
    }

    // -------- player manager ----------

    private void pausePlayer() {
        if (mService != null && mService.getPlayer() != null) {
            mService.getPlayer().pause();
        }
    }

    private void resumePlayer() {
        if (mService != null && mService.getPlayer() != null) {
            mService.getPlayer().start();
        }
    }

    private void stopPlayer() {
        tryUnbindService();
        stopService(intentAudioService);
    }

    // 播放本地音乐 TODO 使用service传递过来的player播放！
    private void playLocalMusic() {
        if (mService != null && mService.getPlayer() != null) {
            mService.getPlayer().start();
        }
    }

    // TODO 播放网络音乐
    private void playInternetMusic() {

        String url = "";

    }


    // 为当前player添加监听事件
    // TODO 保险起见使用静态内部类
    private void addListener() {
        if (mService == null || mService.getPlayer() == null) {
            return;
        }

        mService.getPlayer().setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                appendLog("onError,what:" + what + ",extra:" + extra);
                return false; // 返回false表示未处理错误，引发OnCompletio
            }
        });

        mService.getPlayer().setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                appendLog("onCompletion");
            }
        });

        mService.getPlayer().setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                appendLog("onPrepared");
            }
        });

        mService.getPlayer().setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {
                appendLog("onInfo,what:" + what + ",extra:" + extra);
                return false;
            }
        });

        mService.getPlayer().setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(MediaPlayer mp, int percent) {
                appendLog("onBufferingUpdate,percent:" + percent);
            }
        });

        mService.getPlayer().setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() {
            @Override
            public void onSeekComplete(MediaPlayer mp) {
                appendLog("onSeekComplete");
            }
        });
    }

    // -------- service manager --------

    private void stopService() {
        tryUnbindService();
        try {
            stopService(intentAudioService);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startAndBindService() {
        startService(intentAudioService);
        tryBindService();
    }

    private void tryBindService() {
        bindService(intentAudioService, mConnection, BIND_AUTO_CREATE);
    }

    private void tryUnbindService() {
        if (isBound) {
            try {
                unbindService(mConnection);
                isBound = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void log(String msg) {
        Log.i(TAG, msg);
    }

    private void appendLog(String msg) {
        log(msg);
    }
}
