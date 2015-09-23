package com.cacard.demo.ViewPager.Demo1;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by cunqingli on 2015/9/23.
 */
public class ViewPagerDemo1Adapter extends PagerAdapter {

    private List<View> views;

    @Override
    public CharSequence getPageTitle(int position) {
        return String.valueOf(position);
    }

    public ViewPagerDemo1Adapter(List<View> views) {
        this.views = views;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position));
        return views.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
