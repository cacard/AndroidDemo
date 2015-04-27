package com.cacard.androiddemo.CustomControl;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import com.cacard.androiddemo.util.MeasureSpecUtil;

/**
 * Created by cunqingli on 2015/4/24.
 */
public class MySimpleTextView extends TextView {

    private static final String TAG = "MySimpleTextView";

    public MySimpleTextView(Context context) {
        super(context);
    }

    public MySimpleTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MySimpleTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MySimpleTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int wMode = MeasureSpec.getMode(widthMeasureSpec);
        int w = MeasureSpec.getSize(widthMeasureSpec);

        Log.i("lcq", TAG + "->onMeasure(),widthMode:" + MeasureSpecUtil.getModeString(wMode) + "/with:" + w);
    }
}
