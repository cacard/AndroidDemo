package com.cacard.demo.DesignSupportLibrary._DrawerLayout;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.cacard.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by cunqingli on 2015/9/18.
 */
public class _DrawerLayoutWithToolBarActivity extends AppCompatActivity {

    @Bind(R.id.toolBar)
    Toolbar toolbar;

    @Bind(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    @Bind(R.id.mainLayout)
    ViewGroup mainLayout;

    @Bind(R.id.drawerView)
    ViewGroup drawerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout_and_tool_bar);
        ButterKnife.bind(this);

        // 将ToolBar作为ActionBar
        if (toolbar != null) {
            this.setSupportActionBar(toolbar);
            initToolBar();
        }

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                super.onDrawerStateChanged(newState);
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    private void initToolBar() {
        // navigation button
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_add);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout != null) {
                    drawerLayout.openDrawer(drawerView);
                }
            }
        });

        // title
        toolbar.setTitle("Title");

        // Subtitle
        toolbar.setSubtitle("Subtitle");

        // logo
        toolbar.setLogo(android.R.drawable.ic_menu_compass);

        // right menu
        // 可在menu/main.xml里设置
        // onCreateOptionsMenu
        // onOptionsItemSelected处理点击事件

        // not work!
        //toolbar.inflateMenu(R.menu.main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // ! work
        getMenuInflater().inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
