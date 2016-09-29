//package com.cacard.demo.DesignSupportLibrary._DrawerLayout;
//
//import android.os.Bundle;
//import android.support.v4.widget.DrawerLayout;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.cacard.demo.R;
//
//import butterknife.Bind;
//import butterknife.ButterKnife;
//
///**
// * DrawerLayout 来自 v4
// * Created by cunqingli on 2015/9/17.
// */
//public class _DrawerLayoutDemoActivity extends AppCompatActivity {
//
//    private static final String TAG = "_DrawerLayoutDemoActivity";
//
//    @Bind(R.id.drawerLayout)
//    DrawerLayout drawerLayout;
//
//    @Bind(R.id.mainLayout)
//    ViewGroup mainLayout;
//
//    @Bind(R.id.drawerView)
//    ViewGroup drawerView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_drawable_left_demo);
//        ButterKnife.bind(this);
//
//        // 默认先打开DrawerView
//        drawerLayout.openDrawer(drawerView);
//        mainLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                drawerLayout.openDrawer(drawerView);
//            }
//        });
//
//        // 点击drawerView后，关闭它。
//        if (drawerView != null) {
//            drawerView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.i(TAG, "->drawerView#OnClick()");
//                    if (drawerLayout != null) {
//                        drawerLayout.closeDrawer(drawerView);
//                    }
//                }
//            });
//        }
//
//
//        // 监听DrawerView的状态
//        if (drawerLayout != null) {
//            drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
//                @Override
//                public void onDrawerSlide(View drawerView, float slideOffset) {
//                    Log.i(TAG, "->onDrawerSlide()");
//                }
//
//                @Override
//                public void onDrawerOpened(View drawerView) {
//                    Log.i(TAG, "->onDrawerOpened()");
//                }
//
//                @Override
//                public void onDrawerClosed(View drawerView) {
//                    Log.i(TAG, "->onDrawerClosed()");
//                }
//
//                @Override
//                public void onDrawerStateChanged(int newState) {
//                    Log.i(TAG, "->onDrawerStateChanged()");
//                }
//            });
//        }
//    }
//}
