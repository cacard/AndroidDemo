package com.cacard.androiddemo.fragment;

import com.cacard.androiddemo.R;
import com.cacard.androiddemo.activity.FragmentSupportMultipleScreen_DetailActivity;
import com.cacard.androiddemo.helper.LogHelper;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentMenu extends Fragment {

	private boolean isLarge = false;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup root, Bundle b) {
		super.onCreateView(inflater, root, b);
		LogHelper.write("Fragment->onCreateView");
		View v = inflater.inflate(R.layout.fragment_menu, root, false);
		return v;
	}

	/**
	 * Activity创建完毕后，判断是否能够找到 fragment-detail，如果有，则是宽屏，如果没有表示窄屏。
	 */
	@Override
	public void onActivityCreated(Bundle b) {
		super.onActivityCreated(b);

		isLarge = this.getActivity().findViewById(R.id.fragment_detail) != null;
		Log.i("test", "isLarge:" + String.valueOf(isLarge));

		// 为按钮添加事件
		Button btn1 = (Button) this.getActivity().findViewById(R.id.btn1);
		Button btn2 = (Button) this.getActivity().findViewById(R.id.btn2);

		btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				process(1);
			}
		});

		btn2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				process(2);
			}
		});

	}

	private void process(int index) {
		// 如果是窄屏，跳转
		if (isLarge) {
			getFragmentManager().beginTransaction().replace(R.id.fragment_detail, new FragmentDetail()).commit();
			return;
		}
		// 如果是宽屏，动态加载Fragment-detail
		if (!isLarge) {
			Intent i = new Intent(getActivity(), FragmentSupportMultipleScreen_DetailActivity.class);
			this.startActivity(i);
		}
	}

}
