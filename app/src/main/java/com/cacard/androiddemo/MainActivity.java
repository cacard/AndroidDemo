package com.cacard.androiddemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.DrawableContainer;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;

import com.cacard.androiddemo.DrawableAndImage.ShapeDrawableActivity;
import com.cacard.androiddemo.DrawableAndImage.TransitionDrawableActivity;

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

        addButton(root, "ShapeDrawable", ShapeDrawableActivity.class);
        addButton(root, "TransitionDrawable", TransitionDrawableActivity.class);

        setContentView(root);
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
}
