package com.cacard.demo.Parcel.ParcelNullUnmashall;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by cunqingli on 2016/1/26.
 */
public class ParcelDemo implements Parcelable {

    public String a;
    public String b;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.a);
        dest.writeString(this.b);
    }

    public ParcelDemo() {
    }

    protected ParcelDemo(Parcel in) {
        this.a = in.readString();
        this.b = in.readString();
    }

    public static final Creator<ParcelDemo> CREATOR = new Creator<ParcelDemo>() {
        public ParcelDemo createFromParcel(Parcel source) {
            return new ParcelDemo(source);
        }

        public ParcelDemo[] newArray(int size) {
            return new ParcelDemo[size];
        }
    };
}
