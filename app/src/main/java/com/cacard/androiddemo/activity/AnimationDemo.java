/**
 * 动画Demo
 * 		* ViewAnimation
 * 			* Tween 类似Flash中的补间动画
 * 				* Scale
 * 				* Route
 * 				* Alpha
 * 			* Frame 传统帧动画
 * 		* PropertyAnimation
 *
 */

package com.cacard.androiddemo.activity;

import com.cacard.androiddemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class AnimationDemo extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_animation_demo);

        testTween();
    }

    /**
     * Tween Scale/Route Demo
     */
    private void testTween() {
        // find controls
        Button btnLarge = (Button) this.findViewById(R.id.button1);
        Button btnSmall = (Button) this.findViewById(R.id.button2);
        Button btnRoute = (Button) this.findViewById(R.id.button3);
        final ImageView image = (ImageView) this.findViewById(R.id.imageView1);

        // load animations
        final Animation toSmall = AnimationUtils.loadAnimation(this, R.anim.scale_to_small);
        final Animation toLarge = AnimationUtils.loadAnimation(this, R.anim.scale_to_large);
        final Animation toRoute = AnimationUtils.loadAnimation(this, R.anim.route);

        btnSmall.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                image.startAnimation(toSmall);
            }
        });

        btnLarge.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                image.startAnimation(toLarge);
            }
        });

        btnRoute.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                image.startAnimation(toRoute);
            }
        });
    }

}
