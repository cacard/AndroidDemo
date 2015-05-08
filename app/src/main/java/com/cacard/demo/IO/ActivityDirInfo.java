package com.cacard.demo.IO;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


/**
 * Created by cunqingli on 2015/5/7.
 */
public class ActivityDirInfo extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Dir Info");

        TextView tvLog = new TextView(this);

        setContentView(tvLog);

        String msg = "";


    }


}
