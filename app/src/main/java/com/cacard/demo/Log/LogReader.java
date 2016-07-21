package com.cacard.demo.Log;

import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by cunqingli on 2016/4/28.
 */
public class LogReader {

    public static void readLogUsingCmd(TextView tv) {
        try {
            Process process = Runtime.getRuntime().exec("logcat -d");
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            StringBuilder log = new StringBuilder();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                log.append(line);
            }

            if (tv != null) {
                tv.setText(log.toString());
            }

        } catch (IOException e) {
            Log.e("lcq111", e.getMessage());
        }
    }

}
