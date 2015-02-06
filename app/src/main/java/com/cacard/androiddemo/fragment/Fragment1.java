package com.cacard.androiddemo.fragment;

import com.cacard.androiddemo.R;
import com.cacard.androiddemo.helper.LogHelper;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment1 extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup root, Bundle b) {
		super.onCreateView(inflater, root, b);
		LogHelper.write("Fragment->onCreateView");
		View v = inflater.inflate(R.layout.fragment1, root, false);
		return v;
	}
	
}
