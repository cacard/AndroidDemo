package com.cacard.androiddemo.CustomControl.PageableHorizonalScrollView;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 自定义控件，可分页的HorizonalScrollView
 */
public class ActivityPageableHorizonalScrollView extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final int screenWidth = getWindowManager().getDefaultDisplay().getWidth();

        FrameLayout root = new FrameLayout(this);
        LinearLayout ll = new LinearLayout(root.getContext());
        ll.setOrientation(LinearLayout.HORIZONTAL);
        for (int i = 0; i < 3; i++) {
            TextView tv = new TextView(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(screenWidth, ViewGroup.LayoutParams.MATCH_PARENT);
            tv.setLayoutParams(lp);
            tv.setText("Page" + i);
            ll.addView(tv);
        }
        root.addView(ll);

        MyPageableHorizontalScrollView v = new MyPageableHorizontalScrollView(this);
        v.addView(root);

        setContentView(v);
    }
}
