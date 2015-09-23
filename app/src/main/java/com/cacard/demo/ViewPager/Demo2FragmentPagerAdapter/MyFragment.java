package com.cacard.demo.ViewPager.Demo2FragmentPagerAdapter;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by cunqingli on 2015/9/23.
 */
public class MyFragment extends Fragment {

    private String title = "";

    // 构造
    public static MyFragment create (String text) {
        MyFragment fragment = new MyFragment();
        Bundle b = new Bundle();
        b.putString("title", text);
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // get parameters
        if (getArguments() != null) {
            title = getArguments().getString("title");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        TextView tv = new TextView(getContext());
        tv.setText(title);

        return tv;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
