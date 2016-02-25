package com.cacard.demo.UI;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

/**
 * Created by cunqingli on 2016/2/25.
 */
public class TextViewMaxLines extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView tv = new TextView(this);
        tv.setMaxLines(2);
        tv.setText("这是测试，两行的。。。。。。。的地方陆地上的反垄断是，当减肥陆地上的，当减肥陆地上，的解放路上，地方军绿色的，电风扇等地方，的范德萨发，多福多寿，东方闪电楼，胜多负少。东方闪电。");

        // 设置setMaxLines后，并不出现省略号。
        // 必须设置上这个：setEllipsize
        tv.setEllipsize(TextUtils.TruncateAt.END);

        this.setContentView(tv);
    }
}
