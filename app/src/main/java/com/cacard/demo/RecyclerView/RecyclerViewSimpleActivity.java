package com.cacard.demo.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cacard.demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cunqingli on 2015/7/17.
 */
public class RecyclerViewSimpleActivity extends Activity {

    private RecyclerView rv;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_recycler_view_simple);
        rv = (RecyclerView) findViewById(R.id.rv);

        // 4 LayoutManager
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        llm.scrollToPosition(0);
        rv.setLayoutManager(llm);

        // 5 set Adapter
        final List<MyItem> items = new ArrayList<MyItem>();
        for (int i = 0; i < 20; i++) {
            items.add(new MyItem(i + "", i + "_"));
        }
        adapter = new MyAdapter(items);
        rv.setAdapter(adapter);


        // ----------------------
        ((Button) findViewById(R.id.btnAdd)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.add(1, new MyItem("add", "add_"));
                adapter.notifyItemInserted(1);
            }
        });
        findViewById(R.id.btnRemove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (items.size() >= 2) {
                    items.remove(1);
                    adapter.notifyItemRemoved(1);
                }
            }
        });

    }

    /**
     * 1 DataItem
     */
    public static class MyItem {
        public String value1;
        public String value2;

        public MyItem(String v1, String v2) {
            this.value1 = v1;
            this.value2 = v2;
        }
    }

    /**
     * 2 ViewHolder
     */
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv1;
        private TextView tv2;

        public MyViewHolder(View itemView) {
            super(itemView);

            // find controls
            tv1 = (TextView) itemView.findViewById(R.id.tv1);
            tv2 = (TextView) itemView.findViewById(R.id.tv2);
        }

        public TextView getTv1() {
            return tv1;
        }

        public void setTv1(TextView tv1) {
            this.tv1 = tv1;
        }

        public TextView getTv2() {
            return tv2;
        }

        public void setTv2(TextView tv2) {
            this.tv2 = tv2;
        }
    }

    /**
     * 3 Adapter
     */
    public static class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        List<MyItem> items;

        public MyAdapter(List<MyItem> items) {
            this.items = items;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycler_view_simple_item, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            MyItem item = items.get(position);
            holder.tv1.setText(item.value1);
            holder.tv2.setText(item.value2);
        }

        @Override
        public int getItemCount() {
            return items.size();
        }
    }
}
