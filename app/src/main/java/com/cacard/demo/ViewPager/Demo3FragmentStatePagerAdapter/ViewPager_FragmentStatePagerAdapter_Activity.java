package com.cacard.demo.ViewPager.Demo3FragmentStatePagerAdapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * 为什么使用FragmentStatePagerAdapter？
 *  FragmentPagerAdapter保存每个展示过的Pager到内存；
 *  FragmentStatePagerAdapter仅保存每个Pager的状态，使用Pager量比较多的情况。
 *
 * Created by cunqingli on 2015/9/23.
 */
public class ViewPager_FragmentStatePagerAdapter_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
