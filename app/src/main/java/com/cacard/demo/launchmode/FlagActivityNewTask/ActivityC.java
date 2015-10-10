package com.cacard.demo.launchmode.FlagActivityNewTask;

import android.app.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by cunqingli on 2015/9/28.
 */
public class ActivityC extends android.app.Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("ActivityC");

        Button button = new Button(this);
        button.setText("click");
        this.setContentView(button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i = new Intent(ActivityC.this, ActivityC.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        ActivityC.this.startActivity(i);
                    }
                },0);
            }
        });

    }
}
