package com.cacard.demo.Intent;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.List;

/**
 * 隐式Intent打开浏览器，并自定义弹出框
 * Created by cunqingli on 2015/9/16.
 */
public class ImplicitIntentDemoActivity extends Activity implements View.OnClickListener {

    private int btnId = 0;
    private static final String TAG = ImplicitIntentDemoActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        Button btn = new Button(this);
        btnId = View.generateViewId();
        btn.setId(btnId);
        btn.setText("Click");
        btn.setOnClickListener(this);

        root.addView(btn);
        this.setContentView(root);
    }

    private void queryAllBrowsers() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        List<ResolveInfo> list = this.getPackageManager().queryIntentActivities(intent, 0);
        if (list != null && list.size() > 0) {
            for (ResolveInfo ri : list) {
                android.content.pm.ActivityInfo ai = ri.activityInfo;
                Log.i("TAG", ai.targetActivity);
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btnId) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://www.qq.com"));
            ImplicitIntentDemoActivity.this.startActivity(intent);
        }
    }
}
