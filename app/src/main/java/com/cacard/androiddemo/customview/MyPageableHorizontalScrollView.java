package com.cacard.androiddemo.customview;

import android.app.Application;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.Scroller;

import java.util.ServiceConfigurationError;

/**
 * Created by cunqingli on 2015/4/17.
 */
public class MyPageableHorizontalScrollView extends HorizontalScrollView {

    private int currentPageIndex = 0;
    private int pageCount = 3;
    private static final float PAGE_SLOT = 100.0f;
    private static final int PAGE_ANIMATION_TIME = 1000;
    private Scroller mScroller;
    private Context mContext;
    private int screenWidth = 0;
    private VelocityTracker tracker;

    public MyPageableHorizontalScrollView(Context context) {
        super(context);
        init(context);
    }

    public MyPageableHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyPageableHorizontalScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context ctx) {
        this.mContext = ctx;
        WindowManager wm = (WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE);
        screenWidth = wm.getDefaultDisplay().getWidth();
        mScroller = new Scroller(ctx);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    float xDown = 0;
    float xUp = 0;

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        usingFling(ev);

        return true;
    }

    float xMove = 0;
    boolean isFirstInMove = true;

    private void usingDrag(MotionEvent ev) {

        switch (ev.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                xDown = ev.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                int diff = 0;
                if (isFirstInMove) {
                    diff = (int) (ev.getX() - xDown);
                    isFirstInMove = false;
                } else {
                    diff = (int) (ev.getX() - xMove);
                }
                scrollBy(-diff, 0);
                xMove = ev.getX();
                break;
            case MotionEvent.ACTION_UP:
                if (Math.abs(xUp - xDown) > screenWidth / 2) {
                    if (xUp > xDown) {
                        prePage();
                    } else {
                        nextPage((int) (xDown - xUp));
                    }
                }
                break;
            case MotionEvent.ACTION_CANCEL:

                break;
        }
    }

    private void usingFling(MotionEvent ev) {
        super.onTouchEvent(ev);

        if (tracker == null) {
            tracker = VelocityTracker.obtain();
        }
        tracker.addMovement(ev);

        if (ev.getActionMasked() == MotionEvent.ACTION_DOWN) {
            xDown = ev.getX();
            tracker.clear();
            mScroller.abortAnimation();
        }

        if (ev.getActionMasked() == MotionEvent.ACTION_UP) {
            // diff
            xUp = ev.getX();
            final float diff = xUp - xDown;
            log("diff:" + diff);
            boolean isDistanceOK = false;
            boolean isRight = true;
            boolean isVelocityOK = false;
            if (Math.abs(diff) > PAGE_SLOT) { // ViewConfiguration.get(mContext).getScaledTouchSlop(); => px
                isDistanceOK = true;
                isRight = diff < 0;
                xDown = 0;
                xUp = 0;
            }

            // velocity
            tracker.computeCurrentVelocity(1000);
            float v = tracker.getXVelocity();
            log("velocity:" + v);
            isVelocityOK = Math.abs(v) > ViewConfiguration.get(mContext).getScaledMinimumFlingVelocity(); // 50?

            if (isDistanceOK && isVelocityOK) {
                if (isRight) {
                    nextPage();
                } else {
                    prePage();
                }

                tracker.clear();

            }

        }

        if (ev.getActionMasked() == MotionEvent.ACTION_UP) {
            releaseVelocityTracker();
        }

        if (ev.getActionMasked() == MotionEvent.ACTION_CANCEL) {
            releaseVelocityTracker();
        }
    }

    private void releaseVelocityTracker() {
        if (tracker != null) {
            tracker.clear();
            tracker.recycle();
            tracker = null;
        }
    }

    @Override
    public void computeScroll() {
        if (mScroller == null) {
            return;
        }
        if (mScroller.computeScrollOffset()) {
            final int x = mScroller.getCurrX();
            final int y = mScroller.getCurrY();
            scrollTo(x, y);
        }
    }

    private void nextPage() {
        nextPage(0);
    }

    private void nextPage(int offset) {
        if (currentPageIndex >= pageCount - 1) {
            return;
        }

        if (mScroller.computeScrollOffset()) { // flinging
            //return;

        }

        log("super.getScrollX()" + super.getScrollX());

        mScroller.forceFinished(true);
        final int currentX = super.getScrollX();// currentPageIndex * screenWidth;
        final int destX = (currentPageIndex + 1) * screenWidth - currentX;
        mScroller.startScroll(currentX, 0, destX, 0, PAGE_ANIMATION_TIME);

        invalidate();
        currentPageIndex++;
    }

    private void prePage() {
        if (currentPageIndex == 0) {
            return;
        }

        if (mScroller.computeScrollOffset()) { // flinging
            //return;
        }

        mScroller.forceFinished(true);
        final int currentX = currentPageIndex * screenWidth;
        mScroller.startScroll(currentX, 0, -screenWidth, 0, PAGE_ANIMATION_TIME);

        invalidate();
        currentPageIndex--;
    }


    private void log(String msg) {
        Log.i("lcq", msg);
    }
}
