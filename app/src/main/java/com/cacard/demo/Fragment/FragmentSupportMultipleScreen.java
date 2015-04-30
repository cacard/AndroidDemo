/**
 * 不同屏幕，不同的布局
 * 
 */

package com.cacard.demo.Fragment;

import com.cacard.demo.R;

import android.app.Activity;
import android.os.Bundle;

public class FragmentSupportMultipleScreen extends Activity {

	@Override
	public void onCreate(Bundle b) {
		super.onCreate(b);
		
		// 宽窄屏判断
		// 通过 	/res/layout-large/
		//		/res/layout-swXXX/
		// 实现自动加载
		this.setContentView(R.layout.activity_fragment_support_multiple_screen);
	}

}
