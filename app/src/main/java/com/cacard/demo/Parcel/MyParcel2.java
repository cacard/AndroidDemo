package com.cacard.demo.Parcel;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by cunqingli on 2016/1/25.
 */
public class MyParcel2 implements Parcelable {
    private String a;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.a);
    }

    public MyParcel2() {
    }

    public MyParcel2(String v) {
        this.a = v;
    }

    protected MyParcel2(Parcel in) {
        this.a = in.readString();
    }

    public static final Creator<MyParcel2> CREATOR = new Creator<MyParcel2>() {
        public MyParcel2 createFromParcel(Parcel source) {
            return new MyParcel2(source);
        }

        public MyParcel2[] newArray(int size) {
            return new MyParcel2[size];
        }
    };
}
