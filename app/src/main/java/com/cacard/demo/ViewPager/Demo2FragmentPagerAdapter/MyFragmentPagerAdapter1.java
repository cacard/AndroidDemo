package com.cacard.demo.ViewPager.Demo2FragmentPagerAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by cunqingli on 2015/9/23.
 */
public class MyFragmentPagerAdapter1 extends FragmentPagerAdapter {

    public MyFragmentPagerAdapter1(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }
}
