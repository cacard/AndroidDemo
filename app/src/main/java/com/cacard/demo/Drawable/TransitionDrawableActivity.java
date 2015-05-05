package com.cacard.demo.Drawable;

import android.app.Activity;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cacard.demo.R;

/**
 * TransitionDrawable/< transition > Demo
 */
public class TransitionDrawableActivity extends Activity {

    ImageView iv;
    ImageView iv2;
    ImageView iv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        root.setDividerPadding(10);

        // image transition
        iv = new ImageView(this);
        iv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        iv.setImageResource(R.drawable.transition);
        root.addView(iv);

        // image transition 2
        iv2 = new ImageView(this);
        iv2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        iv2.setImageResource(R.drawable.transition_image);
        root.addView(iv2);

        // color transition
        iv3 = new ImageView(this);
        iv3.setLayoutParams(new LinearLayout.LayoutParams(100, 100));
        iv3.setImageResource(R.drawable.transition_color);
        root.addView(iv3);

        this.setContentView(root);
        this.setTitle("TransitionDrawable");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getActionMasked() == MotionEvent.ACTION_UP) {
            ((TransitionDrawable) iv.getDrawable()).startTransition(1000);
            ((TransitionDrawable) iv2.getDrawable()).startTransition(1000);
            ((TransitionDrawable) iv3.getDrawable()).startTransition(1000);
            return true;
        }

        return super.onTouchEvent(event);
    }


}
