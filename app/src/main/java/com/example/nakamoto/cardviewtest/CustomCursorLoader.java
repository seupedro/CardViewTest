package com.example.nakamoto.cardviewtest;

import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;

import static com.example.nakamoto.cardviewtest.DbContract.AquaEntry.TEST_TABLE;

public class CustomCursorLoader extends CursorLoader {

    private Context mContext;
    public CustomCursorLoader(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public Cursor loadInBackground() {
        Cursor cursor = new DbHelper(mContext).getWritableDatabase().query(TEST_TABLE,
                null,
                null,
                null,
                null,
                null,
                null);

        return cursor;

    }
}
