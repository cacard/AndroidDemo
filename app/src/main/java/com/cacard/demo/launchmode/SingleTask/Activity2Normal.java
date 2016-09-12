package com.cacard.demo.launchmode.SingleTask;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by cunqingli on 2015/8/21.
 */
public class Activity2Normal extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Button btn = new Button(this);
        btn.setText("Activity2Normal");

        LinearLayout root = new LinearLayout(this);
        root.addView(btn);
        setContentView(root);



        log("onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        log("onDestroy");
    }

    @Override
    public void finish() {

        super.finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    private void log(String msg) {
        Log.i("Activity2Normal", msg);
    }
}
