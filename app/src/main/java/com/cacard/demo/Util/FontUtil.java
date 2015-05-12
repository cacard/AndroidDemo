package com.cacard.demo.Util;

import android.graphics.Paint;

/**
 * Created by cunqingli on 2015/4/30.
 */
public class FontUtil {

    /**
     * 字符串宽度，可以直接使用paint.measureText()
     *
     * @param str
     * @param p
     * @return
     */
    public static float getStringWidth(String str, Paint p) {
        float[] widths = new float[str.length()];
        p.getTextWidths(str, widths);
        float w = 0;
        for (float f : widths) {
            w += f;
        }

        return w;
    }

    /**
     * 字符串宽度
     *
     * @param str
     * @param p
     * @return
     */
    public static float getStringWidth2(String str, Paint p) {
        return p.measureText(str);
    }

    public static void slicingString(String str,Paint p,int lineWidth) {

    }

    public static class FontStringSlicingResult {
        public int linesCount; // 行数
    }

}
