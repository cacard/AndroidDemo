package com.cacard.androiddemo.network;

import com.cacard.androiddemo.helper.LogHelper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 网络服务
 * <p/>
 * Wi-Fi, GPRS, UMTS, etc.
 */
public class ConnectivityManagerDemo {

    public static void test(Context ctx) {
        // get service
        ConnectivityManager mgr = (ConnectivityManager) ctx.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        if (mgr == null) {
            LogHelper.write("mgr is null.");
            return;
        }

        // activite networkinfo
        NetworkInfo info = mgr.getActiveNetworkInfo();
        LogHelper.write("->ActiveNetworkInfo");
        LogHelper.write("toString():" + info.getExtraInfo());
        LogHelper.write("getExtraInfo:" + info.getExtraInfo());
        LogHelper.write("getState:" + info.getState());
        LogHelper.write("getSubtypeName:" + info.getSubtypeName());
        LogHelper.write("getTypeName:" + info.getTypeName());

        // all networkinfo
        LogHelper.write("->AllNetworkInfo");
        NetworkInfo[] infos = mgr.getAllNetworkInfo();
        LogHelper.write("" + infos.length);
        for (NetworkInfo n : infos) {
            LogHelper.write("\r\n---\r\ntoString:" + n.toString());
            LogHelper.write("getExtraInfo:" + n.getExtraInfo());
            LogHelper.write("getState:" + n.getState());
            LogHelper.write("getType:" + n.getType() + "/getTypeName:" + n.getTypeName());
            LogHelper.write("getSubtypeName:" + n.getSubtypeName());

        }
    }

}
