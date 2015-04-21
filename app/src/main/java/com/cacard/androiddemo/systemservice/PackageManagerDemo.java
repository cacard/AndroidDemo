package com.cacard.androiddemo.SystemService;

import java.util.List;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

public class PackageManagerDemo {

    private Context ctx;

    public PackageManagerDemo(Context ctx) {
        this.ctx = ctx;
    }

    public void printAllPackages() {
        PackageManager mgr = ctx.getPackageManager();
        if (mgr != null) {
            List<PackageInfo> packages = mgr.getInstalledPackages(PackageManager.GET_ACTIVITIES);
            if (packages != null && packages.size() > 0) {
                for (PackageInfo pi : packages) {
                    Log.i("test", pi.applicationInfo.toString());
                }
            }
        }

    }
}
