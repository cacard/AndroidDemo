package com.cacard.demo.CustomView.Flat;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.cacard.demo.R;

/**
 * 完全使用Draw实现的自定义控件
 * <p/>
 * - width可以是match_parent，可定；但是height呢？只有在onDraw()完成后才知道具体的高度，如何确定View的height呢？
 * <p/>
 * Created by cunqingli on 2015/5/12.
 */
public class SimpleActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("使用Canvas的自定义控件Demo");

        RelativeLayout ll = new RelativeLayout(this);

        MyView v = new MyView(this);
        v.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        v.setBackgroundColor(Color.GRAY);

        ll.addView(v);
        this.setContentView(ll);

    }

    public static class MyView extends View {

        private Context mContext;

        private int imageLeftResId = R.drawable.user_logo;
        private Bitmap bitmapImageLeft;
        private int imageBtn1ResId = R.drawable.write1;
        private Bitmap bitmapBtn1;
        private int imageBtn2ResId = R.drawable.write2;
        private Bitmap bitmapBtn2;
        private Paint paintBimap = new Paint(Paint.ANTI_ALIAS_FLAG);

        private String title = "新闻哥";
        private int titleFrontSize = 50; // sp to px
        private Paint paintTitle;

        private String desc = "文字比较长，有可能换行，文字比较长，有可能换行，文字比较长，有可能换行，文字比较长，有可能换行，字比较长，有可能换行，字比较长，有可能换行，字比较长，有可能换行，字比较长，有可能换行，字比较长，有可能换行，字比较长，有可能换行，字比较长，有可能换行，字比较长，有可能换行，字比较长，有可能换行，";
        private int descFontSize = 90;
        private Paint paintDesc;
        private float[] descWidths = new float[desc.length()];
        private float descFontHeight = 0;
        private int width4Text;

        public MyView(Context context) {
            super(context);
            mContext = context;

            paintTitle = new Paint(Paint.ANTI_ALIAS_FLAG);
            paintTitle.setColor(Color.BLACK);
            paintTitle.setTextSize(titleFrontSize);

            paintDesc = new Paint(Paint.ANTI_ALIAS_FLAG);
            paintDesc.setColor(Color.BLACK);
            paintDesc.setTextSize(descFontSize);

        }

        /**
         * 在这里确定测量好要绘制的内容的总宽高
         *
         * @param widthMeasureSpec
         * @param heightMeasureSpec
         */
        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            //super.onMeasure(widthMeasureSpec, heightMeasureSpec);

            final int w = MeasureSpec.getSize(widthMeasureSpec);
            int maxH = 0;

            bitmapImageLeft = BitmapFactory.decodeResource(mContext.getResources(), imageLeftResId);
            bitmapBtn1 = BitmapFactory.decodeResource(mContext.getResources(), imageBtn1ResId);
            bitmapBtn2 = BitmapFactory.decodeResource(mContext.getResources(), imageBtn2ResId);


            width4Text = w - (bitmapImageLeft.getWidth() + bitmapBtn1.getWidth() + bitmapBtn2.getWidth());

            float descWidth = paintDesc.measureText(desc);
            Rect r = new Rect();
            paintDesc.getTextBounds("测", 0, 1, r);
            paintDesc.getTextWidths(desc, descWidths);
            int descCharacterHeight = r.bottom - r.top;
            int descLines = (int) Math.ceil((double) (descWidth / width4Text));
            int textHeight = descCharacterHeight * descLines;
            descFontHeight = descCharacterHeight;

            // max height
            maxH = bitmapImageLeft.getHeight() > maxH ? bitmapImageLeft.getHeight() : maxH;
            maxH = bitmapBtn1.getHeight() > maxH ? bitmapBtn1.getHeight() : maxH;
            maxH = bitmapBtn2.getHeight() > maxH ? bitmapBtn2.getHeight() : maxH;
            maxH = textHeight > maxH ? textHeight : maxH;


            setMeasuredDimension(w, maxH);

        }

        @Override
        protected void onDraw(Canvas canvas) {
            final int w = getMeasuredWidth();
            final int h = getMeasuredHeight();
            log("w:" + w + "/h:" + h);

            // left image
            canvas.drawBitmap(bitmapImageLeft, 0, 0, paintBimap);

            // right image
            canvas.drawBitmap(bitmapBtn2, w - bitmapBtn2.getWidth(), 0, paintBimap);
            canvas.drawBitmap(bitmapBtn1, w - bitmapBtn2.getWidth() - bitmapBtn1.getWidth(), 0, paintBimap);

            // text
            canvas.save();
            canvas.translate(bitmapImageLeft.getWidth(), 0);

            // TODO 性能、策略优化
            float wTemp = 0;
            float xTemp = 0;
            float yTemp = descFontHeight;
            char[] chars = desc.toCharArray();
            for (int i = 0; i < descWidths.length; i++) {
                float nextX = xTemp + descWidths[i];
                if (nextX < width4Text) {
                    canvas.drawText(chars, i, 1, xTemp, yTemp, paintDesc);
                    xTemp = nextX;
                } else {
                    xTemp = 0;
                    yTemp += descFontHeight;
                }
            }

        }


        private void log(String msg) {
            Log.i("SimpeView", msg);
        }
    }
}
