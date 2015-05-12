package com.cacard.demo.Canvas.Paint.Shader;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by cunqingli on 2015/5/11.
 */
public class ShaderActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);

        MyView v = new MyView(this);
        ll.addView(v);

        this.setContentView(ll);
    }

    public static class MyView extends View {

        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {

            canvas.translate(10, 10);

            // 线性渐变
            LinearGradient linearGradient = new LinearGradient(0, 0, 0, 100, Color.RED, Color.BLUE, Shader.TileMode.CLAMP); // 垂直方向，长度100
            Paint p = new Paint();
            p.setShader(linearGradient);
            Rect rect = new Rect(0, 0, 100, 200); // 垂直方向，矩形是200
            canvas.drawRect(rect, p);

            canvas.translate(0, 210);
            linearGradient = new LinearGradient(0, 0, 0, 100, Color.RED, Color.BLUE, Shader.TileMode.REPEAT); // 平铺模式改为 REPEAT
            p.setShader(linearGradient);
            canvas.drawRect(rect, p);

            canvas.translate(0, 210);
            linearGradient = new LinearGradient(0, 0, 0, 100, Color.RED, Color.BLUE, Shader.TileMode.MIRROR); // 平铺模式改为 MIRROR
            p.setShader(linearGradient);
            canvas.drawRect(rect, p);


            // 环形渐变
            canvas.translate(0, 210);
            Rect rect2 = new Rect(0, 0, 200, 200);
            RadialGradient radialGradient = new RadialGradient(100, 100, 50, Color.YELLOW, Color.RED, Shader.TileMode.CLAMP);
            p.setShader(radialGradient);
            canvas.drawRect(rect2, p);

            canvas.translate(0, 210);
            Rect rect3 = new Rect(0, 0, 600, 200);
            RadialGradient radialGradient2 = new RadialGradient(0, 100, 500, Color.WHITE, Color.GRAY, Shader.TileMode.CLAMP);
            p.setShader(radialGradient2);
            canvas.drawRect(rect3, p);

        }
    }
}
