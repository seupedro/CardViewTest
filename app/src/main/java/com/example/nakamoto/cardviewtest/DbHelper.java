package com.example.nakamoto.cardviewtest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.nakamoto.cardviewtest.DbContract.AquaEntry.NAME_COLUMN;
import static com.example.nakamoto.cardviewtest.DbContract.AquaEntry.TEST_TABLE;
import static com.example.nakamoto.cardviewtest.DbContract.AquaEntry._testID;

public class DbHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "test.db";

    // Create Aqua Table
    public static final String SQL_CREATE_TEST =
            "CREATE TABLE " + TEST_TABLE + " (" +
                    _testID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NAME_COLUMN + " TEXT NOT NULL " + " )";

    // SQL Delete Aqua
    public static final String SQL_DELETE_TEST =
            "DROP TABLE IF EXISTS " + TEST_TABLE;


    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TEST);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TEST);
        onCreate(db);
    }
}
