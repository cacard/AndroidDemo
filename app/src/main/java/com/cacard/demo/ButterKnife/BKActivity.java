package com.cacard.demo.ButterKnife;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cacard.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by cunqingli on 2016/10/24.
 */

public class BKActivity extends Activity {


    @Bind(R.id.tvName)
    TextView mTvName;
    @Bind(R.id.imgLogo)
    ImageView mImgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bk);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tvName)
    void tvNameClick() {
        Toast.makeText(this, "Hello, you clicked tvName", Toast.LENGTH_LONG).show();
    }

    @OnClick({R.id.tvName, R.id.imgLogo})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvName:
                break;
            case R.id.imgLogo:
                break;
        }
    }
}
