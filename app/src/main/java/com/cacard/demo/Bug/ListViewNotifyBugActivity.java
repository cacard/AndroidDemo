package com.cacard.demo.Bug;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter'data changed(at no ui thread),but no notify!
 * <p/>
 * #1 measure与layoutChildren之间其它线程修改了adapter的数据；
 * #2 绑定Adapter之后，addHeaderView
 * <p/>
 * <p/>
 * <p/>
 * <p/>
 * <p/>
 * Created by cunqingli on 2016/9/8.
 */
public class ListViewNotifyBugActivity extends Activity {

    private FrameLayout root;
    private NotifyBugListView lv;
    private ListViewNotifyBugAdapter adapter;
    private List<String> data;
    Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        root = new FrameLayout(this);
        lv = new NotifyBugListView(this);
        root.addView(lv);
        setContentView(root);

        data = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            data.add("string" + i);
        }
        adapter = new ListViewNotifyBugAdapter(this, data);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        lv.requestLayout();

        adapter.getData().add("---");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //updateDataAtNoUiThread();
                addHeader();
            }
        }, 2000);
    }


    private void addHeader() {
        TextView tv = new TextView(this);
        tv.setText("footer");
        lv.addHeaderView(tv);
    }


    private void updateDataAtUiThread() {
        // @Ui Thread.[is ok]
        // change the data of adapter dealy

        adapter.getData().add("hello");
        //lv.requestLayout();

    }


    private void updateDataAtNoUiThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i("notify", "no ui thread");

                // 这种修改数据的方式仅在Debug时出现过Crash
                adapter.getData().add("hello");
                adapter.getData().add("hello2");


                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        lv.requestLayout();
                    }
                }, 2000);
            }
        }).start();
    }
}
