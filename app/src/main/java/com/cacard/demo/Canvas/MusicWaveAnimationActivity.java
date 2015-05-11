package com.cacard.demo.Canvas;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;

/**
 * 音乐波浪控件Demo
 * - 采用Canvase动态绘制而成
 * <p/>
 * Created by cunqingli on 2015/5/11.
 */
public class MusicWaveAnimationActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("音乐波浪控件");
    }

    /**
     * 音乐波浪控件
     */
    public static class MusicWaveView extends View {

        public MusicWaveView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
        }
    }

}
