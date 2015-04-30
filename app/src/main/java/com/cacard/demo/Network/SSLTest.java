package com.cacard.demo.Network;

import android.util.Log;

import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * SSL链接测试
 *
 * Created by cunqingli on 2014/12/31.
 */
public class SSLTest {

    public static void test() {
        try {
            String url1 = "https://kyfw.12306.cn/otn"; // Android手机无对应的根证书
            // java.security.cert.CertPathValidatorException: Trust anchor for certification path not found.

            String url2 = "https://passport.jd.com/new/login.aspx"; // OK

            URL url = new URL(url1);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            InputStream is = urlConnection.getInputStream();
            int i = 0;
            while (is.read() != -1) {
                i++;
            }
            Log.i("test", "i:" + i);
        } catch (Exception e) {
            e.printStackTrace();
            if (e != null && e.getMessage() != null) {
                Log.e("test",e.getMessage());
            }
        }
    }

}
