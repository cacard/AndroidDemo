package com.cacard.androiddemo.event;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.cacard.androiddemo.MyApplication;
import com.cacard.androiddemo.R;

public class ActivityViewGroupEvent extends Activity {

    static final String TAG = "ActivityViewGroupEvent";
    ViewGroupSimple vg;
    TextView box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_view_group_event);

        vg = (ViewGroupSimple) super.findViewById(R.id.vg);
        box = (TextView) super.findViewById(R.id.box);

        testAction();
    }

    void testAction() {
        box.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                MyApplication.log(TAG + "->box.OnTouchListener,action:" + event.getAction());
                return true;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_view_group_event, menu);
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
