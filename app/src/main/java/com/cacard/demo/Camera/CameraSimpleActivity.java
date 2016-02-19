package com.cacard.demo.Camera;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Size;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.cacard.demo.R;

/**
 * Created by cunqingli on 2016/2/19.
 */
public class CameraSimpleActivity extends Activity {

    private SurfaceView mSfv;
    private TextView mBtn;
    android.hardware.Camera mCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initListener();

        openCamera();
    }

    private void initView() {
        this.setContentView(R.layout.activity_camera_simple);
        mSfv = (SurfaceView) findViewById(R.id.sfv);
        mBtn = (TextView) findViewById(R.id.btn);
    }

    private void initListener() {
        // 按下拍照按钮
        if (mBtn != null) {
            mBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mCamera != null) {
                        mCamera.takePicture(
                                // 按下快门后，这个时候可以显示Loading状态了。
                                new Camera.ShutterCallback() {
                            @Override
                            public void onShutter() {
                                log("takePicture, onShutter()");
                            }
                        },
                                // RAW数据到达后
                                new Camera.PictureCallback() {
                            @Override
                            public void onPictureTaken(byte[] data, Camera camera) {
                                log("takePicture, PictureCallback(), RAW");
                            }
                        },
                                // JPEG数据到达后
                                // 可以写入数据，并关闭Loading态
                                new Camera.PictureCallback() {
                            @Override
                            public void onPictureTaken(byte[] data, Camera camera) {
                                log("takePicture, PictureCallback(), JPG");
                            }
                        });
                    }
                }
            });
        }

        if (mSfv != null) {
            mSfv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }

    private void openCamera() {

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                mCamera = android.hardware.Camera.open(0);
            } else {
                mCamera = android.hardware.Camera.open();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        final int count = android.hardware.Camera.getNumberOfCameras();
        Toast.makeText(this, "count:" + count, Toast.LENGTH_LONG);


        // 拿到SurfaceView的SurfaceHolder
        SurfaceHolder holder = mSfv.getHolder();

        // 监听Surface的生命周期。Surface仅仅在SurfaceView被Attach到Window时有效，否者就会被销毁
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) { //连接到Surface
                log("SurfaceHolder Callback,surfaceCreated()");
                try {
                    if (mCamera != null) {
                        mCamera.setPreviewDisplay(holder);

                        // autofocus
                        runOnUiThread(mAutoFocusRunnable);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) { //第一次连接到Surface，可拿到绘制区域的大小
                log("SurfaceHolder Callback,surfaceChanged()");
                if (mCamera != null) {
                    Camera.Parameters parameters = mCamera.getParameters();
                    Size s = null;

                    try {
                        mCamera.startPreview();
                    } catch (Exception e) {
                        e.printStackTrace();
                        mCamera.release();
                        mCamera = null;
                    }
                }
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                log("SurfaceHolder Callback,surfaceDestroyed()");
                if (mCamera != null) {
                    mCamera.stopPreview();
                }
            }
        });

    }

    // 自动对焦
    private Runnable mAutoFocusRunnable = new Runnable() {
        @Override
        public void run() {
            if (mCamera!=null) {

                    mCamera.autoFocus(new Camera.AutoFocusCallback() {
                        @Override
                        public void onAutoFocus(boolean success, Camera camera) {
                            if (success) {
                                if (camera != null) {
                                    camera.cancelAutoFocus(); // 成功对焦后取消对焦动作
                                    log("focus success");
                                }
                            }
                        }
                    });

            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mCamera != null) {
            mCamera.release();
            mCamera = null;
        }
    }

    private void log(String msg) {
        Log.i("CameraSimple", msg);
    }
}
