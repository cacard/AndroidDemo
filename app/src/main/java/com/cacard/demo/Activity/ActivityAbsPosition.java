package com.cacard.demo.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.cacard.demo.R;

/**
 * Created by cunqingli on 2016/6/28.
 */
public class ActivityAbsPosition extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absposition);

        findViewById(R.id.tv1).getLayoutParams().height = 300;

        final TextView tv2 = (TextView) findViewById(R.id.tv2);
        findViewById(R.id.tv2).post(new Runnable() {
            @Override
            public void run() {
                int[] xy = new int[2];
                tv2.getLocationInWindow(xy);
                tv2.setText("x:" + xy[0] + "/y:" + xy[1]);

                int[] xy2 = new int[2];
                tv2.getLocationOnScreen(xy2);
                tv2.append("\nx:" + xy2[0] + "/y:" + xy2[1]);
            }
        });
    }
}
