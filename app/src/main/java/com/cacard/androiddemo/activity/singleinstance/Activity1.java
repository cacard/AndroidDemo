package com.cacard.androiddemo.activity.singleinstance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

/**
 * Created by cunqingli on 2015/4/13.
 */
public class Activity1 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Activity1");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            startActivity(new Intent(this, Activity2.class));
            return true;
        }
        return super.onTouchEvent(event);
    }
}
