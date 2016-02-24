package com.cacard.demo.Messenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Messenger Demo
 * <p/>
 * Messenger用来干啥用的呐？是作为进程间通信用的。
 * 比如讲，进程A的信使(Messenger)带了个Handler，传递给进程B，
 * B打开信使，拿到Handler，通过Handler向进程A发送消息。
 * <p/>
 * Created by cunqingli on 2016/2/24.
 */
public class MessengerDemoActivity extends Activity {

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Log.i("messenger", "mHandler->handleMessage()");
            ServiceInOtherProcess service = (ServiceInOtherProcess) msg.obj;
            if (service != null) {
                service.sayHello();
            } else {
                Log.i("messenger", "service is null");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout ll = new LinearLayout(this);
        Button btn = new Button(this);
        btn.setText("startSerivce");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessengerDemoActivity.this, ServiceInOtherProcess.class);
                intent.putExtra("messenger", new Messenger(mHandler));
                startService(intent);
            }
        });
        ll.addView(btn);
        setContentView(ll);
    }
}
