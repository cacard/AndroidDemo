package com.cacard.demo.launchmode.SingleInstance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by cunqingli on 2015/4/29.
 */
public class Activity0 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View root = this.findViewById(android.R.id.content);
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity0.this, Activity1.class));
            }
        });

    }
}
