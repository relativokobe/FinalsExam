package com.usjr.finalsexam.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHandler extends SQLiteOpenHelper {

    private static final int    DB_VERSION = 1;
    private static final String DB_NAME    = "FinalsExam";

    private static DbHandler sInstance = null;

    public DbHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static DbHandler getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DbHandler(context);
        }
        return sInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(VideoTable.createTableQuery());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL(VideoTable.dropTableQuery());
            onCreate(db);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
