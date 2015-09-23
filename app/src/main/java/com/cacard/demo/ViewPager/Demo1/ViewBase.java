package com.cacard.demo.ViewPager.Demo1;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by cunqingli on 2015/9/23.
 */
public class ViewBase extends FrameLayout {

    private static final String TAG = ViewBase.class.getSimpleName();
    private TextView textView;
    private String title = "ViewBase";

    public ViewBase(Context context, String text) {
        super(context);
        this.title = text;
        init(context);
    }

    public ViewBase(Context context) {
        super(context);
        init(context);
    }

    public ViewBase(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ViewBase(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    protected void onAttachedToWindow() {
        log("->onAttachedToWindow() " + title);
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        log("->onDetachedFromWindow() " + title);
        super.onDetachedFromWindow();
    }

    private void init(Context ctx) {
        textView = new TextView(ctx);
        textView.setText(title);
        this.addView(textView);
    }

    public void setTitle(String title) {
        this.textView.setText(title);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    private void log(String log) {
        Log.i(TAG, log);
    }
}
