package com.cacard.androiddemo.activity.ui;

import com.cacard.androiddemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ActivityViewPosition extends Activity {

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        this.setContentView(R.layout.activity_view_position);
        View v = this.findViewById(R.id.v);
        testPosition(v);

    }

    public void testPosition(final View view) {

        //view.post(new Runnable() {
        //@Override
        //public void run() {
        int[] locWin = new int[]{0, 0};
        view.getLocationInWindow(locWin);

        int[] locScreen = new int[]{0, 0};
        view.getLocationOnScreen(locScreen);

        Log.i("test",
                "x=" + view.getX() + "/y=" + view.getY() + "/top="
                        + view.getTop() + "/bottom=" + view.getBottom()
                        + ",locationInWindow:" + locWin[0] + "/" + locWin[1]
                        + ",locationOnScreen:" + locScreen[0] + "/" + locScreen[1]);
        //}
        //});

    }

}
