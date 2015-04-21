package com.cacard.androiddemo.event;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

import com.cacard.androiddemo.R;

/**
 * MotionEvent Testing
 */
public class ActivityMotionEvent extends Activity {

    private TextView box;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_activity_motion_event);
        box = (TextView) super.findViewById(R.id.box);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        testMultiPointer(event);
        return super.onTouchEvent(event);
    }

    private void testMultiPointer(MotionEvent e) {
        //log("count:" + e.getPointerCount());

        if (e.getAction() == MotionEvent.ACTION_DOWN) { // 1st pointer OK
            Log.i("lcq", "ACTION_DWON");
            printPointerIndexId(e);
        }
        if (e.getActionMasked() == MotionEvent.ACTION_DOWN) { // 1st pointer OK
            Log.i("lcq", "[mask]ACTION_DWON");
            printPointerIndexId(e);
        }

        if (e.getAction() == MotionEvent.ACTION_POINTER_DOWN) { // >1 pointer NO
            Log.i("lcq", "ACTION_POINTER_DOWN");
        }
        if (e.getActionMasked() == MotionEvent.ACTION_POINTER_DOWN) { // >1 pointer OK
            Log.i("lcq", "[mask]ACTION_POINTER_DOWN");
            printPointerIndexId(e);
        }

        if (e.getAction() == MotionEvent.ACTION_UP) {
            Log.i("lcq", "ACTION_UP");
        }
        if (e.getActionMasked() == MotionEvent.ACTION_UP) {
            Log.i("lcq", "[mask]ACTION_UP");
            printPointerIndexId(e);
        }

        if (e.getAction() == MotionEvent.ACTION_POINTER_UP) { // NO
            Log.i("lcq", "ACTION_POINTER_UP");
        }
        if (e.getActionMasked() == MotionEvent.ACTION_POINTER_UP) { // YES
            Log.i("lcq", "[mask]ACTION_POINTER_UP");
            printPointerIndexId(e);
        }
    }

    private void printPointerIndexId(MotionEvent e) {
        log("pointer index:" + (e.getActionIndex()));
        log("pointer id:" + (e.getPointerId(e.getActionIndex())));
    }

    private void t(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Log.i("lcq", "->" + event.getX() + "/" + event.getY());
            Log.i("lcq", "->" + event.getRawX() + "/" + event.getRawX());
            Log.i("lcq", "->" + event.getX() + "/" + event.getY());
        }
    }

    private void log(String msg) {
        Log.i("lcq", msg);
    }


}
