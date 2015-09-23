package com.cacard.demo.ViewPager.Demo1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.cacard.demo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by cunqingli on 2015/9/22.
 */
public class ViewPagerDemo1SimpleActivity extends Activity {

    @Bind(R.id.viewPager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_view_pager_demo_1);
        ButterKnife.bind(this);

        List<View> list = new ArrayList<View>();
        list.add(new ViewBase(this, "View#1"));
        list.add(new ViewBase(this, "View#2"));
        list.add(new ViewBase(this, "View#3"));
        list.add(new ViewBase(this, "View#4"));

        ViewPagerDemo1Adapter adapter = new ViewPagerDemo1Adapter(list);
        viewPager.setAdapter(adapter);
    }
}
