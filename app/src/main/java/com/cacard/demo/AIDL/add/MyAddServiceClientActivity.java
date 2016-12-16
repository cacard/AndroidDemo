package com.cacard.demo.AIDL.add;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cacard.demo.IAdd;

/**
 * Created by cunqingli on 2016/11/15.
 */

public class MyAddServiceClientActivity extends Activity {

    boolean isBind = false;
    IAdd mIAdd;

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            isBind = true;

            // yes! cast like this
            mIAdd = IAdd.Stub.asInterface(service);

            Toast.makeText(MyAddServiceClientActivity.this, "Bind", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBind = false;
            Toast.makeText(MyAddServiceClientActivity.this, "!Bind, Disconnected", Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startBindService();

        LinearLayout ll = new LinearLayout(this);
        Button btn = new Button(this);
        btn.setText("Add(1,1)");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isBind) {
                    Toast.makeText(MyAddServiceClientActivity.this, "not connected", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        int c = mIAdd.add(1, 2);
                        Toast.makeText(MyAddServiceClientActivity.this, "result:" + c, Toast.LENGTH_LONG).show();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        ll.addView(btn);
        this.setContentView(ll);
    }

    private void startBindService() {
        Intent i = new Intent(this, MyAddService.class);
        bindService(i, mServiceConnection, BIND_AUTO_CREATE);
    }
}
