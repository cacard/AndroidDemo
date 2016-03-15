package com.cacard.demo.UI.Measure;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by cunqingli on 2016/3/15.
 */
public class CustomView4Measure extends View {

    private static final String TAG = "CustomView4Measure";

    public CustomView4Measure(Context context) {
        super(context);
    }

    public CustomView4Measure(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView4Measure(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //由于要自定义测量，所有要注释掉对super的调用了。
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        final int measuredWidth = measureWidth(widthMeasureSpec);
        final int measuredHeight = measureHeight(heightMeasureSpec);
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    /**
     * 获取Width的测量值
     *
     * @param widthMeasureSpec
     * @return
     */
    private int measureWidth(int widthMeasureSpec) {
        final int widthDefault = 200;
        final int result;
        final int mode = MeasureSpec.getMode(widthMeasureSpec);
        final int width = MeasureSpec.getSize(widthMeasureSpec);

        if (mode == MeasureSpec.EXACTLY) { // EXACTLY情况下，直接返回传入的size
            result = width;
        } else if (mode == MeasureSpec.AT_MOST) { // AT_MOST的情况下，可以直接返回传入的size，但如果有默认值，要取两者最小值。
            result = Math.min(widthDefault, width);
        } else { // UNSPECIFIED，任意指定！
            result = widthDefault;
        }

        return result;
    }

    /**
     * 获取width的测量值
     *
     * @param heightMeasureSpec
     * @return
     */
    private int measureHeight(int heightMeasureSpec) {
        final int hDefault = 200;
        final int result;
        final int mode = MeasureSpec.getMode(heightMeasureSpec);
        final int h = MeasureSpec.getSize(heightMeasureSpec);

        if (mode == MeasureSpec.EXACTLY) {
            result = h;
        } else if (mode == MeasureSpec.AT_MOST) {
            result = Math.min(h, hDefault);
        } else { // UNSPECIFIED，任意指定！
            result = hDefault;
        }

        return result;
    }
}
