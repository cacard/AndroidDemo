package com.cacard.demo.Log;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by cunqingli on 2016/4/28.
 */
public class LogReaderActivity extends Activity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);

        tv = new TextView(this);
        tv.setText("----------------");

        ll.addView(tv);
        this.setContentView(ll);

        startLog();
        startWriteLog();
    }

    private void startLog() {
        LogReader.readLogUsingCmd(tv);
    }

    private void startWriteLog() {
        for (int i = 0; i < 10; i++) {
            final int _i = i;
            tv.post(new Runnable() {
                @Override
                public void run() {
                    Log.i("lcq111", "test" + _i);
                }
            });
        }
    }
}
