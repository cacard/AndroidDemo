package com.cacard.demo.Graphic.Martix;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.graphics.Matrix;

import com.cacard.demo.R;

/**
 * Created by cunqingli on 2015/7/6.
 */
public class MartixDemoActivity extends Activity {

    private Button btn1;
    private ImageView iv;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_martix);

        bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.android_yellow);

        findControls();
        initListeners();
    }

    private void findControls() {
        btn1 = (Button) findViewById(R.id.btn1);
        iv = (ImageView) findViewById(R.id.iv);
    }

    private void initListeners() {
        if (btn1 != null) {
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }

    private void demo1 () {
        Matrix matrix = new Matrix();
        matrix.setRotate(90);
        if (bitmap != null) {

        }
    }
}
