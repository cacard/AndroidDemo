package com.cacard.demo.DesignSupportLibrary;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.Toast;

import com.cacard.demo.R;

/**
 * Created by cunqingli on 2015/9/17.
 */
public class FloatingActionBarDemoActivity extends Activity {

    private FloatingActionButton btnFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_fab);

        btnFab = (FloatingActionButton) findViewById(R.id.btnFab);
        btnFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FloatingActionBarDemoActivity.this, "Hello", Toast.LENGTH_SHORT);
            }
        });
    }
}
