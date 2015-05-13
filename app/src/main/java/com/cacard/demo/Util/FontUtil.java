package com.cacard.demo.Util;

import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by cunqingli on 2015/4/30.
 */
public class FontUtil {

    /**
     * 字体高度，方法#1
     *
     * @param pFont
     * @return
     */
    public static float getFontHeight(Paint pFont) {
        Rect rect = new Rect();
        pFont.getTextBounds("测试", 0, 1, rect);
        return rect.bottom - rect.top;
    }

    /**
     * 字体高度，方法#2
     *
     * @param pFont
     * @return
     */
    public static float getFontHeight2(Paint pFont) {
        Paint.FontMetrics metrics = pFont.getFontMetrics();
        return metrics.bottom - metrics.top;
    }

    /**
     * 字符串宽度，方法#1
     *
     * @param str
     * @param p
     * @return
     */
    public static float getStringWidth2(String str, Paint p) {
        return p.measureText(str);
    }

    /**
     * 字符串宽度，方法#2
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


    public static void slicingString(String str, Paint p, int lineWidth) {

    }

    public static class FontStringSlicingResult {
        public int linesCount; // 行数
    }

}
