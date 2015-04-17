/**
 *
 */
package com.cacard.androiddemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class ActivityC extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("test", "ActivityC.onCreate()");
        this.setTitle("C");
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        }
    }


}
