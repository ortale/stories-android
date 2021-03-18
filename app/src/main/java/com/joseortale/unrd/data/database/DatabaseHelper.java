package com.joseortale.unrd.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.joseortale.unrd.AppCons;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Videos.db";

    private static final String STORIES_TABLE =
            "CREATE TABLE " + AppCons.STORIES_TABLE + " (" +
                    AppCons.STORIES_TABLE_ID + " INTEGER UNIQUE," +
                    AppCons.STORIES_TABLE_NAME + " TEXT," +
                    AppCons.STORIES_TABLE_SHORT_SUMMARY + " TEXT," +
                    AppCons.STORIES_TABLE_FULL_SUMMARY + " TEXT)";

    private static final String SQL_DELETE_STORIES_TABLE =
            "DROP TABLE IF EXISTS " + AppCons.STORIES_TABLE;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(STORIES_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_STORIES_TABLE);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}

