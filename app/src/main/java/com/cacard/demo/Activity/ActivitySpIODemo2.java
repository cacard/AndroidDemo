package com.cacard.demo.Activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * sp_config.xml 28.35k
 * <p/>
 * 26023583 纳秒
 * 24157750
 * 28657208
 * 23977042
 * ~26ms
 * <p/>
 * sp_config2.xml 3.69k
 * 8160167
 * 7296833
 * 8012250
 * 7473209
 * ~7.7ms
 * <p/>
 * sp_config3.xml 144b
 * ~1.7ms
 * <p/>
 * Created by cunqingli on 2015/5/6.
 */
public class ActivitySpIODemo2 extends Activity {

    private TextView tvLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);

        Button btn = new Button(this);
        btn.setText("start read");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readSp();
            }
        });

        tvLog = new TextView(this);
        tvLog.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        root.addView(btn);
        root.addView(tvLog);
        this.setContentView(root);

        this.setTitle("SpConfig Speed Test");
    }

    private void readSp() {
        String sp1Name = "sp_config";
        String sp2Name = "sp_config2";
        String sp3Name = "sp_config3";
        String key = "channel_version_headnews_news_tech";
        String msg = "";

        long t1 = System.nanoTime();
        SharedPreferences sp1 = getSharedPreferences(sp1Name, MODE_PRIVATE);
        String value1 = sp1.getString(key, "");
        long t2 = System.nanoTime();
        msg += "sp1:" + (t2 - t1) + ",value:" + value1 + "\n";

        t1 = System.nanoTime();
        SharedPreferences sp2 = getSharedPreferences(sp2Name, MODE_PRIVATE);
        String value2 = sp2.getString(key, "");
        t2 = System.nanoTime();
        msg += "sp1:" + (t2 - t1) + ",value:" + value2 + "\n";

        t1 = System.nanoTime();
        SharedPreferences sp3 = getSharedPreferences(sp3Name, MODE_PRIVATE);
        String value3 = sp3.getString(key, "");
        t2 = System.nanoTime();
        msg += "sp1:" + (t2 - t1) + ",value:" + value3 + "\n";

        tvLog.append(msg);
    }


}
