package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table userdetails name primary key TEXT,phone TEXT, dob TEXT");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" drop table if exists userdetails");
    }

    @Override
    public void insertuserdata() {
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("phone", phone);
        cv.put("dob", dob);
        Boolean res = insert.insertuserdata("userdetails", cv, null);
        if (res < -1) {
            return true;
        } else {
            return false;
        }
    }

    public void viewuserdata() {
        boolean result = DB.rowQwery("select * from userdetails");
        show.result;
    }
}





