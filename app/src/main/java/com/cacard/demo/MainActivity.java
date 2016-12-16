package com.cacard.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.cacard.demo.AIDL.add.MyAddServiceClientActivity;
import com.cacard.demo.Activity.ActivityAbsPosition;
import com.cacard.demo.Activity.ActivityInfo;
import com.cacard.demo.Activity.ActivityScreenSize;
import com.cacard.demo.Activity.ActivitySpIODemo;
import com.cacard.demo.Activity.ActivitySpIODemo2;
import com.cacard.demo.Activity.NoRegisterActivity;
import com.cacard.demo.AndroidN.Notification.AndroidNNotificationActivity;
import com.cacard.demo.Animator.ActivityAnimateLayoutChanges;
import com.cacard.demo.Animator.ActivityAnimateRotate;
import com.cacard.demo.Animator.ActivityScrollerDemo;
import com.cacard.demo.Animator.ActivityValueAnimator;
import com.cacard.demo.Broadcast.ActivityRegReceiverManyTimes;
import com.cacard.demo.Bug.ListViewNotifyBugActivity;
import com.cacard.demo.Camera.CameraSimpleActivity;
import com.cacard.demo.Canvas.EntryActivity;
import com.cacard.demo.ConstraintLayout.CLayoutChainActivity;
import com.cacard.demo.ConstraintLayout.ConstranitLayoutDemoActivity;
import com.cacard.demo.ConstraintLayout.profile.CLayoutProfileActivity;
import com.cacard.demo.CustomControl.PullHeader.PullHeader1Activity;
import com.cacard.demo.DesignSupportLibrary.FloatingActionBarDemoActivity;
import com.cacard.demo.DesignSupportLibrary.SnackBarDemoActivity;
import com.cacard.demo.DesignSupportLibrary.TextInputLayoutDemoActivity;
import com.cacard.demo.Drawable.BitmapMemorySizeTestActivity;
import com.cacard.demo.Drawable.ClipDrawableActivity;
import com.cacard.demo.Drawable.DrawingCacheCaptureActivity;
import com.cacard.demo.Drawable.ShapeDrawableActivity;
import com.cacard.demo.Drawable.TransitionDrawableActivity;
import com.cacard.demo.DynamicLoad.SimpleActivity;
import com.cacard.demo.Event.Intercept.demo1.InterceptDemoActivity;
import com.cacard.demo.FloatWindow.ActivityFloatWindow;
import com.cacard.demo.Fragment.A_SimpleDemo.A_FragmentStaticActivity;
import com.cacard.demo.Fragment.A_SimpleDemo.B_FragmentDynamicActivity;
import com.cacard.demo.Fragment.RetainInstance.Fragment_RetainInstance_Activity;
import com.cacard.demo.FrescoDemo.FrescoActivity;
import com.cacard.demo.GestureDetectorDemo.GestureDetectorDemoActivity;
import com.cacard.demo.Graphic.Martix.MartixDemoActivity;
import com.cacard.demo.IO.ActivityDirInfo;
import com.cacard.demo.Intent.ImplicitIntentDemoActivity;
import com.cacard.demo.Log.LogReaderActivity;
import com.cacard.demo.Media.ActivityAudioPlayer;
import com.cacard.demo.Media.ActivityAudioPlayerUsingService;
import com.cacard.demo.Messenger.MessengerDemoActivity;
import com.cacard.demo.Notification.MIUIDeskIconNotificationDemoActivity;
import com.cacard.demo.Parcel.ParcelNullUnmashall.ActivityFirst;
import com.cacard.demo.Parcel.ParcelSaveToDBActivity;
import com.cacard.demo.Service.BindOnCreate.BindOnCreateActivity;
import com.cacard.demo.Service.Sticky.StickyActivity;
import com.cacard.demo.System.ActivityCpuInfo;
import com.cacard.demo.System.ActivityCreatePackageContext;
import com.cacard.demo.Trackball.TrackballDemoActivity;
import com.cacard.demo.UI.ClipToPaddingDemoActivity;
import com.cacard.demo.UI.Measure.CustomViewMeasureDemoActivity;
import com.cacard.demo.UI.TextViewMaxLines;
import com.cacard.demo.UI.View.TestViewGroupLayoutParamsActivity;
import com.cacard.demo.ViewDragHelperDemo.VDHActivity;
import com.cacard.demo.ViewPager.Demo2FragmentPagerAdapter.ViewPager_FragmentPagerAdapter_Activity;
import com.cacard.demo.ViewPager.Demo4ViewPagerSpecial.ViewPagerSpeicalActivity;
import com.cacard.demo.launchmode.FlagActivityNewTask.ActivityStart;
import com.cacard.demo.launchmode.SingleTask.Activity1SingleTask;
import com.cacard.demo.launchmode.SingleTask.ForResult.SingleTaskForResult1;
import com.cacard.demo.samsung.AActivity;

public class MainActivity extends Activity {

    private LinearLayout root;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setTitle("Main ActivityStart");

        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);

        generateMenu();


