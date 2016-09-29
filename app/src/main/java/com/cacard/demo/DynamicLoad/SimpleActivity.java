package com.cacard.demo.DynamicLoad;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by cunqingli on 2015/6/30.
 */
public class SimpleActivity extends Activity {

    private static final String TAG = "classloader";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        printClassLoaderParent();
        printSomeClassLoader();
    }

    private void printClassLoaderParent() {
        ClassLoader cl = this.getClassLoader();
        do {
            Log.i(TAG, cl.toString());
        } while ((cl = cl.getParent()) != null);
    }

    private void printSomeClassLoader() {
        log("String:" + String.class.getClassLoader().toString());
        log("Activity:" + Activity.class.getClassLoader().toString());
        log("this(Context Wrapper):" + this.getClassLoader());
    }

    private void log(String msg) {
        Log.i(TAG, msg);
    }
}
