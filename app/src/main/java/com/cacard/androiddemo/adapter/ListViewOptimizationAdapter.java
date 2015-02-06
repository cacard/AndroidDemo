package com.cacard.androiddemo.adapter;

import java.util.List;

import com.cacard.androiddemo.R;
import com.cacard.androiddemo.model.User;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListViewOptimizationAdapter extends BaseAdapter {

    private List<User> l = null;
    private Context ctx = null;

    public ListViewOptimizationAdapter(List<User> l, Context ctx) {
        this.l = l;
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return l.size();
    }

    @Override
    public Object getItem(int position) {
        return l.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // 跟踪 convertView 什么情况下非null
        Log.i("test", "getView(),position=" + position + ",convertView is null?" + (convertView == null) + ".");

        if (convertView == null) {
            convertView = LayoutInflater.from(ctx.getApplicationContext()).inflate(R.layout.list_view_optimization_item, null);

            TextView tv1 = (TextView) convertView.findViewById(R.id.tv1);
            TextView tv2 = (TextView) convertView.findViewById(R.id.tv2);
            tv1.setText(l.get(position).getName());
            tv2.setText(String.valueOf(l.get(position).getAge()));

            ViewHolder vh = new ViewHolder();
            vh.tv1 = tv1;
            vh.tv2 = tv2;
            convertView.setTag(vh);
        } else {
            ViewHolder vh = (ViewHolder) convertView.getTag();
            vh.tv1.setText(l.get(position).getName());
            vh.tv2.setText(String.valueOf(l.get(position).getAge()));
        }

        return convertView;
    }

    /**
     * 未使用ViewHolder很卡顿，使用后非常好。
     */
    public static class ViewHolder {
        public TextView tv1;
        public TextView tv2;
    }

}
