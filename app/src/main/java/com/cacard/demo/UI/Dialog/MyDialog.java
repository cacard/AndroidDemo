package com.cacard.demo.UI.Dialog;

import android.app.Dialog;
import android.content.Context;

import com.cacard.demo.R;

/**
 * Created by cunqingli on 2016/7/29.
 */
public class MyDialog extends Dialog {

    private Context mContext;

    public MyDialog(Context context) {
        super(context);
    }

    public MyDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected MyDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    private void init(Context context) {
        mContext = context;

        setContentView(R.layout.my_dialog);
    }
}
