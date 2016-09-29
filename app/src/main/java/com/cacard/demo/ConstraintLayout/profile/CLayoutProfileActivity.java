package com.cacard.demo.ConstraintLayout.profile;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.cacard.demo.R;

/**
 * Created by cunqingli on 2016/9/29.
 */

public class CLayoutProfileActivity extends Activity {

    static final String TAG = "CLayout";
    static final int layoutNormal = R.layout.activity_clayout_normal;
    static final int layoutConstraint = R.layout.activity_clayout_constraint;

    long start = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        start = System.currentTimeMillis();
        setContentView(layoutConstraint);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "diff:" + (System.currentTimeMillis() - start));
    }
}
