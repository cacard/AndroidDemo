package com.cacard.demo.launchmode.FlagActivityNewTask;

import android.content.Intent;
import android.os.Bundle;

/**
 *
 * 场景#1:拉起的Activity不存在时
 * A->(using FlagActivityNewTask)->B
 * B会在新的Task中创建
 *
 * 场景#2:拉起的Activity在当前Task中已存在
 * A->(using FlagActivityNewTask)->B(in Task2)->C->(using FlagActivityNewTask)->B
 *
 *
 * 场景#3:拉起的Activity在别的Task中已存在
 * A->A1->(using FlagActivityNewTask)->B(in new task)->(using FlagActivityNewTask)->A
 *
 * Created by cunqingli on 2015/9/28.
 */
public class ActivityStart extends android.app.Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("ActivityA");

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // start B
                Intent i = new Intent(ActivityStart.this, ActivityB.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ActivityStart.this.startActivity(i);
            }
        }, 1000);

    }
}
