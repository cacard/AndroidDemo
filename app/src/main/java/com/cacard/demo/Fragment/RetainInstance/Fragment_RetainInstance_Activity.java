package com.cacard.demo.Fragment.RetainInstance;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;

/**
 * 让Fragment在屏幕旋转时不销毁。
 * 通过设置setRetainInstance(true)
 * <p/>
 * Created by cunqingli on 2016/3/8.
 */
public class Fragment_RetainInstance_Activity extends Activity implements Callback {

    public static final String TAG = "RetainInstance";
    public static final String FRAGMENT_RETAIN_ID = "MY_FRAGMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyFragment myFragment = null;
        FragmentManager fm = getFragmentManager();

        // 通过FragmentManager根据Tag来查找，如果该Fragment已经驻留，则可以找到。
        // 就是说当屏幕发送旋转后，这个拿到的MyFragment实例还是屏幕旋转之前的。
        myFragment = (MyFragment) fm.findFragmentByTag(FRAGMENT_RETAIN_ID);

        if (myFragment == null) {
            myFragment = new MyFragment();
            fm.beginTransaction().add(android.R.id.content/* 啊哈，attach到了根ViewGroup里了 */,
                    myFragment,
                    FRAGMENT_RETAIN_ID).commit();
        }

    }

    public void callback(int i) {
        Log.i(Fragment_RetainInstance_Activity.TAG, "callback();i=" + i);
    }


}
