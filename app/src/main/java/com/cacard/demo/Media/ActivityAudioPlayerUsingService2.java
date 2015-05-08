package com.cacard.demo.Media;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * 依然可控制同一个Service
 * Created by cunqingli on 2015/5/7.
 */
public class ActivityAudioPlayerUsingService2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);

        Button btnStop = new Button(this);
        btnStop.setText("Stop");
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(ActivityAudioPlayerUsingService2.this, AudioPlayerService.class));
            }
        });

        root.addView(btnStop);
        this.setContentView(root);
    }
}
