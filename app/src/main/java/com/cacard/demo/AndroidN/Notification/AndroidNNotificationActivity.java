package com.cacard.demo.AndroidN.Notification;

import android.app.Activity;
import android.app.Notification;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.cacard.demo.MyApplication;
import com.cacard.demo.R;

/**
 * Created by cunqingli on 2016/8/3.
 */
public class AndroidNNotificationActivity extends Activity {

    private static final String GroupKey = "somekey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);

        // normal
        Button btn1 = new Button(this);
        btn1.setText("General Notification");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MyApplication.instance);
                builder.setContentTitle("Title");
                builder.setContentText("Text");
                builder.setSmallIcon(R.drawable.ic_launcher);
                Notification notification = builder.build();
                NotificationManagerCompat.from(MyApplication.instance).notify((int) System.currentTimeMillis(), notification);
            }
        });
        ll.addView(btn1);

        // group
        Button btn2 = new Button(this);
        btn2.setText("Group Notification");
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeGroupNotification();
            }
        });
        ll.addView(btn2);

        setContentView(ll);

    }


    private void makeGroupNotification() {
        for (int i = 0; i <= 2; i++) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(MyApplication.instance);
            builder.setContentTitle("Title" + i);
            builder.setContentText("Text");
            builder.setSmallIcon(R.drawable.ic_launcher);
            if (i == 0) {
                builder.setGroupSummary(true); // 必须有一次设定Summary，下面的notification才会分组。
            }                                  // 觉得这个功能不太好。自动分组那个就足够了。
            builder.setGroup(GroupKey); // 仅仅设置这个，超过3个也不会分组；
            Notification notification = builder.build();
            NotificationManagerCompat.from(MyApplication.instance).notify((int) System.currentTimeMillis(), notification);
        }
    }

}
