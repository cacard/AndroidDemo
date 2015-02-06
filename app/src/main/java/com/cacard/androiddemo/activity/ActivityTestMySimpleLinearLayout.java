/**
 * 通过自定义LinearLayout，测试ViewGroup/View的事件过程
 *
 * intercept()函数
 * 		- return true，表示拦截——禁止向子View传递事件。
 * 		- return false，表示隧道——所有事件均要经过这里。
 *
 */

package com.cacard.androiddemo.activity;

import com.cacard.androiddemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class ActivityTestMySimpleLinearLayout extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_test_my_simple_linear_layout);

        Button btn = (Button) this.findViewById(R.id.btn);
        View mySimpleView = this.findViewById(R.id.mySimpleView);

    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.i("test", "activity.onTouchEvent(),action=" + ev.getAction());
        return false;
    }

}
