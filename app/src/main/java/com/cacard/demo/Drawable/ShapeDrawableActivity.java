package com.cacard.demo.Drawable;

import android.app.Activity;
import android.graphics.drawable.ShapeDrawable;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cacard.demo.R;

/**
 * Created by cunqingli on 2015/4/28.
 */
public class ShapeDrawableActivity extends Activity {

    private ImageView imgRing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_shape);
        imgRing = (ImageView) findViewById(R.id.imgRing);

    }


}
