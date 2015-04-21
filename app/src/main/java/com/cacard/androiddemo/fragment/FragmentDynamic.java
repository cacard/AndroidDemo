/**
 * 动态加载Fragment和变换Fragment
 * 
 * activity的layout中放一个容器 FrameLayout
 * 
 */

package com.cacard.androiddemo.fragment;

import com.cacard.androiddemo.R;
import com.cacard.androiddemo.fragment.FragmentOne;
import com.cacard.androiddemo.fragment.FragmentTwo;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class FragmentDynamic extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_with_dynamic_fragment);
		
	}

	/**
	 * 创建 FragmentOne实例，填充。
	 * @param v
	 */
	public void btnClick1(View v) {

		Fragment fragmentOne = new FragmentOne();
		
		fragmentOne.setArguments(this.getIntent().getExtras());

		FragmentManager fm = this.getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.replace(R.id.fragment_container, fragmentOne);
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		ft.addToBackStack(null);
		ft.commit();

		Log.i("test", "btnClick1(), fragmentOne:" + fragmentOne.toString());

	}

	/**
	 * 创建FragmentTwo实例，填充。
	 * @param v
	 */
	public void btnClick2(View v) {

		Fragment fragmentTwo = new FragmentTwo();

		FragmentManager fm = this.getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.replace(R.id.fragment_container, fragmentTwo);
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
		ft.commit();

		Log.i("test", "btnClick2(), fragmentTwo:" + fragmentTwo.toString());

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
