package com.cacard.androiddemo.ViewDragHelperDemo;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;


public class ContainerUsingLinearLayout extends LinearLayout {

    private ViewDragHelper vdh;


    public ContainerUsingLinearLayout(Context context) {
        super(context);
        init();
    }

    public ContainerUsingLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ContainerUsingLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ContainerUsingLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        vdh = ViewDragHelper.create(this/* 被拖动View的父亲(ViewGroup) */, 1.0f/* 灵敏度，一般就设置为这个值 */, new VDHCallback());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        vdh.processTouchEvent(event);
        return true;
    }

    // 扩展 ViewDragHelper的Callback
    private class VDHCallback extends ViewDragHelper.Callback {


        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return true;
        }

        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            //return super.clampViewPositionHorizontal(child, left, dx);
            Log.i("vdh", "->clampViewPositionHorizontal(),left:" + left + "/dx:" + dx);
            //return left;

            // 边界检查
            if (left < getPaddingLeft()) {
                return getPaddingLeft();
            }
            int maxLeft = getWidth() - child.getWidth();
            if (left > maxLeft) {
                return maxLeft;
            }

            return left;
        }

        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            //return super.clampViewPositionVertical(child, top, dy);
            Log.i("vdh", "->clampViewPositionVertical(),top:" + top + "/dx:" + dy);

            // TODO 边界检查，防止拖动到窗口外部
            return top;
        }

        @Override
        public void onViewDragStateChanged(int state) {
            switch (state) {
                case ViewDragHelper.STATE_DRAGGING:  // 正在被拖动
                    break;
                case ViewDragHelper.STATE_IDLE:  // view没有被拖拽或者 正在进行fling/snap
                    break;
                case ViewDragHelper.STATE_SETTLING: // fling完毕后被放置到一个位置
                    break;
            }
            super.onViewDragStateChanged(state);
        }
    }
}
