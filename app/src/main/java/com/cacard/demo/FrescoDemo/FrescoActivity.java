package com.cacard.demo.FrescoDemo;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import com.cacard.demo.R;
import com.facebook.drawee.view.DraweeView;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by cunqingli on 2015/7/2.
 */
public class FrescoActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_fresco_simple);

        // SimpleDraweeView
        // 不支持wrap_content
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.img);
        Uri uri = Uri.parse("http://mat1.gtimg.com/www/images/qq2012/qqlogo_2x.png");
        simpleDraweeView.setImageURI(uri);
        simpleDraweeView.setAspectRatio(1.33f);
    }
}
