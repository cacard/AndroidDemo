package com.cacard.androiddemo.contentprovider;

import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Browser;
import android.util.Log;

public class ContentProviderDemo extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // query
        ContentResolver cr = this.getContentResolver();
        Cursor c = cr.query(
                Browser.BOOKMARKS_URI,//UserDictionary.Words.CONTENT_URI,
                null, null, null, null);
        if (c != null) {
            while (c.moveToNext()) {
                Log.i("test", c.getString(0) + "," + c.getString(1) + "," + c.getString(2));
            }
        } else {
            Log.i("test", "cursor is null.");
        }

        ContentProviderOperation.newInsert(null).build();
    }

}
