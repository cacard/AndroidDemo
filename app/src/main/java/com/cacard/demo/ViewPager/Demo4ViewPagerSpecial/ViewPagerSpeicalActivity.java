package com.cacard.demo.ViewPager.Demo4ViewPagerSpecial;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cunqingli on 2015/9/23.
 */
public class ViewPagerSpeicalActivity extends Activity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewPager = new ViewPager(this);
        viewPager.setId(View.generateViewId());
        viewPager.setClipToPadding(false);
        viewPager.setPageMargin(20);
        viewPager.setPadding(60,60,60,60);
        this.setContentView(viewPager);

        List<View> v = new ArrayList<View>();
        for (int i = 0; i < 5; i++) {
            FrameLayout layout = new FrameLayout(this);
            FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            TextView tv = new TextView(this);
            tv.setLayoutParams(lp);
            tv.setText("#" + i);
            tv.setBackgroundColor(Color.BLUE);
            v.add(tv);
        }
        ViewPagerSpecialAdapter adapter = new ViewPagerSpecialAdapter(v);
        viewPager.setAdapter(adapter);
    }
}
