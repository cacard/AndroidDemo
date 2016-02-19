package com.cacard.demo.Parcel.ParcelNullUnmashall;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by cunqingli on 2016/1/26.
 */
public class ActivityFirst extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ParcelDemo demo = null;
        Intent itent = new Intent(this, ActivitySecond.class);
        itent.putExtra("key", demo);
        this.startActivity(itent);
    }
}
