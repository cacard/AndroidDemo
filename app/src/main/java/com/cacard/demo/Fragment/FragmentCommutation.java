/**
 * Fragment之间的交互
 * 
 * 		- Fragment2读取Fragment1的控件（通过getActivity().findViewById()中转）
 * 		- 通过接口
 */
package com.cacard.demo.Fragment;

import com.cacard.demo.R;

import android.app.Activity;
import android.os.Bundle;

public class FragmentCommutation extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_fragment_commutation);
	}

	@Override
	public void onStart() {
		super.onStart();
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onStop() {
		super.onStop();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

}
