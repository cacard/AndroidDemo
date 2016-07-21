package com.cacard.demo.Animator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

import com.cacard.demo.R;

/**
 * Created by cunqingli on 2016/7/9.
 */
public class ActivityAnimateRotate extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_animate_rotate);

        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });

    }

    private void start() {
        ImageView logo = (ImageView) findViewById(R.id.logo);

        final int w = logo.getMeasuredWidth();
        final int h = logo.getMeasuredHeight();

        Log.i("rotate", "w:" + w + "/h:" + h);

        logo.setPivotX(0);
        logo.setPivotY(h);

        //logo.setAlpha(0);
        //logo.setVisibility(View.VISIBLE);

        Animator anim1 = ObjectAnimator.ofFloat(logo, "alpha", 0.0f, 1.0f);
        Animator anim2 = ObjectAnimator.ofFloat(logo, "rotation", -40, 0);
        anim1.setInterpolator(new OvershootInterpolator());
        AnimatorSet set = new AnimatorSet();
        set.play(anim1).with(anim2);
        set.setDuration(500);
        set.start();
    }
}
