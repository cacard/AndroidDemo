package com.cacard.demo.ViewPagerDemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.cacard.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by cunqingli on 2015/9/22.
 */
public class ViewPagerDemo1Simple extends Activity {

    @Bind(R.id.viewPager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_view_pager_demo_1);
        ButterKnife.bind(this);
    }
}
