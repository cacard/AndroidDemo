package com.cacard.demo.UI;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * clipToPadding和clipChild效果演示
 * <p/>
 * android:clipToPadding默认为true，表示设置padding后，子View不会在padding内部绘制；
 * <p/>
 * Created by cunqingli on 2015/9/23.
 */
public class ClipToPaddingDemoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView listView = new ListView(this);
        listView.setId(View.generateViewId());
        listView.setPadding(0, 100, 0, 100);
        listView.setClipToPadding(false);
        //listView.setClipChildren(false);
        this.setContentView(listView);

        listView.setAdapter(new MyAdapter(this));
    }

    private static class MyAdapter extends BaseAdapter {

        List<Integer> list;
        Context ctx;

        public MyAdapter(Context ctx) {
            this.ctx = ctx;
            list = new ArrayList<>();
            for (int i = 0; i < 60; i++) {
                list.add(i);
            }
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv = new TextView(ctx);
            tv.setText("#" + String.valueOf(list.get(position)));
            return tv;
        }
    }
}
