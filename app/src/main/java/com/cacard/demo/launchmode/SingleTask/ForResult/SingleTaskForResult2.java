package com.cacard.demo.launchmode.SingleTask.ForResult;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SingleTaskForResult2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText("Click2");
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleTaskForResult2.this, SingleTaskForResult1.class);
                startActivity(intent);
            }
        });
        setContentView(tv);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.i("forresult", "onNewIntent()____________" );
        super.onNewIntent(intent);
    }
}
