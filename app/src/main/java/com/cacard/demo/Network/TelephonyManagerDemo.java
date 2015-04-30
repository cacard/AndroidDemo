package com.cacard.demo.Network;

import java.util.List;

import android.content.Context;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

public class TelephonyManagerDemo {

    public static void test(Context ctx) {
        StringBuilder sb = new StringBuilder();

        TelephonyManager m = (TelephonyManager) ctx.getSystemService(Context.TELEPHONY_SERVICE);

        sb.append("CallState:" + m.getCallState() + "\r\n");
        List<NeighboringCellInfo> l = m.getNeighboringCellInfo();

        if (l != null && l.size() > 0) {
            sb.append("getNeighboringCellInfo:\r\n");
            for (NeighboringCellInfo i : l) {
                sb.append("cid:" + i.getCid());
            }
        } else {
            sb.append("getNeighboringCellInfo is null\r\n");
        }

        Log.i("test", sb.toString());

        // listener
        m.listen(new PhoneStateListener() {
        }, PhoneStateListener.LISTEN_CALL_STATE);
    }

}
