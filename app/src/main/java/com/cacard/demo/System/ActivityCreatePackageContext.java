package com.cacard.demo.System;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

/**
 * test createPackageContext()
 * 可拿到任意包中的资源
 *
 * Created by cunqingli on 2015/9/10.
 */
public class ActivityCreatePackageContext extends Activity {

    private static final String PACKAGE_NAME = "com.tencent.news";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            Context context = createPackageContext(PACKAGE_NAME, CONTEXT_INCLUDE_CODE | CONTEXT_IGNORE_SECURITY);
            if (context != null) {
                // classloader info
                log(context.getClassLoader().toString());

                Class<?> clazz = context.getClassLoader().loadClass("com.tencent.news.R");
                if (clazz != null) {

                    // 所有静态内部类
                    Class find = null;
                    Class[] classes = clazz.getClasses();
                    String allClasses = "";
                    for(int i = 0;i<classes.length;i++) {
                        final String name = classes[i].getSimpleName();
                        allClasses +=  name + ",";
                        if (name.equals("string")) {
                            find = classes[i];
                        }
                    }
                    log("R's innner class:"+allClasses);

                    // 获取app_name
                    if (find != null) {
                        final String fieldName = "app_name";
                        int id = find.getDeclaredField(fieldName).getInt(find);

                        String str = context.getResources().getString(id);
                        log("app_name:"+str); // bingo
                    }
                }
            } else {
                log("context is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void log(String msg) {
        Log.i("ActivityCreatePackageContext", msg);
    }
}
