/**
 * ActionBar功能测试
 *
 *
 *
 * Tab
 *
 * 		- Tab切换时可使用 show()/hide()保持每个Fragment的状态（比如数据和滑动位置）
 *
 */

package com.cacard.androiddemo.activity.ui;

import java.lang.reflect.Field;

import com.cacard.androiddemo.R;
import com.cacard.androiddemo.fragment.Fragment1;
import com.cacard.androiddemo.fragment.Fragment2;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewConfiguration;

public class ActivityActionBarDemo extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_actionbar_demo);
        this.setTitle("ActionBar & Tab Demo");

        // final FrameLayout fl = (FrameLayout)
        // this.findViewById(R.id.container);

        setOverflowShowingAlways();

        ActionBar bar = this.getActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        Tab tab1 = bar.newTab().setText("Tab1").setTabListener(new TabListener() {
            private Fragment fg1 = null;

            @Override
            public void onTabSelected(Tab tab, FragmentTransaction ft) {
                // 使用show/hide是为了保存Tab的状态
                if (fg1 == null) {
                    fg1 = new Fragment1();
                    ft.add(R.id.container, fg1, "fg1");
                } else {
                    ft.show(fg1);
                }
            }

            @Override
            public void onTabUnselected(Tab tab, FragmentTransaction ft) {
                ft.hide(fg1);
            }

            @Override
            public void onTabReselected(Tab tab, FragmentTransaction ft) {
            }
        });
        bar.addTab(tab1);

        Tab tab2 = bar.newTab().setText("Tab2").setTabListener(new TabListener() {
            private Fragment fg2 = null;

            @Override
            public void onTabSelected(Tab tab, FragmentTransaction ft) {
                if (fg2 == null) {
                    fg2 = new Fragment2();
                    ft.add(R.id.container, fg2, "fg2");
                } else {
                    ft.attach(fg2);
                }
            }

            @Override
            public void onTabUnselected(Tab tab, FragmentTransaction ft) {
                ft.detach(fg2);
            }

            @Override
            public void onTabReselected(Tab tab, FragmentTransaction ft) {

            }
        });

        bar.addTab(tab2);

        // 默认第一个Tab处于Select
        tab1.select();

    }

    // 总是设置“more”出现在actionbar中而不是实体菜单键中
    void setOverflowShowingAlways() {
        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            menuKeyField.setAccessible(true);
            menuKeyField.setBoolean(config, false);
        } catch (Exception e) {

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // 菜单Button事件响应
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:

                return true;
            case R.id.action_settings:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
