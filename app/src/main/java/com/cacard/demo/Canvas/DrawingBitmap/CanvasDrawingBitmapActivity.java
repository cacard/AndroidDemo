package com.cacard.demo.Canvas.DrawingBitmap;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;

/**
 * Created by cunqingli on 2015/5/11.
 */
public class CanvasDrawingBitmapActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static class CanvasDrawingBitmapView extends View {
        public CanvasDrawingBitmapView(Context context) {
            super(context);
        }


        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
        }
    }
}
