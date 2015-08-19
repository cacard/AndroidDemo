package com.cacard.demo.Animator;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cacard.demo.R;

/**
 * 测试一下LinearList的android:animateLayoutChanges属性。
 * <p/>
 * Created by cunqingli on 2015/8/10.
 */
public class ActivityAnimateLayoutChanges extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_layout_chanages);
        final TextView tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setVisibility(View.GONE);
            }
        });
    }
}
