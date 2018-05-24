package com.example.nakamoto.cardviewtest;

import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.Loader;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import static com.example.nakamoto.cardviewtest.DbContract.AquaEntry.NAME_COLUMN;
import static com.example.nakamoto.cardviewtest.DbContract.AquaEntry.TEST_TABLE;

public class MainActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<Cursor> {

    private final int LOADER_ID = 0;
    private DbHelper helper;
    private SQLiteDatabase db;
    private RecyclerView recyclerView;
    private ListCursorAdapter cursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Initialize */
        cursorAdapter = new ListCursorAdapter(this, null);
        helper = new DbHelper(this);

        /* Setup Recycler */
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setAdapter(cursorAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getLoaderManager().initLoader(LOADER_ID, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        db = helper.getWritableDatabase();

        /* Create dummy data to test */
        int i = 0;
        while (i < 10){

            ContentValues values = new ContentValues();
            values.put(NAME_COLUMN, String.valueOf(i));

            db.insert(TEST_TABLE, null, values);
            values.clear();
            i++;
        }
        return new CustomCursorLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        cursorAdapter.swapCursor(cursor);
        cursorAdapter = new ListCursorAdapter(this, cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        cursorAdapter.swapCursor(null);
    }
}
