package com.cacard.demo.Activity;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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

        // system property
        List<String> pros = new ArrayList<String>();
        pros.add("java.class.path"); // 创建SystemClassLoader（是一个PathClassLoader）时，传递的dexPath是这个！   value=. -_-''
        pros.add("java.library.path");
        String msg = " ";
        for (String s : pros) {
            String v = System.getProperty(s);
            msg += s + "=" + v;
        }
        addInfo(msg);

    }

    private void addInfo(String message) {
        TextView tv = new TextView(this);
        tv.setText(message);
        root.addView(tv);
    }

    public native final String hello(String a) throws Exception;


}
