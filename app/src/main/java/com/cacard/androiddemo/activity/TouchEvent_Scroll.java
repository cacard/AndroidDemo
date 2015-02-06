/**
 * ScrollView如何“Intercept”触摸事件的。
 *
 */

package com.cacard.androiddemo.activity;

import com.cacard.androiddemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ScrollView;


public class TouchEvent_Scroll extends Activity {

    private ScrollView svOuter;
    private ScrollView svInner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.touch_event_scroll);

        svOuter = (ScrollView) this.findViewById(R.id.svOuter);
        svInner = (ScrollView) this.findViewById(R.id.svInner);

        svInner.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("test", "inner onTouch,event:" + event.getAction());
                return false;
            }
        });

        svOuter.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("test", "outer onTouch,event:" + event.getAction());
                return false;
            }
        });

    }

    public void btnClick(View v) {
        Log.i("test", "btnClicked");
    }

}
