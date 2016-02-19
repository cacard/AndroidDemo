package com.cacard.demo.Media;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by cunqingli on 2015/12/2.
 */
public class AudioFocusDemoActivity extends Activity {

    static final String TAG = "AudioFocusDemoActivity";
    LinearLayout root;
    Button btnAudio1;
    Button btnAudio2;

    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            log("focusChange:" + focusChange);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        btnAudio1 = new Button(this);
        btnAudio1.setText("play1");
        btnAudio2 = new Button(this);
        btnAudio2.setText("play2");
        root.addView(btnAudio1);
        root.addView(btnAudio2);
        this.setContentView(root);

        btnAudio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnAudio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mediaPlayer = new MediaPlayer();
        initPlayerListener();
        audioManager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
    }


    private void play(String url) {
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setDataSource(this, Uri.parse(url));


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void initPlayerListener() {
        if (mediaPlayer != null) {
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {

                }
            });
            mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    return false;
                }
            });
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {

                }
            });

        }
    }


    private void log(String msg) {
        Log.i(TAG, msg);
    }
}
