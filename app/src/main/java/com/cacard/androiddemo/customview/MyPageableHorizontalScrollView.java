package com.cacard.androiddemo.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/**
 * 可分页的类似于ViewPager的HorizontalScrollView
 * - 注意页面数量和性能
 * -
 * Created by cunqingli on 2015/4/17.
 */
public class MyPageableHorizontalScrollView extends HorizontalScrollView {
    public MyPageableHorizontalScrollView(Context context) {
        super(context);
    }

    public MyPageableHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyPageableHorizontalScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
