/**
 * Loader(CursorLoader) + SimpleCursortAdapter + ListView
 * 
 */

package com.cacard.androiddemo.thread;

import com.cacard.androiddemo.R;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Browser;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;

public class Loader_CursorLoader_SimpleCursorAdapter extends Activity implements LoaderManager.LoaderCallbacks<Cursor> {

	private Uri contentUri = Browser.BOOKMARKS_URI;
	private SimpleCursorAdapter adp = null;
	private ListView lv = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.setContentView(R.layout.loader_cursorloader_simplecursoradapter_activity);
		lv = (ListView)this.findViewById(R.id.lv);
		
		adp = new SimpleCursorAdapter(this,
				R.layout.loader_cursorloader_simplecursoradapter_item,
				null, // cursor一开始是null
				new String[]{"_id","_id"}, // from
				new int[]{R.id.tv1,R.id.tv2}, // to
				0);
		
		lv.setAdapter(adp);
		
		this.getLoaderManager().initLoader(0, null, this);
		
	}

	/**
	 * 创建一个CursorLoader
	 */
	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle args) {
		
		Log.i("test","onCreateLoader");
		
		// 结合ContentProvider创建一个CursorLoader
		return new CursorLoader(
				Loader_CursorLoader_SimpleCursorAdapter.this,
				contentUri,
				new String[]{"_id","_id"},
				null,null,null);
	}

	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
		adp.swapCursor(data);
	}

	@Override
	public void onLoaderReset(Loader<Cursor> loader) {
		adp.swapCursor(null);
	}

}
