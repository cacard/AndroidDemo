package com.cacard.demo.Util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.util.Log;

import java.util.List;

/**
 * Created by cunqingli on 2016/10/13.
 */

public class AppUtil {

    /**
     * 拉起App到前台
     * <p>
     * android 21 失效，因为获取不到其它App的RunningTask了
     */
    public static void startApp1(Context ctx, String appPackageName) {
        if (Build.VERSION.SDK_INT >= 11) { // honeycomb
            final ActivityManager activityManager = (ActivityManager) ctx.getSystemService(Context.ACTIVITY_SERVICE);


            final List<ActivityManager.RunningTaskInfo> recentTasks = activityManager.getRunningTasks(Integer.MAX_VALUE);

            for (int i = 0; i < recentTasks.size(); i++) {
                Log.d("Executed app", "Application executed : "
                        + recentTasks.get(i).baseActivity.toShortString()
                        + "\t\t ID: " + recentTasks.get(i).id + "");
                // bring to front
                if (recentTasks.get(i).baseActivity.toShortString().indexOf(appPackageName) > -1) {
                    activityManager.moveTaskToFront(recentTasks.get(i).id, ActivityManager.MOVE_TASK_WITH_HOME);
                }
            }
        }
    }

    /**
     * 拉起App
     * 如果App已经启动，相当于切换到该App；
     * 如果App未启动，相当于启动
     *
     * @param ctx
     * @param appPackageName
     */
    public static void startApp2(Context ctx, String appPackageName) {


        try {
            PackageInfo pi = ctx.getPackageManager().getPackageInfo(appPackageName, 0);
            String str = pi.packageName;
            String v = pi.versionName;
        } catch (Exception e) {

        }

        Intent launchIntent = ctx.getPackageManager().getLaunchIntentForPackage(appPackageName);
        if (launchIntent != null) {
            ctx.startActivity(launchIntent);
        }
    }

}
