package com.cacard.demo.launchmode.FlagActivityNewTask;

import android.app.*;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by cunqingli on 2015/9/28.
 */
public class ActivityB extends android.app.Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("ActivityB");

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(ActivityB.this, ActivityC.class);
                ActivityB.this.startActivity(i);
            }
        }, 1000);
    }
}
