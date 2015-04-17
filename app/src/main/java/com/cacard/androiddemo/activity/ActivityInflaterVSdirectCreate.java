package com.cacard.androiddemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Debug;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cacard.androiddemo.R;

/**
 * 直接使用布局文件vs直接创建控件的性能对比
 */
public class ActivityInflaterVSdirectCreate extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        usingDriectCreate();

    }

    private void usingLayout() {
        Debug.startMethodTracing("vs1");
        setContentView(R.layout.activity_activity_inflater_vsdirect_create);
        Debug.stopMethodTracing();
    }

    private void usingDriectCreate() {
        Debug.startMethodTracing("vs2");
        RelativeLayout layout = new RelativeLayout(this);

        TextView tv1 = new TextView(this);
        tv1.setText("Hello");
        layout.addView(tv1);

        TextView tv2 = new TextView(this);
        tv2.setText("Hello");
        layout.addView(tv2);

        TextView tv3 = new TextView(this);
        tv3.setText("Hello");
        layout.addView(tv3);

        this.setContentView(layout);
        Debug.stopMethodTracing();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_inflater_vsdirect_create, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
