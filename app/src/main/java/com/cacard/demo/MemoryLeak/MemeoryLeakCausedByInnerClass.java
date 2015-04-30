/**
 * InnerClass造成的内存泄露
 *
 * - InnerClass的实例持有外部类的实例。如果InnerClass的实例得不到释放（比如被放到了类型的静态变量里面），外部类也得不到释放。
 *
 */

package com.cacard.demo.MemoryLeak;

import android.app.Activity;
import android.os.Bundle;

public class MemeoryLeakCausedByInnerClass extends Activity {

    public static InnerClass inner = null; // static 变量可以看做GCRoot

    public static class InnerClass {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (inner == null) {
            inner = new InnerClass();
        }

        this.finish();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

}
