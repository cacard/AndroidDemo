package com.cacard.demo.launchmode.SingleTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by cunqingli on 2015/8/21.
 */
public class Activity1SingleTask extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        log("onCreate");

        Button btn = new Button(this);
        btn.setText("click");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity1SingleTask.this.startActivity(new Intent(Activity1SingleTask.this, Activity2Normal.class));
            }
        });

        LinearLayout root = new LinearLayout(this);
        root.addView(btn);

        this.setContentView(root);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        log("onNewIntent");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        log("onDestroy");
    }

    private void log(String msg) {
        Log.i("Activity1SingleTask", msg);
    }
}
