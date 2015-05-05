
package com.cacard.demo.Animator;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Scroller;
import android.widget.TextView;

import com.cacard.demo.R;

/**
 * 使用Scroller实现滑动动画
 * <p/>
 * - 不好的一点是，必须使用自定义View实现computeScroll()方法
 * - TextView本身支持Scroller
 */
public class ActivityScrollerDemo extends Activity {

    private TextView target;
    Scroller s;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_scroller_demo);
        target = (TextView) this.findViewById(R.id.target);

        Button btnFling = (Button) findViewById(R.id.btnFling);
        btnFling.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                flingDemo();
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
            scrollDemo();
            return true;
        }
        return super.onTouchEvent(event);
    }

    /**
     * Scroll
     */
    private void scrollDemo() {
        if (target == null) {
            return;
        }

        s = new Scroller(this);
        target.setScroller(s);

        s.forceFinished(true);
        s.startScroll(0, 0, -1200, -1200, 1000);

        target.invalidate();
    }

    /**
     * Flinging
     */
    private void flingDemo() {
        if (target == null) {
            return;
        }
        if (s == null) {
            s = new Scroller(this);
        }
        target.setScroller(s);
        s.forceFinished(true);
        s.fling(0, 0, 10/* velocityX */, 0, 100/* minX */, 1000/* maxY */, 0, 0);

    }

    private void overScorllerDemo() {

    }


}
