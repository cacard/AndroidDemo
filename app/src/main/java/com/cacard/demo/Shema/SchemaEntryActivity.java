package com.cacard.demo.Shema;

import android.app.Activity;
import android.os.Bundle;

import com.cacard.demo.Util.AppUtil;

/**
 * Created by cunqingli on 2016/10/17.
 */

public class SchemaEntryActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppUtil.startApp2(this, "com.cacard.demo");

        this.finish();
    }
}
