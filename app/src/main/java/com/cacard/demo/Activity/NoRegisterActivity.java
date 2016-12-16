package com.cacard.demo.Activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.content.pm.PackageManager.COMPONENT_ENABLED_STATE_ENABLED;
import static android.content.pm.PackageManager.DONT_KILL_APP;

/**
 * Created by cunqingli on 2016/11/4.
 */

public class NoRegisterActivity extends Activity {

    private static final String TAG = "NoRegisterActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        TextView tv = new TextView(this);
        tv.setText("NoRegisterActivity");
        ll.addView(tv);
        setContentView(ll);
    }

    public static void enable(Context context) {
        try {
            PackageManager pm = context.getPackageManager();
            ComponentName cpName = new ComponentName(context, NoRegisterActivity.class);
            pm.setComponentEnabledSetting(cpName, COMPONENT_ENABLED_STATE_ENABLED, DONT_KILL_APP);
        } catch (Exception e) {
            e.printStackTrace();
            Log.i(TAG, e.getMessage());
        }
    }
}
