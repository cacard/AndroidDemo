/**
 * Scroll滑动
 *
 *
 */

package com.cacard.androiddemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.widget.Button;
import android.widget.LinearLayout;

import com.cacard.androiddemo.R;

public class ActivityScrollDemo extends Activity {

    private Button btn1 = null;
    private Button btn2 = null;
    private LinearLayout layout = null;
    private View view = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_scroll_demo);

        btn1 = (Button) this.findViewById(R.id.btn1);
        btn2 = (Button) this.findViewById(R.id.btn2);
        layout = (LinearLayout) this.findViewById(R.id.layout);
        view = this.findViewById(R.id.view);

        btn1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                view.scrollBy(10, 0);
            }
        });
        btn2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                view.scrollBy(-10, 0);
            }
        });

        view.addOnLayoutChangeListener(new OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                Log.i("test", "l,t,r,b,old l/t/r/b" + left + "," + top + "," + right + "," + bottom + "," + oldLeft + "," + oldTop + "," + oldRight + "," + oldBottom);

            }
        });


    }

}
