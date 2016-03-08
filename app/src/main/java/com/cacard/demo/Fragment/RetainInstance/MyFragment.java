package com.cacard.demo.Fragment.RetainInstance;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by cunqingli on 2016/3/8.
 */
public class MyFragment extends Fragment {
    private Callback callback;

    @Override
    public void onAttach(Activity activity) {
        Log.i(Fragment_RetainInstance_Activity.TAG, "onAttach(Activity activity)");

        super.onAttach(activity);

        if (activity instanceof Callback) {
            callback = (Callback) activity;
        }
    }

    @Override
    public void onAttach(Context context) {
        Log.i(Fragment_RetainInstance_Activity.TAG, "onAttach(Context context)");

        super.onAttach(context);

        if (context instanceof Callback) {
            callback = (Callback) context;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(Fragment_RetainInstance_Activity.TAG, "onCreate()");

        // !!!!!!!!!!!!!!!!
        // 设置为驻留
        setRetainInstance(true);

        super.onCreate(savedInstanceState);
        final Callback cb = callback;
        final Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                if (cb != null) {
                    for (int i = 0; i < 30; i++) {
                        cb.callback(i);
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        t.start();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout ll = new LinearLayout(getActivity());
        TextView tv = new TextView(getActivity());
        tv.setText("Hello");
        ll.addView(tv);
        return ll;
    }
}
