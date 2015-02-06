package com.cacard.androiddemo.adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class MyPagerAdapter extends PagerAdapter {

    List<View> list;

    public MyPagerAdapter(List<View> l) {
        this.list = l;
    }

    // 根据position创建page
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position));
        return list.get(position);
    }

    // 根据position去除page
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.remove(position));
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

}
