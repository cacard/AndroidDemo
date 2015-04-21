package com.cacard.androiddemo.CustomControl.PageableHorizonalScrollView;

import android.app.Application;
import android.content.Context;
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
    private static final int PAGE_ANIMATION_TIME = 500;
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

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        releaseVelocityTracker();
    }

    float xDown = 0;
    float xUp = 0;

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        usingFling(ev);
        return true;
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
            //mScroller.abortAnimation();
            mScroller.forceFinished(true);
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
            isVelocityOK = Math.abs(v) > 1000;  // ViewConfiguration.get(mContext).getScaledMinimumFlingVelocity(); // 50?

            // fling
            if (isDistanceOK && isVelocityOK) {
                if (isRight) {
                    nextPage();
                } else {
                    prePage();
                }
                tracker.clear();
            } else { // drag
                final int currentScrollX = super.getScrollX();
                final int currentPageStartX = currentPageIndex * screenWidth;
                log("[drag]:currentScrollX=" + currentScrollX + ",currentPageStartX=" + currentPageStartX);
                if (Math.abs(currentScrollX - currentPageStartX) > screenWidth / 2) {
                    if (currentScrollX - currentPageStartX > 0) {
                        nextPage();
                    } else {
                        prePage();
                    }
                } else {
                    toCurrentPageStart();
                }
            }

        }

        if (ev.getActionMasked() == MotionEvent.ACTION_UP) {
            tracker.clear();
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
        if (mScroller == null || mScroller.isFinished()) {
            return;
        }
        if (mScroller.computeScrollOffset()) {
            final int x = mScroller.getCurrX();
            final int y = mScroller.getCurrY();
            scrollTo(x, y);
        }
    }

    private void nextPage() {
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
        final int currentX = super.getScrollX();
        final int destX = currentX - (currentPageIndex - 1) * screenWidth;
        mScroller.startScroll(currentX, 0, -destX, 0, PAGE_ANIMATION_TIME);

        invalidate();
        currentPageIndex--;
    }

    private void toCurrentPageStart() {
        final int currentScorllX = super.getScrollX();
        final int currentPageStart = currentPageIndex * screenWidth;
        mScroller.forceFinished(true);
        mScroller.startScroll(currentScorllX, 0, currentPageStart - currentScorllX, 0, PAGE_ANIMATION_TIME); // TODO change time with distance
        invalidate();
    }


    private void log(String msg) {
        Log.i("lcq", msg);
    }
}
