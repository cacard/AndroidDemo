package com.cacard.androiddemo.activity.ui;

import java.util.ArrayList;
import java.util.List;

import com.cacard.androiddemo.R;
import com.cacard.androiddemo.adapter.MyPagerAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ViewPagerDemo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_demo);

        // Pager集合
        List<View> list = new ArrayList<View>();
        list.add(this.getLayoutInflater().inflate(R.layout.fragment1, null));
        list.add(this.getLayoutInflater().inflate(R.layout.fragment2, null));

        // ViewPager并设置其Adapter
        ViewPager vp = (ViewPager) this.findViewById(R.id.viewPager);
        vp.setAdapter(new MyPagerAdapter(list));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.view_pager_demo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
