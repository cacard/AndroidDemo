package com.cacard.demo.ViewPager.Demo2FragmentPagerAdapter;

import 	android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * 两种
 * 1，ViewPager的每个页面对应一个Fragment对象；
 * 2，ViewPager的每个页面均对应同一个Fragment对象，仅改变Fragment对象的参数和数据；
 *
 * Created by cunqingli on 2015/9/23.
 */
public class ViewPager_FragmentPagerAdapter_Activity extends AppCompatActivity {

    ViewPager viewPager;
    Fragment fragment1;
    Fragment fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewPager = new ViewPager(this);
        viewPager.setId(View.generateViewId()); // without this will: Unable to find resource ID #0xffffffff
        this.setContentView(viewPager);

        Demo2();

    }

    private void Demo1() {
        fragment1 = new Fragment();
        fragment2 = new Fragment();
        List<Fragment> list = new ArrayList<Fragment>();
        list.add(fragment1);
        list.add(fragment2);

        MyFragmentPagerAdapter1 adapter = new MyFragmentPagerAdapter1(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    // 多个page返回同一个Fragment的不同对象；
    private void Demo2() {
        List<String> titles = new ArrayList<String>();
        titles.add("#1");
        titles.add("#2");
        titles.add("#3");

        MyFragmentPagerAdapter2 adapter2 = new MyFragmentPagerAdapter2(getSupportFragmentManager(),titles);
        viewPager.setAdapter(adapter2);
    }
}
