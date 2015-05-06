package com.cacard.demo.Media;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.cacard.demo.R;

/**
 * 音频播放Demo
 * <p/>
 * Created by cunqingli on 2015/5/6.
 */
public class ActivityAudioPlayer extends Activity {

    private MediaPlayer player;
    SeekBar seekBar;
    TextView tvLog;
    TextView tvInfo;

    private static final int WHAT = 1;
    private static final int DELAY = 1000;

    // 用以循环更新播放进度
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            displayMediaInfo();
            sendEmptyMessageDelayed(WHAT, DELAY);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createLayout();
    }

    private void createLayout() {
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);

        Button btn1 = new Button(this);
        btn1.setText("Play");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playLocalMusic();
            }
        });

        // seek bar
        seekBar = new SeekBar(this);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                appendLog("SeekBar.onProgressChanged,progress:" + progress + ",fromUser:" + fromUser);

                // 如果是用户手动拖动，更新
                if (fromUser && player != null) {
                    player.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                appendLog("SeekBar.onStartTrackingTouch");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                appendLog("SeekBar.onStopTrackingTouch,+progress:");
            }
        });

        Button btn2 = new Button(this);
        btn2.setText("Stop");
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                releasePlayer();
                releaseHandler();
            }
        });

        Button btn3 = new Button(this);
        btn3.setText("Update info");
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayMediaInfo();
            }
        });

        // 瞬时信息
        tvInfo = new TextView(this);
        tvInfo.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tvInfo.setText("-info-");

        tvLog = new TextView(this);
        tvLog.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        tvLog.setText("log:\n");
        tvLog.setMovementMethod(ScrollingMovementMethod.getInstance());
        tvLog.setVerticalScrollBarEnabled(true);

        Button btnClearLog = new Button(this);
        btnClearLog.setText("Clear Log");
        btnClearLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvLog.setText("");
            }
        });

        root.addView(btn1);
        root.addView(seekBar);
        root.addView(btn2);
        root.addView(btn3);
        root.addView(btnClearLog);
        root.addView(tvInfo);
        root.addView(tvLog);

        this.setContentView(root);
    }

    // 播放本地音乐
    private void playLocalMusic() {

        if (player != null) {
            releasePlayer();
        }

        player = MediaPlayer.create(this, R.raw.music);// create()里面已经prepare()了
        addListener();
        seekBar.setMax(player.getDuration());
        player.start();

        displayMediaInfo();
        handler.sendEmptyMessageDelayed(WHAT, DELAY);// 开启循环显示
    }

    // 为当前player添加监听事件
    private void addListener() {

        // 出现错误
        player.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                appendLog("onError,what:" + what + ",extra:" + extra);
                return false; // 返回false表示未处理错误，引发OnCompletio
            }
        });

        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                appendLog("onCompletion");
            }
        });

        // 已准备好状态
        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                appendLog("onPrepared");
            }
        });

        //
        player.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {
                appendLog("onInfo,what:" + what + ",extra:" + extra);
                return false;
            }
        });

        // 已缓冲多少
        player.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(MediaPlayer mp, int percent) {
                appendLog("onBufferingUpdate,percent:" + percent);
            }
        });

        // seek完成
        player.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() {
            @Override
            public void onSeekComplete(MediaPlayer mp) {
                appendLog("onSeekComplete");
            }
        });
    }

    // 显示瞬时信息
    private void displayMediaInfo() {
        if (player == null) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Duration:").append(player.getDuration()).append("\n");
        sb.append("CurrentPosition:").append(player.getCurrentPosition()).append("\n");
        sb.append("AudioSessionId:").append(player.getAudioSessionId()).append("\n");

        tvInfo.setText(sb.toString());

        updateSeekBar(player.getCurrentPosition());
    }

    // 更新SeekBar
    private void updateSeekBar(int progress) {
        seekBar.setProgress(progress);
    }

    // 释放资源
    private void releasePlayer() {
        if (player != null) {
            player.stop();
            player.release();
            player = null;
        }
    }

    private void releaseHandler() {
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    private void appendLog(String msg) {
        tvLog.append(msg + "\n");
    }

    @Override
    protected void onStop() {
        super.onStop();
        releasePlayer();
        releaseHandler();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releasePlayer();
        releaseHandler();
    }
}
