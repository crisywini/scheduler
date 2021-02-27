package com.example.schedule.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "scheduler";
    private static final int VERSION = 1;
    public AdminSQLiteOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL1 = "CREATE TABLE IF NOT EXISTS "+DATABASE_NAME+".teacher (" +
                                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                    "name TEXT);";

        final String SQL3 = "CREATE TABLE IF NOT EXISTS "+DATABASE_NAME+".class(" +
                                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                    "name TEXT NOT NULL," +
                                    "description TEXT NOT NULL," +
                                    "id_teacher INTEGER NOT NULL," +
                                    "FOREIGN KEY(id_teacher) REFERENCES "+DATABASE_NAME+".teacher(id));";

        final String SQL2 = "CREATE TABLE IF NOT EXISTS "+DATABASE_NAME+".schedule (" +
                                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                    "start_time INTEGER NOT NULL, " +
                                    "end_time INTEGER NOT NULL," +
                                    "day TEXT NOT NULL," +
                                    "schedule_id INTEGER NOT NULL);";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}