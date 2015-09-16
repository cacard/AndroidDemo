package com.cacard.demo.DesignSupportLibrary;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by cunqingli on 2015/9/16.
 */
public class SnackBarDemoActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final RelativeLayout layout = new RelativeLayout(this);
        this.setContentView(layout);

        final View decorView = this.getWindow().getDecorView(); // no work

        //
        //final CoordinatorLayout coordinatorLayout = new CoordinatorLayout(this);
        //layout.addView(coordinatorLayout);

        Button btn = new Button(this);
        btn.setText("--button--");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(findViewById(android.R.id.content), "Hello", Snackbar.LENGTH_LONG).setAction("___", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
            }
        });

        layout.addView(btn);
    }
}
