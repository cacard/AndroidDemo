package com.cacard.androiddemo.DrawableAndImage;

import android.app.Activity;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cacard.androiddemo.R;

/**
 * TransitionDrawable/< transition > Demo
 */
public class TransitionDrawableActivity extends Activity {

    ImageView iv;
    ImageView iv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);

        // image transition
        iv = new ImageView(this);
        iv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        iv.setImageResource(R.drawable.transition);
        root.addView(iv);

        // color transition
        iv2 = new ImageView(this);
        iv2.setLayoutParams(new LinearLayout.LayoutParams(100, 100));
        iv2.setImageResource(R.drawable.transition_color);
        root.addView(iv2);

        this.setContentView(root);
        this.setTitle("TransitionDrawable/<transition> Demo");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getActionMasked() == MotionEvent.ACTION_UP) {
            ((TransitionDrawable) iv.getDrawable()).startTransition(1000);
            ((TransitionDrawable) iv2.getDrawable()).startTransition(1000);
            return true;
        }

        return super.onTouchEvent(event);
    }


}
