package com.cacard.demo.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.cacard.demo.R;

/**
 * Created by cunqingli on 2015/7/17.
 */
public class RecyclerViewSimpleActivity extends Activity {

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_recycler_view_simple);
        rv = (RecyclerView) findViewById(R.id.rv);
    }
}
