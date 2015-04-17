package com.cacard.androiddemo.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

/**
 * 可分页的类似于ViewPager的HorizontalScrollView
 * - 注意页面数量和性能
 * -
 * Created by cunqingli on 2015/4/17.
 */
public class MyPageableHorizontalScrollView extends HorizontalScrollView {

    private int currentPageIndex = 0;
    private static final int PAGE_SLOT = 100;

    public MyPageableHorizontalScrollView(Context context) {
        super(context);
    }

    public MyPageableHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyPageableHorizontalScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    private float y1;

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        boolean rtn = super.onTouchEvent(ev);

        if (ev.getActionMasked() == MotionEvent.ACTION_DOWN) {
            y1 = ev.getRawY();
        }

        if (ev.getActionMasked() == MotionEvent.ACTION_MOVE) {

        }

        if (ev.getActionMasked() == MotionEvent.ACTION_UP) {
            float y2 = ev.getRawY();
            float distance = y2 - y1;
            log("distance:" + distance);

            if (Math.abs(distance) > PAGE_SLOT) {
                if (distance > 0) { // <-
                    log("<-");
                } else { // ->
                    log("->");
                }

                rtn = true;
            }
        }

        return rtn;
    }

    // 执行翻页动画
    private void preformPagerAnimation() {

    }

    private void log(String msg) {
        Log.i("lcq", msg);
    }
}
