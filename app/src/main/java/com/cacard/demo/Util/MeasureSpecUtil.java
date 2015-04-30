package com.cacard.demo.Util;

import android.view.View;

/**
 * Created by cunqingli on 2015/4/24.
 */
public class MeasureSpecUtil {

    public static String getModeString(int modeValue) {
        String rtn = "UNKOWN";

        int mode = View.MeasureSpec.getMode(modeValue);

        switch (mode) {
            case View.MeasureSpec.EXACTLY:
                rtn = "EXACTLY";
                break;
            case View.MeasureSpec.AT_MOST:
                rtn = "AT_MOST";
                break;
            case View.MeasureSpec.UNSPECIFIED:
                rtn = "UNSPECIFIED";
                break;
        }

        return rtn;
    }

}
