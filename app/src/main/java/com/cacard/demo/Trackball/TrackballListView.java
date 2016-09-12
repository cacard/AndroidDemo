package com.cacard.demo.Trackball;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ListView;

/**
 * Created by cunqingli on 2016/9/12.
 */
public class TrackballListView extends ListView {
    public TrackballListView(Context context) {
        super(context);
    }

    public TrackballListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TrackballListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        Log.i(TrackballDemoActivity.TAG, "onWindowFocusChanged");

//        if (getAdapter() != null && getAdapter() instanceof TrackballAdapter) {
//            ((TrackballAdapter) getAdapter()).notifyDataSetChanged();
//            Log.i(TrackballDemoActivity.TAG, "notify @ onWindowFocusChanged");
//        }

        super.onWindowFocusChanged(hasWindowFocus);
    }
}
