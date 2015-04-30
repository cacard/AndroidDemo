/**
 * Fragment静态绑定到Activity
 * 
 * 在Activity中使用<Fragment .>标签，静态绑定一个Fragment。
 */

package com.cacard.demo.Fragment;
import com.cacard.demo.R;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;

public class FragmentStatic extends Activity {

	private final static String tag = "test";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(tag, "activity->begin onCreate()");

		this.setTitle("ActivityWithFragment");
		this.setContentView(R.layout.activity_with_static_fragment);

		Log.i(tag, "activity->end onCreate()");
	}
	
	@Override
	public void onAttachFragment(Fragment fragment){
		Log.i(tag, "activity->end onAttachFragment()");
	}

	@Override
	public void onStart() {
		super.onStart();
		Log.i(tag, "activity->begin onStart()");
		Log.i(tag, "activity->end onStart()");
	}

	@Override
	public void onResume() {
		super.onResume();
		Log.i(tag, "activity->begin onResume()");
		Log.i(tag, "activity->end onResume()");
	}

	@Override
	public void onPause() {
		super.onPause();
		Log.i(tag, "activity->begin onPause()");
		Log.i(tag, "activity->end onPause()");
	}

	@Override
	public void onStop() {
		super.onStop();
		Log.i(tag, "activity->begin onStop()");
		Log.i(tag, "activity->end onStop()");
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i(tag, "activity->begin onDestroy()");
		Log.i(tag, "activity->end onDestroy()");
	}

}
