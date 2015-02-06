/**
 * 1 实现SQLiteOpenHelper以创建/管理数据库实例（SQLiteDatabase）
 * 2 使用SQLiteDatabase进行CURD
 */

package com.cacard.androiddemo.db;

import com.cacard.androiddemo.helper.LogHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class SQLiteDemo {

	public static void startTest(Context ctx)
	{
		SQLiteOpenHelperDemo helper = new SQLiteOpenHelperDemo(ctx);
		SQLiteDatabase db = helper.getWritableDatabase();
		
		// insert some data to table 'user'
		for(int i=0;i<10;i++){
			String sql = "INSERT INTO "+SQLiteOpenHelperDemo.TABLE_NAME_USER+" (name,age) values ('user"+i+"',"+i+")";
			db.execSQL(sql);
		}
		
		// query the count of table 'user'
		String sqlCount="SELECT COUNT(*) from "+SQLiteOpenHelperDemo.TABLE_NAME_USER+"";
		Cursor cursor = db.rawQuery(sqlCount, null);
		if(cursor!=null){
			cursor.moveToFirst();
			int count = cursor.getInt(0);
			LogHelper.write("count of user table:"+count+"");
			cursor.close();
		}
		
		// query all
		String sqlQueryAll="SELECT * from "+SQLiteOpenHelperDemo.TABLE_NAME_USER+"";
		Cursor c = db.rawQuery(sqlQueryAll, null);
		if(c!=null){
			while(c.moveToNext()){
				String name = c.getString(0);
				int age = c.getInt(1);
				LogHelper.write("->name:"+name+"/age:"+age);
			}
			c.close();
		}
		
		// delete all
		String sqlDelete = "DELETE from "+SQLiteOpenHelperDemo.TABLE_NAME_USER;
		db.execSQL(sqlDelete);
		
		db.close();
	}
	
}
