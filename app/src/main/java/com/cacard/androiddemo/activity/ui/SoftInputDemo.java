package com.cacard.androiddemo.activity.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import com.cacard.androiddemo.R;

public class SoftInputDemo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_soft_input_demo);
		
		EditText et = (EditText)this.findViewById(R.id.editText1);
		et.requestFocus();
		
		
		this.setTitle("SoftInput");
		
	}

}
