package com.cacard.demo.UI;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static com.cacard.demo.R.id.tv1;

/**
 * Created by cunqingli on 2016/2/25.
 */
public class TextViewMaxLines extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);

        TextView tv = new TextView(this);
        tv.setMaxLines(2);
        tv.setText("这是测试，两行的。。。。。。。的地方陆地上的反垄断是，当减肥陆地上的，当减肥陆地上，的解放路上，地方军绿色的，电风扇等地方，的范德萨发，多福多寿，东方闪电楼，胜多负少。东方闪电。");

        // 设置setMaxLines后，并不出现省略号。
        // 必须设置上这个：setEllipsize
        tv.setEllipsize(TextUtils.TruncateAt.END);

        ll.addView(tv);

        /////////////////////////////tv2
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final TextView tv2 = new TextView(this);
        tv2.setLayoutParams(lp);
        tv2.setText("123");
        tv2.setBackgroundColor(Color.RED);
        final TextView tv3 = new TextView(this);
        tv3.setLayoutParams(lp);
        tv3.setText(Html.fromHtml("1&nbsp;&nbsp;3"));
        tv3.setBackgroundColor(Color.RED);
        ll.addView(tv2);
        ll.addView(tv3);

        // same width
//        tv3.post(new Runnable() {
//            @Override
//            public void run() {
//                int w = tv2.getMeasuredWidth();
//                tv3.setWidth(w);
//            }
//        });

        this.setContentView(ll);

        // 判断是否有超出文字
        final TextView tvP = tv;
        tv.post(new Runnable() {
            @Override
            public void run() {
                // 方法1
                int count = tvP.getLayout().getLineCount();
                int c = tvP.getLayout().getEllipsisCount(count - 1);
                // 方法2
                boolean b = tvP.getLayout().getText().equals(tvP.getText());
                Toast.makeText(TextViewMaxLines.this, "" + c + "/" + b, Toast.LENGTH_LONG).show();
            }
        });
    }
}
