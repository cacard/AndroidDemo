package com.cacard.demo.Animator;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.cacard.demo.R;

/**
 * ValueAnimator、ObjectAnimator演示
 */
public class ActivityValueAnimator extends Activity {

    private static String TAG = "ActivityValueAnimator";
    private TextView tvHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_value_animator);
        tvHello = (TextView) this.findViewById(R.id.tvHello);
        startObjectAnimator();
    }

    /**
     * ValueAnimator，仅仅是对Value在一段时间内进行范围变化。可使用updateListener中更新view
     */
    private void startValueAnimator() {
        final int width = tvHello.getLayoutParams().width;
        Log.i(TAG, "init width:" + width);
        final ValueAnimator valueAnimator = ValueAnimator.ofInt(1, 500);

        // 默认为间隔10ms触发该监听
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                final Integer value = (Integer) valueAnimator.getAnimatedValue();
                Log.i(TAG, "onAnimationUpdate,value:" + valueAnimator.getAnimatedValue() + "");
                tvHello.getLayoutParams().width = width + value;
                tvHello.requestLayout();
            }
        });

        valueAnimator.setDuration(5 * 1000);
        valueAnimator.start();
    }

    /**
     * ObjectAnimator，全自动更新Object的某个属性
     */
    private void startObjectAnimator() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tvHello, "alpha", 1.0f, 0f);
        objectAnimator.setDuration(5000);
        objectAnimator.start();
    }
}
