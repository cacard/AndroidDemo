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

/**
 * Created by cunqingli on 2015/6/25.
 */
public class DemoActivity extends Activity {

    private static final String TAG = DemoActivity.class.getSimpleName();

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

        linearLayout.addView(btn1);
        this.setContentView(linearLayout);
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            log("onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            log("onServiceDisconnected");
        }
    };

    private void bind() {
        this.bindService(new Intent(this, BindOnCreateService.class), connection, 0);
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
