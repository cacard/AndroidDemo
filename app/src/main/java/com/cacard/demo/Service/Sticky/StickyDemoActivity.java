package com.cacard.demo.Service.Sticky;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.cacard.demo.MyApplication;

/**
 * Created by cunqingli on 2015/6/25.
 */
public class StickyDemoActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        Button btn1 = new Button(this);
        btn1.setText("start sticky service");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startStickyService();
            }
        });

        linearLayout.addView(btn1);
        this.setContentView(linearLayout);

    }

    private void startStickyService() {
        MyApplication.instance.startService(new Intent(MyApplication.instance, StartStickyService.class));
    }
}
