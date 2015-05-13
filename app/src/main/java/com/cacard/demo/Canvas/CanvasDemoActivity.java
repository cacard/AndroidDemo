package com.cacard.demo.Canvas;

import android.app.Activity;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cunqingli on 2015/4/30.
 */
public class CanvasDemoActivity extends Activity {

    private List<View> views;
    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // pages
        views = new ArrayList<View>();
        views.add(new CanvasSimple(this));
        views.add(new CanvasDrawingText(this));

        changeView(0);

        // change page when click
        View root = findViewById(android.R.id.content);
        if (root != null) {
            root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int next = currentIndex + 1;
                    if (next > views.size() - 1) {
                        next = 0;
                    }

                    changeView(next);
                    currentIndex = next;
                }
            });
        }

    }

    private void changeView(int index) {
        setContentView(views.get(index));
        setTitle(views.get(index).getClass().getSimpleName());
    }
}
