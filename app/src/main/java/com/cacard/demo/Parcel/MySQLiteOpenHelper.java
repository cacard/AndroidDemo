package com.cacard.demo.Parcel;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.cacard.demo.Util.LogHelper;

/**
 * SQLiteOpenHelper用于创建/更新数据库实例（SQLiteDatabase）
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "demo3";
    public static final String TABLE_NAME_USER = "parcel_save";
    private static final String SQL_TABLE_USER_CREATE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_USER + " ('myparcel' BLOB); ";

    public MySQLiteOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create user table
        db.execSQL(SQL_TABLE_USER_CREATE);
//        try {
//            db.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        LogHelper.write("SQLiteOpenHelper->onCreate()");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        LogHelper.write("SQLiteOpenHelper->onUpgrade()");
    }


    /**
     * 把Parcel数据类型序列化后写入数据库
     *
     * @param parcel
     * @param ctx
     */
    public static void writeParcel2DB(MyParcel parcel, Context ctx) {
        MySQLiteOpenHelper helper = new MySQLiteOpenHelper(ctx);
        SQLiteDatabase db = helper.getWritableDatabase();
        try {
            db.beginTransaction();
            db.insert(TABLE_NAME_USER, null, parcel.getContentValue());
            db.endTransaction();
        } finally {
            if (db != null) {
                db.close();
            }
        }

    }

    public static void readFromDB(Context ctx) {
        MySQLiteOpenHelper helper = new MySQLiteOpenHelper(ctx);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = null;
        MyParcel item = null;
        try {
            cursor = db.query(TABLE_NAME_USER, null, null, null, null, null, null);
            int c = cursor.getCount();
            if (cursor.moveToFirst()) {
                item = new MyParcel(cursor);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (cursor != null) {
                cursor.close();
                cursor = null;
            }
            if (db != null) {
                db.close();
            }
        }


    }
}