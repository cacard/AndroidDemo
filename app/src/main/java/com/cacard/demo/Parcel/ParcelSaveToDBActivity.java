package com.cacard.demo.Parcel;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.cacard.demo.launchmode.FlagActivityNewTask.ActivityStart;

/**
 * 目的是测试Parcel序列化后存储到数据库，如果Parcel对象结构发生变化，那么读取的时候会有问题吗？
 * <p/>
 * Created by cunqingli on 2016/1/25.
 */
public class ParcelSaveToDBActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);

        Button btn1 = new Button(this);
        btn1.setText("write");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                write();
            }
        });

        Button btn2 = new Button(this);
        btn2.setText("read");
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                read();
            }
        });

        ll.addView(btn1);
        ll.addView(btn2);
        this.setContentView(ll);
    }

    private void write() {
        MyParcel parcel = new MyParcel();
        parcel.array = new MyParcel2[]{new MyParcel2("a"), new MyParcel2("b")};
        MySQLiteOpenHelper.writeParcel2DB(parcel, this);
    }

    private void read() {
        MySQLiteOpenHelper.readFromDB(this);
    }

}
