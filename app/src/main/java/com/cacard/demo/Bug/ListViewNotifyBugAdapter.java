package com.cacard.demo.Bug;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cunqingli on 2016/9/8.
 */
public class ListViewNotifyBugAdapter extends BaseAdapter {

    private Context mCtx;
    private List<String> mData = new ArrayList<>();

    public ListViewNotifyBugAdapter(Context ctx, List<String> data) {
        mCtx = ctx;
        mData = data;
    }

    public void setData(List<String> data) {
        mData = data;
    }

    public List<String> getData() {
        return mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        if (mData == null || mData.size() == 0) {
            return null;
        }
        return mData.get(position);
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

        TextView tv = new TextView(mCtx);
        tv.setText(mData.get(position));
        return tv;
    }
}
