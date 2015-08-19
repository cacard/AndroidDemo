package com.cacard.demo.Broadcast;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.cacard.demo.R;

/**
 * Created by cunqingli on 2015/8/10.
 */
public class ActivityRegReceiverManyTimes extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BroadcastReceiverSimple simple = new BroadcastReceiverSimple();
        IntentFilter filter = new IntentFilter();
        filter.addAction("test");

        // --------------------
        // case #1：多次注册同一个对象
        // 结论：相当于注册一次
        //this.registerReceiver(simple, filter);
        //this.registerReceiver(simple, filter);

        // -------------------
        // case #2：多次注册多个对象
        // 结论：多次接收到广播，需要反注册多次
        this.registerReceiver(new BroadcastReceiverSimple(), filter);
        this.registerReceiver(new BroadcastReceiverSimple(), filter);

        Button btn = new Button(this);
        btn.setText("send broadcast");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("test");
                ActivityRegReceiverManyTimes.this.sendBroadcast(intent);
            }
        });

        LinearLayout layout = new LinearLayout(this);
        layout.addView(btn);

        this.setContentView(layout);
    }
}
