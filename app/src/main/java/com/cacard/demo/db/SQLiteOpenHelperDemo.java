package com.cacard.demo.db;

import com.cacard.demo.Util.LogHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * SQLiteOpenHelper用于创建/更新数据库实例（SQLiteDatabase）
 */
public class SQLiteOpenHelperDemo extends SQLiteOpenHelper {

	private static final int DB_VERSION=1;
	private static final String DB_NAME="demo";
	public static final String TABLE_NAME_USER="users";
	private static final String SQL_TABLE_USER_CREATE="CREATE TABLE "+TABLE_NAME_USER+" (name TEXT,age,INTEGER) ";
	
	public SQLiteOpenHelperDemo(Context context) {
		super(context, DB_NAME,null,DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// create user table
		db.execSQL(SQL_TABLE_USER_CREATE);
		db.close();
		LogHelper.write("SQLiteOpenHelper->onCreate()");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		LogHelper.write("SQLiteOpenHelper->onUpgrade()");
	}

}
