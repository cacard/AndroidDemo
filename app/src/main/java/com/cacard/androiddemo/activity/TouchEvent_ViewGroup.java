/**
 *  ViewGroup 的 
 */

package com.cacard.androiddemo.activity;

import com.cacard.androiddemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class TouchEvent_ViewGroup extends Activity {

    LinearLayout ll = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.touchevent_viewgroup);
        ll = (LinearLayout) this.findViewById(R.id.linearLayout);

    }

}