//        try {
//            int a = 0;
//            int b = 1 / a;
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.e("Exception", Log.getStackTraceString(e));
//        }
    }

    /**
     * 生成各个子Demo入口菜单
     */
    private void generateMenu() {

        // Basic
        addButton(root, "ScreenInfomation", ActivityScreenSize.class);
        addButton(root, "Info", ActivityInfo.class);
        addButton(root, "DirInfo", ActivityDirInfo.class);
        addButton("CpuCores", ActivityCpuInfo.class);
        addButton("ImplicitIntent", ImplicitIntentDemoActivity.class);

        addButton("Crash!!!", new Runnable() {
            @Override
            public void run() {
                int i = 0;
                int m = 1;
                int x = m / i;
            }
        });


        // Messenger
        addButton("MessengerDemo", MessengerDemoActivity.class);

        // launch mode
        addButton("LaunchMode/FlagActivityNewTask", ActivityStart.class);
        addButton(root, "LaunchMode/SingleInstance", Activity1SingleTask.class);


        // UI Relate
        addButton("UI/clipToPadding Demo", ClipToPaddingDemoActivity.class);
        addButton("UI/TextView Maxlines", TextViewMaxLines.class);
        addButton("UI/addView", TestViewGroupLayoutParamsActivity.class);
        addButton("UI/Measure/demo", CustomViewMeasureDemoActivity.class);
        addButton("UI/AbsPosition", ActivityAbsPosition.class);

        // Event
        addButton("Event/Intercept", InterceptDemoActivity.class);

        // Fragment
        addButton("UI/Fragment/StaticDemo", A_FragmentStaticActivity.class);
        addButton("UI/Fragment/DynamicDemo", B_FragmentDynamicActivity.class);
        addButton("UI/Fragment/RetainInstance", Fragment_RetainInstance_Activity.class);

        // Bitmap
        addButton("Bitmap/占用内存测试", BitmapMemorySizeTestActivity.class);

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


        addButton(root, "【Canvas】", EntryActivity.class);

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

        //addButton(root, "RecyclerView/SimpleDemo", RecyclerViewSimpleActivity.class);

        addButton(root, "Broadcast/RegManyTimes", ActivityRegReceiverManyTimes.class);

        addButton(root, "System/createPackageContext", ActivityCreatePackageContext.class);

        // ViewPager Demo
        //addButton("ViewPager/SimpleDemo", ViewPagerDemo1SimpleActivity.class);
        addButton("ViewPager/FragmentPagerAdapter", ViewPager_FragmentPagerAdapter_Activity.class);
        addButton("ViewPager/ViewPagerSpeical", ViewPagerSpeicalActivity.class);

        // android design support library
        addButton("DSL/SnackBar", SnackBarDemoActivity.class);
        addButton("DSL/TextInputLayout", TextInputLayoutDemoActivity.class);
        addButton("DSL/FloatingActionBarDemoActivity", FloatingActionBarDemoActivity.class);
//        addButton("DSL/CoorditorLayoutAndFab", CoornaditorLayoutAndFABActivity.class);
//        addButton("DSL/_Toolbar", _ToolbarDemoActivity.class);
//        addButton("DSL/_DrawerLayout", _DrawerLayoutDemoActivity.class);
//        addButton("DSL/_DrawerLayoutWithToolBar", _DrawerLayoutWithToolBarActivity.class);

        addButton("----------", MainActivity.class);
        addButton("Parcel save to db", ParcelSaveToDBActivity.class);
        addButton("Parcel null test", ActivityFirst.class);

        addButton("Camera/SimpleDemo", CameraSimpleActivity.class);

        addButton("Log/ReadLogUsingCmd", LogReaderActivity.class);


        // Animator
        addButton("Animator/Rotate", ActivityAnimateRotate.class);

        //
        addButton("Samsung", AActivity.class);


        // Android N
        addButton("N/Notification", AndroidNNotificationActivity.class);


        // bug
        addButton("bug/ListViewNotifyBugActivity", ListViewNotifyBugActivity.class);
        addButton("bug/ListViewTrackball", TrackballDemoActivity.class);

        addButton("dynamic/SimpleActivity", SimpleActivity.class);

        // ConstranitLayout
        addButton("ConstranitLayout", ConstranitLayoutDemoActivity.class);
        addButton("ConstraintLayout/Profile", CLayoutProfileActivity.class);
        addButton("CL/Chain", CLayoutChainActivity.class);

        addButton("NoRegisterActivity", NoRegisterActivity.class);

        // Binder/Aidl
        addButton("Binder/Aidl_simple", MyAddServiceClientActivity.class);

        // Start Luncher
        addButton("StartLuncher", new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_MAIN);
                i.addCategory(Intent.CATEGORY_HOME);
                //i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                MainActivity.this.startActivity(i);
            }
        });

        ScrollView sv = new ScrollView(this);
        sv.addView(root);
        setContentView(sv);


        addButton("SingleTask vs ForResult", SingleTaskForResult1.class);


//        sv.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                AppUtil.startApp2(MainActivity.this, "com.cacard.demo2");
//            }
//        },3000);

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

    private void addButton(String text, final Class<?> clazz) {
        addButton(root, text, clazz);
    }

    /**
     * Button and Click Event
     *
     * @param text
     * @param runnable
     */
    private void addButton(String text, final Runnable runnable) {

        final Button btn = new Button(this);
        btn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        btn.setText(text);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.post(runnable);
            }
        });
        root.addView(btn);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        Log.i(MyUncaughtExceptionHandler.TAG, "MainActivity->onDestory()");
//        MyUncaughtExceptionHandler.bug();
//        System.exit(0);

    }
}
