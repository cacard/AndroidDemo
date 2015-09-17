package com.cacard.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.cacard.demo.Activity.ActivityInfo;
import com.cacard.demo.Activity.ActivityScreenSize;
import com.cacard.demo.Activity.ActivitySpIODemo;
import com.cacard.demo.Activity.ActivitySpIODemo2;
import com.cacard.demo.Animator.ActivityAnimateLayoutChanges;
import com.cacard.demo.Animator.ActivityScrollerDemo;
import com.cacard.demo.Animator.ActivityValueAnimator;
import com.cacard.demo.Broadcast.ActivityRegReceiverManyTimes;
import com.cacard.demo.Canvas.EntryActivity;
import com.cacard.demo.CustomControl.PullHeader.PullHeader1Activity;
import com.cacard.demo.DesignSupportLibrary.CoornaditorLayout.CoornaditorLayoutAndFABActivity;
import com.cacard.demo.DesignSupportLibrary.FloatingActionBarDemoActivity;
import com.cacard.demo.DesignSupportLibrary.SnackBarDemoActivity;
import com.cacard.demo.DesignSupportLibrary.TextInputLayoutDemoActivity;
import com.cacard.demo.DesignSupportLibrary._ToolbarDemoActivity;
import com.cacard.demo.Drawable.ClipDrawableActivity;
import com.cacard.demo.Drawable.DrawingCacheCaptureActivity;
import com.cacard.demo.Drawable.ShapeDrawableActivity;
import com.cacard.demo.Drawable.TransitionDrawableActivity;
import com.cacard.demo.FloatWindow.ActivityFloatWindow;
import com.cacard.demo.FrescoDemo.FrescoActivity;
import com.cacard.demo.GestureDetectorDemo.GestureDetectorDemoActivity;
import com.cacard.demo.Graphic.Martix.MartixDemoActivity;
import com.cacard.demo.IO.ActivityDirInfo;
import com.cacard.demo.Intent.ImplicitIntentDemoActivity;
import com.cacard.demo.Media.ActivityAudioPlayer;
import com.cacard.demo.Media.ActivityAudioPlayerUsingService;
import com.cacard.demo.Notification.MIUIDeskIconNotificationDemoActivity;
import com.cacard.demo.RecyclerView.RecyclerViewSimpleActivity;
import com.cacard.demo.Service.BindOnCreate.BindOnCreateActivity;
import com.cacard.demo.Service.Sticky.StickyActivity;
import com.cacard.demo.System.ActivityCreatePackageContext;
import com.cacard.demo.ViewDragHelperDemo.VDHActivity;
import com.cacard.demo.launchmode.SingleInstance.Activity0;

public class ActivityMain extends Activity {

    private LinearLayout root;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setTitle("Main Activity");

        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);

        generateMenu();
    }

    /**
     * 生成各个子Demo入口菜单
     */
    private void generateMenu() {

        // Basic
        addButton(root, "ScreenInfomation", ActivityScreenSize.class);
        addButton(root, "Info", ActivityInfo.class);
        addButton(root, "DirInfo", ActivityDirInfo.class);
        addButton("ImplicitIntent", ImplicitIntentDemoActivity.class);

        // Shape
        addButton(root, "ShapeDrawable", ShapeDrawableActivity.class);
        addButton(root, "ClipDrawable", ClipDrawableActivity.class);
        addButton(root, "TransitionDrawable", TransitionDrawableActivity.class);
        addButton(root, "Using Drawing Cache to Caputre", DrawingCacheCaptureActivity.class);
        addButton(root, "ValueAnimator", ActivityValueAnimator.class);
        addButton(root, "List条目的动画", ActivityAnimateLayoutChanges.class);
        addButton(root, "Scroller", ActivityScrollerDemo.class);

        addButton(root, "ViewDragHelper", VDHActivity.class);
        addButton(root, "GestureDetectory", GestureDetectorDemoActivity.class);

        addButton(root, "LaunchMode-SingleInstance", Activity0.class);

        addButton(root, "Canvas/", EntryActivity.class);

        addButton(root, "SpSpeed", ActivitySpIODemo.class);
        addButton(root, "SpSpeed2", ActivitySpIODemo2.class);

        addButton(root, "AudioPlayer", ActivityAudioPlayer.class);
        addButton(root, "AudioPlayerUsingService", ActivityAudioPlayerUsingService.class);

        addButton(root, "FloatWindow", ActivityFloatWindow.class);
        addButton(root, "MIUIDeskIconNotification", MIUIDeskIconNotificationDemoActivity.class);

        addButton(root, "Service/StickyService", StickyActivity.class);
        addButton(root, "Service/BindOnCreateService", BindOnCreateActivity.class);

        addButton(root, "Fresco", FrescoActivity.class);

        addButton(root, "Martix", MartixDemoActivity.class);
        addButton(root, "PullHeader #1", PullHeader1Activity.class);

        addButton(root, "RecyclerView/SimpleDemo", RecyclerViewSimpleActivity.class);

        addButton(root, "Broadcast/RegManyTimes", ActivityRegReceiverManyTimes.class);

        addButton(root, "System/createPackageContext", ActivityCreatePackageContext.class);

        // android design support library
        addButton("DSL/SnackBar", SnackBarDemoActivity.class);
        addButton("DSL/TextInputLayout", TextInputLayoutDemoActivity.class);
        addButton("DSL/FloatingActionBarDemoActivity",FloatingActionBarDemoActivity.class);
        addButton("DSL/CoorditorLayoutAndFab", CoornaditorLayoutAndFABActivity.class);
        addButton("DSL/Toolbar",_ToolbarDemoActivity.class);

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
                ActivityMain.this.startActivity(new Intent(ActivityMain.this, clazz));
            }
        });
        root.addView(btn);
    }

    private void addButton(String text, final Class<?> clazz) {
        addButton(root, text, clazz);
    }
}
