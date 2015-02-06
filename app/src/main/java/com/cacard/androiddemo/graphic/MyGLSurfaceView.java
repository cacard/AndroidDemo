package com.cacard.androiddemo.graphic;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by cunqingli on 2015/1/8.
 */
public class MyGLSurfaceView extends GLSurfaceView {

    public MyGLSurfaceView(Context ctx) {
        super(ctx);
        init();
    }

    public MyGLSurfaceView(Context ctx, AttributeSet attributes) {
        super(ctx, attributes);
        init();
    }

    @Override
    protected void onDetachedFromWindow() {
        Log.i("lcq", "onDetachedFromWindow");
        super.onDetachedFromWindow();
    }


    private void init() {
        // Create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2);

        setRenderer(new MyRenderer());
        setRenderMode(RENDERMODE_WHEN_DIRTY);
    }

    private static class MyRenderer implements Renderer {

        @Override
        public void onSurfaceCreated(GL10 gl, EGLConfig config) {
            // Set the background frame color
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        }

        @Override
        public void onSurfaceChanged(GL10 gl, int width, int height) {
            GLES20.glViewport(0, 0, width, height);
        }

        @Override
        public void onDrawFrame(GL10 gl) {
            // Redraw background color
            GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        }
    }

}
