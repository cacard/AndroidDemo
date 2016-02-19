package com.cacard.demo.Parcel.ParcelNullUnmashall;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by cunqingli on 2016/1/26.
 */
public class ActivitySecond extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();
        if (i != null) {
            ParcelDemo p = i.getParcelableExtra("key");
        }
    }
}
