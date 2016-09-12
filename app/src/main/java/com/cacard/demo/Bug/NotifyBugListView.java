package com.cacard.demo.Bug;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ListView;

/**
 * Created by cunqingli on 2016/9/8.
 */
public class NotifyBugListView extends ListView {

    private final String TAG = "NotifyBugListView";

    public NotifyBugListView(Context context) {
        super(context);
    }

    public NotifyBugListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NotifyBugListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        // measure时已经更新了 mItemCount
        // mItemCount = mAdapter == null ? 0 : mAdapter.getCount();

        // measure之后更改一下adapter的数据，触发一下
//        if (getAdapter() != null && getAdapter() instanceof ListViewNotifyBugAdapter) {
//            ((ListViewNotifyBugAdapter) getAdapter()).getData().add("from measure");
//            //((ListViewNotifyBugAdapter) getAdapter()).notifyDataSetChanged();
//        }

    }


    @Override
    protected void layoutChildren() {
//        try {
        super.layoutChildren();
//        } catch (IllegalStateException e) {
//            e.printStackTrace();
//            if (getAdapter() != null && getAdapter() instanceof BaseAdapter) {
//                ((BaseAdapter) getAdapter()).notifyDataSetChanged();
//                requestLayout();
//            }
//        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {

        if (getAdapter() != null && getAdapter() instanceof ListViewNotifyBugAdapter) {
            ((ListViewNotifyBugAdapter) getAdapter()).getData().add("from onWindowFocusChanged");
            //((ListViewNotifyBugAdapter) getAdapter()).notifyDataSetChanged();
        }


        super.onWindowFocusChanged(hasWindowFocus);
        Log.i(TAG, "onWindowFocusChanged:" + isFocused());
    }
}
