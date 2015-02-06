/**
 * 
 */
package com.cacard.androiddemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class ActivityB extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// TODO Auto-generated method stub
		
		Log.i("test", "ActivityB.onCreate()");
		this.setTitle("B");

	}
}
