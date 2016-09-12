package com.cacard.demo.Trackball;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * 轨迹球
 * <p/>
 * 模拟器中可以开启nexus one皮肤；
 * 修改config.ini的trackball=yes；
 * <p/>
 * 测试验证：
 * 1，Touch模式下，使用键盘/轨迹球是否改变了View的isInTouchMode。
 * - 切换到键盘后，isInTouchMode为false；
 * <p/>
 * 2，一个bug验证：切回TouchMode后，AbsListView的onWindowFocusChanged会进行layoutChildren调用。
 * <p/>
 * <p/>
 * Created by cunqingli on 2016/9/12.
 */
public class TrackballDemoActivity extends Activity {

    public static final String TAG = "TrackballDemoActivity";
    TrackballListView lv;
    TrackballAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lv = new TrackballListView(this);
        setContentView(lv);

        initAdapter();
        initListener();
    }

    private void initAdapter() {
        mAdapter = new TrackballAdapter(this, getInitData());
        lv.setAdapter(mAdapter);
    }

    private void initListener() {
        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                Log.i(TAG, "lv#isInTouchMode:" + lv.isInTouchMode());

                if (firstVisibleItem > 6) {
                    // 更改一下adapter的数据
                    if (lv.isInTouchMode() == false) {
                        lv.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // 没有notify的情况下，复现Bug
                                ((TrackballAdapter) lv.getAdapter()).add("from onScroll");
                                //((TrackballAdapter) lv.getAdapter()).notifyDataSetChanged();
                                Log.i(TAG, "changed adapter's data");
                            }
                        }, 1000);
                    }
                }
            }
        });
    }

    private List<String> getInitData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add("string" + i);
        }
        return list;
    }
}
