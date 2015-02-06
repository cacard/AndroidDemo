/**
 * 
 */
package com.cacard.androiddemo.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Scroller;
import android.widget.TextView;

import com.cacard.androiddemo.R;

public class ActivityScrollerDemo extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.setContentView(R.layout.activity_scroller_demo);

		final TextView target = (TextView) this.findViewById(R.id.target);

		final Context ctx = this.getApplicationContext();

		Button btn = (Button) this.findViewById(R.id.btn);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// 开启Scroller
				Scroller s = new Scroller(ctx);
				s.startScroll(0, 0, 200, 200, 1000);

				// 循环获取Scroller计算好的偏移，更新UI
				while (s.computeScrollOffset()) {
					
					if(s.getCurrX()%10!=0){
						continue;
					}
					
					target.scrollTo(s.getCurrX(), s.getCurrY());
					target.invalidate();
					Log.i("test","getScrollX:" + target.getScrollX() + ",getScrollY:" + target.getScrollY());
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});

	}


}
