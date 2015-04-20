package com.cacard.androiddemo.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by cunqingli on 2015/4/20.
 */
public class MySimpleTextView4Scroller extends TextView {
    public MySimpleTextView4Scroller(Context context) {
        super(context);
    }

    public MySimpleTextView4Scroller(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MySimpleTextView4Scroller(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
    }
}
