package com.cacard.demo.Activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 测试Sp文件大小对读取速度的影响
 * 手机：Meizhu MX 4 Pro
 * <p/>
 * sp1 size = ~50k
 * sp2 size = ~1k
 * <p/>
 * 测试结果：
 * sp1：读取耗时：
 * meizhu 21034250，20802375，37086792，即约20-30ms
 * OPPO 30306731
 * 2.3
 * <p/>
 * sp2：读取耗时：
 * meizhu 789750，856042，735417，即约0.7ms
 * OPPO 640928
 * 2.3
 * <p/>
 * Created by cunqingli on 2015/5/4.
 */
public class ActivitySpIODemo extends Activity {

    private String TAG = "SpIODemo";
    private TextView tvLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        Button btn1 = new Button(this);
        btn1.setText("Create Sp and read");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createSp();
                readSp();
            }
        });
        root.addView(btn1);

        Button btn2 = new Button(this);
        btn2.setText("read");
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readSp();
                readWriteManyTimes();
            }
        });
        root.addView(btn2);

        tvLog = new TextView(this);
        tvLog.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        root.addView(tvLog);

        setContentView(root);

    }

    private void createSp() {

        // sp1
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10240; i++) {
            sb.append("_" + i);
        }
        SharedPreferences sp = getSharedPreferences("sp1", MODE_PRIVATE);
        sp.edit().putString("key1", sb.toString()).apply();

        // sp2
        SharedPreferences sp2 = getSharedPreferences("sp2", MODE_PRIVATE);
        sp2.edit().putString("key1", "value1dfsdfsdfdsfsdfsdfdsfdsfdsdsfdsfs").apply();

        // sp3
        SharedPreferences sp3 = getSharedPreferences("sp3", MODE_PRIVATE);
        sp3.edit().putString("key1", sb.toString()).apply();

    }

    // 测试前要Kill App
    private void readSp() {

        String msg = "";

        // 初次读取sp1
        long t1 = System.nanoTime();
        SharedPreferences sp = getSharedPreferences("sp1", MODE_PRIVATE);
        String key1Value = sp.getString("key1", "");
        long t2 = System.nanoTime();
        msg += "sp1:" + (t2 - t1) + "\n";

        // 再次读取sp1
        long t3 = System.nanoTime();
        SharedPreferences sp2 = getSharedPreferences("sp1", MODE_PRIVATE);
        sp2.getString("key1", "");
        long t4 = System.nanoTime();
        msg += "sp1 again:" + (t4 - t3) + "\n";

        // 初次读取sp2
        long tt1 = System.nanoTime();
        SharedPreferences sp3 = getSharedPreferences("sp2", MODE_PRIVATE);
        sp.getString("key1", "");
        long tt2 = System.nanoTime();
        msg += "sp2:" + (tt2 - tt1) + "\n";

        final String msgCopy = msg;

        tvLog.post(new Runnable() {
            @Override
            public void run() {
                tvLog.setText(msgCopy);
            }
        });

        Log.i(TAG, msg);

    }

    // 测试循环读写
    private void readWriteManyTimes() {

        long t1 = System.nanoTime();
        SharedPreferences sp = getSharedPreferences("sp3", MODE_PRIVATE);
        for (int i = 0; i < 10; i++) {
            sp.getString("key" + System.nanoTime(), "");
            sp.edit().putString("key" + System.nanoTime(), "___________________");
        }
        long t2 = System.nanoTime();

        final long t = t2 - t1;

        tvLog.post(new Runnable() {
            @Override
            public void run() {
                tvLog.append("read write 10 times:" + t);
            }
        });
    }
}
