package com.cacard.demo.Service.BindOnCreate;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.cacard.demo.MyApplication;

/**
 * Created by cunqingli on 2015/6/25.
 */
public class BindOnCreateActivity extends Activity {

    private static final String TAG = BindOnCreateActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        Button btn1 = new Button(this);
        btn1.setText("start bind");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bind();
            }
        });

        Button btn2 = new Button(this);
        btn2.setText("stop bind");
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbind();
            }
        });

        linearLayout.addView(btn1);
        linearLayout.addView(btn2);
        this.setContentView(linearLayout);
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            log("onServiceConnected");
            MyApplication.instance.startService(new Intent(MyApplication.instance, BindOnCreateService.class));
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            log("onServiceDisconnected");
        }
    };

    private void bind() {
        log("->bind()");
        MyApplication.instance.bindService(new Intent(MyApplication.instance, BindOnCreateService.class), connection, BIND_AUTO_CREATE);
    }

    private void unbind() {
        if (connection != null) {
            this.unbindService(connection);
        }
    }

    private void log(String msg) {
        Log.i(TAG, msg);
    }
}
