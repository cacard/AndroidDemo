/**
 Gesture Detector
 *
 */

package com.cacard.androiddemo.activity;

import com.cacard.androiddemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class ActivityGestureDetector extends Activity {

    GestureDetector dector = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_gesture_detector);

        dector = new GestureDetector(this, new MyListener());

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return dector.onTouchEvent(event);
    }

    public static class MyListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Log.i("test", "onSingleTapUp");
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            Log.i("test", "onLongPress");
        }
    }

}
