package com.cacard.demo.ViewDragHelperDemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * ViewDragHelper演示
 * <p/>
 * Created by cunqingli on 2015/4/22.
 */
public class VDHActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Activity的根布局
        RelativeLayout root = new RelativeLayout(this);

        // Container内部View1
        TextView tv = new TextView(this);
        tv.setText("Hello");
        tv.setBackgroundColor(Color.parseColor("#ff0000"));
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(200, 200);
        tv.setLayoutParams(lp);

        // Container内部View2
        TextView tv2 = new TextView(this);
        tv2.setText("Hello2");
        tv2.setBackgroundColor(Color.parseColor("#ffff00"));
        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(300, 300);
        lp2.setMargins(300, 300, 0, 0);
        tv2.setLayoutParams(lp2);

        // VDH作用的Container，必须是一个ViewGroup
        ContainerUsingLinearLayout container = new ContainerUsingLinearLayout(this);
        RelativeLayout.LayoutParams lpContainer = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        container.setLayoutParams(lpContainer);
        container.setBackgroundColor(Color.parseColor("#00ffff"));
        container.addView(tv);
        container.addView(tv2);

        this.setContentView(container);
    }
}
