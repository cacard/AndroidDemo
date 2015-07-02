package com.cacard.demo.Activity;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * App和Android信息
 * <p/>
 * Created by cunqingli on 2015/5/14.
 */
public class ActivityInfo extends Activity {

    private LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        super.setContentView(root);

        // versionCode
        try {
            PackageInfo pi = getPackageManager().getPackageInfo("com.cacard.demo", PackageManager.GET_CONFIGURATIONS);
            addInfo("versionCode:" + pi.versionCode + ",versionName:" + pi.versionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addInfo(String message) {
        TextView tv = new TextView(this);
        tv.setText(message);
        root.addView(tv);
    }

}
