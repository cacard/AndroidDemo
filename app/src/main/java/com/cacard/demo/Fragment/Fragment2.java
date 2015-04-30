package com.cacard.demo.Fragment;

import com.cacard.demo.R;
import com.cacard.demo.Util.LogHelper;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment2 extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup root, Bundle b) {
		super.onCreateView(inflater, root, b);
		LogHelper.write("Fragment->onCreateView");
		View v = inflater.inflate(R.layout.fragment2, root, false);
		return v;
	}
	
	@Override
	public void onActivityCreated(Bundle b){
		super.onActivityCreated(b);
		
		// 读取另外一个Fragment的控件数据
//		Button btn = (Button)this.getActivity().findViewById(R.id.btn2);
//		btn.setOnClickListener(new OnClickListener(){
//			@Override
//			public void onClick(View v) {
//				TextView tvFromFragment1 = (TextView)getActivity().findViewById(R.id.tv1);
//				Toast.makeText(getActivity(), tvFromFragment1.getText(), 2000).show();;
//			}});
	}
}
