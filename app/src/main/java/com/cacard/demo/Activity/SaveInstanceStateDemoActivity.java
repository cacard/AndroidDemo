package com.cacard.demo.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

/**
 * Created by cunqingli on 2016/2/25.
 */
public class SaveInstanceStateDemoActivity extends Activity {

    private static final String TAG = "SaveInstanceStateDemoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }
}
