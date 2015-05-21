

package com.cacard.demo.Fragment.A_SimpleDemo;

import com.cacard.demo.R;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;

/**
 * Fragment静态绑定到Activity
 * <p/>
 * 在Activity中使用<Fragment .>标签，静态绑定一个Fragment。
 */
public class A_FragmentStaticActivity extends Activity {

    private final static String tag = "test";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("StaticFragment");
        this.setContentView(R.layout.activity_with_static_fragment);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        Log.i(tag, "activity->end onAttachFragment()");
    }
}
