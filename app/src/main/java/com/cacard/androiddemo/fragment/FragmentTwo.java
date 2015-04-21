package com.cacard.androiddemo.fragment;

import com.cacard.androiddemo.R;
import com.cacard.androiddemo.util.LogHelper;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentTwo extends Fragment {
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		LogHelper.write("Fragment->onAttach");
	}

	@Override
	public void onCreate(Bundle b) {
		super.onCreate(b);
		LogHelper.write("Fragment->onCreate");

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup root, Bundle b) {
		super.onCreateView(inflater, root, b);
		LogHelper.write("Fragment->onCreateView");
		View v = inflater.inflate(R.layout.fragment_two, root, false);
		return v;

	}

	/* 绑定的Activity执行onCreated()完毕后 */
	@Override
	public void onActivityCreated(Bundle b) {
		super.onActivityCreated(b);
		LogHelper.write("Fragment->onActivityCreated");
	}

	@Override
	public void onStart() {
		super.onStart();
		LogHelper.write("Fragment->onStart");
	}

	@Override
	public void onResume() {
		super.onResume();
		LogHelper.write("Fragment->onResume");
	}

	@Override
	public void onPause() {
		super.onPause();
		LogHelper.write("Fragment->onPause");
	}

	@Override
	public void onStop() {
		super.onStop();
		LogHelper.write("Fragment->onStop");
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		LogHelper.write("Fragment->onDestroyView");
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		LogHelper.write("Fragment->onDestroy");
	}

	@Override
	public void onDetach() {
		super.onDetach();
		LogHelper.write("Fragment->onDetach");
	}
}
