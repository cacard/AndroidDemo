package com.cacard.demo.Canvas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.cacard.demo.Activity.ActivityScreenSize;
import com.cacard.demo.Activity.ActivitySpIODemo;
import com.cacard.demo.Activity.ActivitySpIODemo2;
import com.cacard.demo.Animator.ActivityScrollerDemo;
import com.cacard.demo.Animator.ActivityValueAnimator;
import com.cacard.demo.Canvas.DrawingText.DrawingOneByOneOrDrawingStringActivity;
import com.cacard.demo.Canvas.DrawingText.FontMetricsDemoActivity;
import com.cacard.demo.Canvas.Paint.ColorFilter.ColorMatrixColorFilterDemoActivity;
import com.cacard.demo.Canvas.Paint.MaskFilter.MaskFilterDemoActivity;
import com.cacard.demo.Canvas.Paint.PathEffect.PathEffectActivity;
import com.cacard.demo.Canvas.Paint.Shader.ShaderActivity;
import com.cacard.demo.CustomView.Flat.SimpleActivity;
import com.cacard.demo.Drawable.ClipDrawableActivity;
import com.cacard.demo.Drawable.DrawingCacheCaptureActivity;
import com.cacard.demo.Drawable.ShapeDrawableActivity;
import com.cacard.demo.Drawable.TransitionDrawableActivity;
import com.cacard.demo.FloatWindow.ActivityFloatWindow;
import com.cacard.demo.GestureDetectorDemo.GestureDetectorDemoActivity;
import com.cacard.demo.IO.ActivityDirInfo;
import com.cacard.demo.Media.ActivityAudioPlayer;
import com.cacard.demo.Media.ActivityAudioPlayerUsingService;
import com.cacard.demo.ViewDragHelperDemo.VDHActivity;
import com.cacard.demo.launchmode.SingleInstance.Activity0;

/**
 * Created by cunqingli on 2015/5/13.
 */
public class EntryActivity extends Activity {

    private LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Demo/Canvas");

        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);

        addButton("Canvas/", CanvasDemoActivity.class);

        // Canvas Operations
        addButton("Layer分层", CanvasLayerActivity.class);
        addButton("Operation/Translate...", CanvasOperationActivity.class);

        // Paint
        addButton("Paint/ColorMatrixColorFilter", ColorMatrixColorFilterDemoActivity.class);
        addButton("Paint/MaskFilter", MaskFilterDemoActivity.class);
        addButton("Paint/PathEffect", PathEffectActivity.class);
        addButton("Paint/Shader", ShaderActivity.class);

        addButton("Draw/Path", PathActivity.class);

        // Drawing Text
        addButton("Draw/Text/FontMetrics演示", FontMetricsDemoActivity.class);
        addButton("Draw/Text/逐字符和字符串绘制比较", DrawingOneByOneOrDrawingStringActivity.class);


        // Controls
        addButton("CycleProgress", CycleProgressViewActivity.class);
        addButton("MusicWave", MusicWaveAnimationActivity.class);
        addButton("FlashDot", FlashDotDemoActivity.class);

        // CustomView
        addButton("CustomView/Flat/Simple", SimpleActivity.class);

        ScrollView sv = new ScrollView(this);
        sv.addView(root);
        setContentView(sv);

    }

    private void addButton(String text, final Class<?> clazz) {
        Button btn = new Button(this);
        btn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        btn.setText(text);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EntryActivity.this.startActivity(new Intent(EntryActivity.this, clazz));
            }
        });
        root.addView(btn);
    }


}
