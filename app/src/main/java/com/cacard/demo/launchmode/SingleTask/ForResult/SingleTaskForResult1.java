package com.cacard.demo.launchmode.SingleTask.ForResult;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SingleTaskForResult1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        TextView tv = new TextView(this);
        tv.setText("Click");
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleTaskForResult1.this, SingleTaskForResult2.class);
                startActivity(intent);
            }
        });
        setContentView(tv);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("forresult", "code:" + resultCode);
        super.onActivityResult(requestCode, resultCode, data);

        //RESULT_CANCELED == 0
    }
}
