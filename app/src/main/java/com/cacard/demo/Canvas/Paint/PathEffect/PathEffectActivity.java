package com.cacard.demo.Canvas.Paint.PathEffect;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cacard.demo.R;

/**
 * Created by cunqingli on 2015/5/11.
 */
public class PathEffectActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(Color.BLACK);


        this.setContentView(root);

    }


    public static class MyView extends View {

        private Context mContext;

        public MyView(Context context) {
            super(context);
            this.mContext = context;
        }

        @Override
        protected void onDraw(Canvas canvas) {

        }
    }
}
