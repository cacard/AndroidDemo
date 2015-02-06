/**
 *  ListView优化
 */

package com.cacard.androiddemo.activity.ui;

import java.util.ArrayList;
import java.util.List;

import com.cacard.androiddemo.R;
import com.cacard.androiddemo.adapter.ListViewOptimizationAdapter;
import com.cacard.androiddemo.model.User;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class ListViewOptimization extends Activity {

    private ListView lv = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.list_view_optimization);

        lv = (ListView) this.findViewById(R.id.lv);
        bindList();
    }

    private List<User> generateDataList() {
        List<User> l = new ArrayList<User>();
        int count = 10000;
        for (int i = 0; i < count; i++) {
            l.add(new User("name_" + i, i));
        }

        return l;
    }

    private void bindList() {
        ListViewOptimizationAdapter adp = new ListViewOptimizationAdapter(generateDataList(), ListViewOptimization.this);
        lv.setAdapter(adp);
        adp.notifyDataSetChanged();
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
