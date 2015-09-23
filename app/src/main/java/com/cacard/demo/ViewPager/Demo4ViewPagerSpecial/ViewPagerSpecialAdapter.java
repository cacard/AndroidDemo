package com.cacard.demo.ViewPager.Demo4ViewPagerSpecial;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cunqingli on 2015/9/23.
 */
public class ViewPagerSpecialAdapter extends PagerAdapter {

    private List<View> v = new ArrayList<View>();

    public ViewPagerSpecialAdapter(List<View> v) {
        super();
        this.v = v;
    }

    @Override
    public int getCount() {
        return v.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(v.get(position));
        return v.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(v.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public float getPageWidth(int position) {
        return 0.92f;
    }
}
