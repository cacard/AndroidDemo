package com.cacard.demo.UI.View;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.cacard.demo.R;

/**
 * Created by cunqingli on 2016/3/4.
 */
public class TestViewGroupLayoutParamsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view_group_layout_params);

        final FrameLayout fl1 = (FrameLayout) findViewById(R.id.layout1);
        final FrameLayout fl2 = (FrameLayout) findViewById(R.id.layout2);
        final FrameLayout fl3 = (FrameLayout) getLayoutInflater().inflate(R.layout.test_view, null);

        fl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //((ViewGroup) fl1.getParent()).removeView(fl2);
                fl1.addView(fl3);
            }
        });
    }
}
