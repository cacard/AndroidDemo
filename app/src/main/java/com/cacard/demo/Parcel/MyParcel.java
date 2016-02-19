package com.cacard.demo.Parcel;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by cunqingli on 2016/1/25.
 */
public class MyParcel implements Parcelable, Serializable {

    private static final long serialVersionUID = 5754698734715674934L;
    public MyParcel2[] array;


    public MyParcel() {
    }

    /**
     * 根据cursor创建对象。从数据库中反序列化。
     */
    public MyParcel(Cursor cursor) {
        byte[] buffer = cursor.getBlob(4);
        if(buffer!=null && buffer.length>0){
            Parcel parcel = Parcel.obtain();
            parcel.unmarshall(buffer, 0, buffer.length);
            parcel.setDataPosition(0);
            this.array = parcel.createTypedArray(MyParcel2.CREATOR);
            parcel.recycle();
        }
    }

    /**
     * 把对象转化成能够插入到数据库的ContentValue对象
     *
     * @return
     */
    public ContentValues getContentValue() {
        ContentValues cv = new ContentValues();
        Parcel parcel = Parcel.obtain();
        parcel.writeTypedArray(this.array, 0);
        cv.put("myparcel", parcel.marshall());
        parcel.recycle();
        return cv;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelableArray(this.array, 0);
    }

    protected MyParcel(Parcel in) {
        this.array = (MyParcel2[]) in.readParcelableArray(MyParcel2.class.getClassLoader());
    }

    public static final Creator<MyParcel> CREATOR = new Creator<MyParcel>() {
        public MyParcel createFromParcel(Parcel source) {
            return new MyParcel(source);
        }

        public MyParcel[] newArray(int size) {
            return new MyParcel[size];
        }
    };
}
