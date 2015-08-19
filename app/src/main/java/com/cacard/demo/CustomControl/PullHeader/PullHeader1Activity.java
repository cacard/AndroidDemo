package com.cacard.demo.CustomControl.PullHeader;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ListView;

import com.cacard.demo.R;

/**
 * 下拉时可伸缩的头部
 * <p/>
 * Created by cunqingli on 2015/7/7.
 */
public class PullHeader1Activity extends Activity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_pull_header_1);
        lv = (ListView) findViewById(R.id.iv);

        lv.requestLayout();

        initListener();
    }

    private void initListener() {
        if (lv != null) {
            lv.setOnScrollListener(new AbsListView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(AbsListView view, int scrollState) {

                }

                @Override
                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                }
            });
        }
    }
}
