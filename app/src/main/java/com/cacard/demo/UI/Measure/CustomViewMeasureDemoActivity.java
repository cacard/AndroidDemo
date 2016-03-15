package com.cacard.demo.UI.Measure;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

/**
 * Created by cunqingli on 2016/3/15.
 */
public class CustomViewMeasureDemoActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        case3();
    }

    private void case1() {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        // #1 wrap_content，AT_MOST，会在默认值和传入值选取小的。
        CustomView4Measure view1 = new CustomView4Measure(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        view1.setLayoutParams(lp);
        view1.setBackgroundColor(Color.RED);


        layout.addView(view1);
        this.setContentView(layout);
    }

    private void case2() {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        // #2 match_parent，EXACTLY，会按传入的值走，其实就是父容器的size。
        CustomView4Measure view2 = new CustomView4Measure(this);
        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        view2.setLayoutParams(lp2);
        view2.setBackgroundColor(Color.BLACK);


        layout.addView(view2);


        this.setContentView(layout);
    }

    private void case3() {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        // #3 match_parent，EXACTLY精确值，会按传入的值走，
        CustomView4Measure view3 = new CustomView4Measure(this);
        LinearLayout.LayoutParams lp3 = new LinearLayout.LayoutParams(100, 100);
        view3.setLayoutParams(lp3);
        view3.setBackgroundColor(Color.BLUE);

        layout.addView(view3);

        this.setContentView(layout);
    }
}
