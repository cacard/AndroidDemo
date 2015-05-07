package com.cacard.demo.FloatWindow;

import android.view.View;

/**
 * Created by cunqingli on 2015/5/7.
 */
public class FloatWindowManager {

    private View globalFloatView;
    private boolean isAddedToWindow;

    public FloatWindowManager() {
        globalFloatView = null;
        isAddedToWindow = false;
    }

    // 释放View
    public void releaseView() {
        globalFloatView = null;
        isAddedToWindow = false;
    }

    public View getGlobalFloatView() {
        return globalFloatView;
    }

    public void setGlobalFloatView(View globalFloatView) {
        this.globalFloatView = globalFloatView;
    }

    public boolean isAddedToWindow() {
        return isAddedToWindow;
    }

    public void setIsAddedToWindow(boolean isAddedToWindow) {
        this.isAddedToWindow = isAddedToWindow;
    }


}
