/**
 *
 */
package com.cacard.androiddemo.activity;

import com.cacard.androiddemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class ActivityTab extends Activity {

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_tab);

        TabHost host = (TabHost) this.findViewById(R.id.tabhost);

        if (host == null) {
            this.setTitle("host is null");
            return;
        }

        TabSpec spec1 = host.newTabSpec("spec1");
        TabSpec spec2 = host.newTabSpec("spec2");

        spec1.setIndicator("TAB1");//.setContent(new Intent(this,ActivityA.class));
        spec2.setIndicator("TAB2");//.setContent(new Intent(this,ActivityB.class));
        if (host != null) {
            host.addTab(spec1);
            host.addTab(spec2);
        }

    }

}
