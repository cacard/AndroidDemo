package com.cacard.demo.ViewPager.Demo2FragmentPagerAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by cunqingli on 2015/9/23.
 */
public class MyFragmentPagerAdapter2 extends FragmentPagerAdapter {

    List<String> titles ;

    public MyFragmentPagerAdapter2(FragmentManager fm,List<String> titles) {
        super(fm);
        this.titles = titles;
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public Fragment getItem(int position) {
        return MyFragment.create(titles.get(position));
    }
}
