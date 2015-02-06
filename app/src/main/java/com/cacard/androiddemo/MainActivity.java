package com.cacard.androiddemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.cacard.androiddemo.Animator.ActivityValueAnimator;
import com.cacard.androiddemo.activity.ActivityA;
import com.cacard.androiddemo.activity.ActivityInstrumentationTest;
import com.cacard.androiddemo.event.ActivityMotionEvent;
import com.cacard.androiddemo.event.ActivityViewGroupEvent;
import com.cacard.androiddemo.graphic.MyGLSurfaceView;
import com.cacard.androiddemo.graphic.MyGLSurfaceViewActivity;
import com.cacard.androiddemo.graphic.MySurfaceViewActivity;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.main_activity); // 使用super而不是this，可减少方法数
        super.setTitle("Main");

        // 打开Activity
        gotoActivity(ActivityViewGroupEvent.class);
    }

    private void gotoActivity(Class<?> clazz) {
        this.startActivity(new Intent(this, clazz));
    }
}
