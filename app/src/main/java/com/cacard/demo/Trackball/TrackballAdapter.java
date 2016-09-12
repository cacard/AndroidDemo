package com.cacard.demo.Trackball;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cunqingli on 2016/9/12.
 */
public class TrackballAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> mData = new ArrayList<>();

    public TrackballAdapter(Context ctx, List<String> data) {
        mContext = ctx;
        mData = data;
    }

    public void add(String str) {
        mData.add(str);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (mData == null || mData.size() == 0) {
            return null;
        }

        String str = mData.get(position);
        TextView tv = new TextView(mContext);
        tv.setText(str);

        return tv;
    }
}
