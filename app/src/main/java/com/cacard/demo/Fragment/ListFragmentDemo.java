/**
 * ListFragment Demo
 */

package com.cacard.demo.Fragment;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.cacard.demo.Util.LogHelper;

public class ListFragmentDemo extends ListFragment {
	/* Fragment与Activity绑定时调用一次 */
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		LogHelper.write("onAttach");
	}
	
	@Override
	public void onCreate(Bundle b){
		super.onCreate(b);
		LogHelper.write("onCreate");
		
	}
	
//	@Override
//	public View onCreateView(LayoutInflater inflater,ViewGroup root,Bundle b){
//		super.onCreateView(inflater, root, b);
//		LogHelper.write("onCreateView");
//		View v = inflater.inflate(android.R.layout.simple_list_item_activated_1/*也可采用自定义布局文件*/, root,true);
//		return v;
//	}
	
	/* 绑定的Activity执行onCreated()完毕后 */
	@Override
	public void onActivityCreated(Bundle b){
		super.onActivityCreated(b);
		LogHelper.write("onActivityCreated");
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("title1");
		arrayList.add("title2");
		this.setListAdapter(new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_list_item_activated_1,arrayList));
	}
	
	/* 保存的状态数据恢复时,api 17+ */
//	@Override
//	public void onViewStateRestored(Bundle b){
//		super.onViewStateRestored(b);
//		LogHelper.write("onViewStateRestored");
//	}
	
	/* 界面可见时 */
	@Override
	public void onStart(){
		super.onStart();
		LogHelper.write("onStart");
	}
	
	/* 界面可交互时 */
	@Override
	public void onResume(){
		super.onResume();
		LogHelper.write("onResume");
	}
	
	@Override
	public void onPause(){
		super.onPause();
		LogHelper.write("onPause");
	}
	
	@Override
	public void onStop(){
		super.onStop();
		LogHelper.write("onStop");
	}
	
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		LogHelper.write("onDestroyView");
	}
	
	@Override
	public void onDestroy(){
		super.onDestroy();
		LogHelper.write("onDestroy");
	}
	
	@Override
	public void onDetach(){
		super.onDetach();
		LogHelper.write("onDetach");
	}
}
