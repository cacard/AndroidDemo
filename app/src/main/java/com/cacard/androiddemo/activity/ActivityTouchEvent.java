/**
 * TouchEvent测试
 *
 *
 * 事件派发原理
 *
 * - 1 事件的隧道传递，即向下派发过程。onInterceptTouchEvent可以拦截事件，如果返回true，则不再继续向下派发，默认是false，所以可以认为事件默认是一直向下派发的。
 * - 2 事件的冒泡传递，即向上传递过程。如果下层没有消费事件（即onTouchEvent返回false），则向上冒泡，直到遇到消费者(或者最后的Activity)来处理，后续动作均不再派发和冒泡，由Activty处理。
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
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActivityTouchEvent extends Activity {

    private LinearLayout view1;
    private LinearLayout view2;
    private TextView view3;
    private final String tag = "test";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_touch_event);

        // find controls
        view1 = (LinearLayout) this.findViewById(R.id.view1);
        view2 = (LinearLayout) this.findViewById(R.id.view2);
        view3 = (TextView) this.findViewById(R.id.view3);

        // add touchEvents
        view1.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i(tag, "->View1 onTouch");

                return false;
            }
        });

        view2.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i(tag, "->View2 onTouch");

                return true;
            }
        });

        view3.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i(tag, "->View3 onTouch");

                return false;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(tag, "Activity->onTouchEvent");
        return true;
    }

}
