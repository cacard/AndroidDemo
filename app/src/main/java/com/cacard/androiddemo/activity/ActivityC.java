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


}
