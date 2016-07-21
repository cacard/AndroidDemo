package com.cacard.demo.IO;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

import java.io.File;


/**
 * Created by cunqingli on 2015/5/7.
 */
public class ActivityDirInfo extends Activity {

    TextView tvLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Dir Info");
        tvLog = new TextView(this);
        setContentView(tvLog);
        collectInfo();
    }

    private void collectInfo() {
        String s = "";
        s += environmentInfo();
        s += "\n--------------------\n";
        s += internalStorageInfo();
        s += "\n--------------------\n";
        s += externalStorageInfo();
        tvLog.setText(s);
    }

    private String environmentInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Environment.DIRECTORY_MOVIES]" + Environment.DIRECTORY_MOVIES);
        return sb.toString();
    }


    private String internalStorageInfo() {
        StringBuilder sb = new StringBuilder();

        // context.getFilesDir()
        // get the internalStorage dir
        // just have relative path.
        File f = this.getFilesDir();
        if (f != null) {
            sb.append("\n[internal/absoluteFile]");
            sb.append("\n" + f.getAbsoluteFile());
            sb.append("\n[internal/path]");
            sb.append("\n" + f.getPath());

        }

        return sb.toString();
    }

    @TargetApi(11)
    private String externalStorageInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("[isExternalStorageEmulated]\n" + Environment.isExternalStorageEmulated());
        sb.append("\n[Environment.getExternalStorageDirectory()][MEANS Global]\n" + Environment.getExternalStorageDirectory());
        sb.append("\n[Environment.getExternalStorageState()]\n" + Environment.getExternalStorageState());
        sb.append("\n[Context.getExternalFilesDir][MEANS Current App's external dir]");
        sb.append("\n" + this.getExternalFilesDir(null).getAbsolutePath());

        return sb.toString();
    }
}
