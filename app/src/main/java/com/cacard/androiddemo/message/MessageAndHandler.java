

package com.cacard.androiddemo.message;

import android.app.Activity;
import android.os.Bundle;

/**
 * Message 和 Handler
 * <p/>
 * Message
 * - 可包含一些数据（int/object/bundle）
 * - 还可以包含一个回调（Runnable callback），该回调的优先级高于Handler实现的回调（Callback接口）。
 * - 包含一个Handler target，与一个Handler关联。
 * <p/>
 * Handler
 * - 负责发送Message到MQ
 * - 关联Looper，如果是UI线程创建Handler，关联的是UI线程的Looper
 * - 关联一个Callback，即处理消息的回调。如果消息本身包含了自己的Runnable callback，则不再执行该回调。
 * <p/>
 * ------------------
 */
public class MessageAndHandler extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

}
