package com.cacard.androiddemo.activity;

import android.app.Activity;
import android.os.Bundle;

import com.cacard.androiddemo.R;

/**
 * 确定一下root布局measure()函数中由父View传递过来的MeasureSpec
 * 结论：
 *
 * Created by cunqingli on 2015/4/24.
 */
public class ActivityTestRootMeasureSpec extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.test_root_measure_spec);
    }


}
