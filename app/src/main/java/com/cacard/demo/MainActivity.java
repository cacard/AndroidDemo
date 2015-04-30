package com.cacard.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.cacard.demo.Animator.ActivityValueAnimator;
import com.cacard.demo.Canvas.CanvasDemoActivity;
import com.cacard.demo.Drawable.ShapeDrawableActivity;
import com.cacard.demo.Drawable.TransitionDrawableActivity;
import com.cacard.demo.GestureDetectorDemo.GestureDetectorDemoActivity;
import com.cacard.demo.ViewDragHelperDemo.VDHActivity;
import com.cacard.demo.launchmode.SingleInstance.Activity0;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setTitle("Main Activity");

        generateMenu();

    }

    // 各个子Demo入口
    private void generateMenu() {
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);

        addButton(root, "ShapeDrawable", ShapeDrawableActivity.class);
        addButton(root, "TransitionDrawable", TransitionDrawableActivity.class);

        addButton(root, "ValueAnimator", ActivityValueAnimator.class);

        addButton(root, "ViewDragHelper", VDHActivity.class);
        addButton(root, "GestureDetectory", GestureDetectorDemoActivity.class);

        addButton(root, "LaunchMode-SingleInstance", Activity0.class);

        addButton(root, "Canvas", CanvasDemoActivity.class);

        ScrollView sv = new ScrollView(this);
        sv.addView(root);

        setContentView(sv);
    }

    private void addButton(ViewGroup root, String text, final Class<?> clazz) {
        Button btn = new Button(this);
        btn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        btn.setText(text);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, clazz));
            }
        });
        root.addView(btn);
    }


    private void log(String msg) {
        Log.i("lcq", msg);
    }

    /**
     * 监视ViewThree
     */
    private void addViewThreeObServer(View v) {
        if (v == null) {
            return;
        }

        ViewTreeObserver ob = v.getViewTreeObserver();
        if (ob == null) {
            return;
        }

        if (ob.isAlive()) {
            ob.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    log("->ob.addOnGlobalLayoutListener");
                }
            });
        }
    }

    private void getRootView() {
        ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0);
        getWindow().getDecorView().findViewById(android.R.id.content);
    }
}
