package com.cacard.androiddemo.graphic;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * SurfaceView的目的是可使用独立线程绘制。
 * <p/>
 * Created by cunqingli on 2015/1/6.
 */
public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private Thread t;
    private static final String TAG = "MySurfaceView";
    private boolean isRunning = true; // 用来通知线程结束运行

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);

        final SurfaceHolder holder = getHolder();
        holder.addCallback(this);

        this.setFocusable(true);

        // 定义一个线程，用于绘制
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                if (!isRunning) {
                    return;
                }

                int r = 0;
                int g = 0;
                int b = 0;
                final int max = 255;

                while (true) {
                    if (r >= max && g >= max && b >= max) {
                        break;
                    }

                    Canvas c = null;
                    try {
                        c = holder.lockCanvas();
                        c.drawRGB(r, g, b);
                        //Thread.sleep(10);
                    } catch (Exception e) {
                        // pass
                    } finally {
                        if (c != null) {
                            Log.i(TAG, "->unlockCanvasAndPost(),R/G/B: " + r + "/" + g + "/" + b);
                            holder.unlockCanvasAndPost(c);
                            MySurfaceView.this.postInvalidate(); // update View
                        }
                    }

                    if (r < max) {
                        r++;
                    } else if (g < max) {
                        g++;
                    } else if (b < max) {
                        b++;
                    }
                }
            }
        });
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.i(TAG, "surfaceCreated");

        // 在Surface初始化完成后开启线程，在新线程中绘制
        t.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.i(TAG, "surfaceChanged");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.i(TAG, "surfaceDestroyed");

        isRunning = false;

        try {
            t.join();
        } catch (Exception e) {

        }

        Log.i(TAG, "surfaceDestroyed_over");
    }
}
