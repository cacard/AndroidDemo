
package com.cacard.androiddemo.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.Scroller;
import android.widget.TextView;

import com.cacard.androiddemo.R;

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

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
            demo1();
            return true;
        }
        return super.onTouchEvent(event);
    }

    private void demo1() {
        if (target == null) {
            return;
        }

        s = new Scroller(this);
        target.setScroller(s);

        s.forceFinished(true);
        s.startScroll(0, 0, -1200, -1200, 1000);

        target.invalidate();
    }
}
