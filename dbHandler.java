package com.example.sheoran.myproject;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;

public class dbHandler extends SQLiteOpenHelper{


    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="details.db";

    public static final String TABLE_NAME ="details_database_table";
    public static final String COLUMN_ID="_id";
    public static final String COLUMN_UNAME ="_uname";
    public static final String COLUMN_EMAIL ="_email";
    public static final String COLUMN_PASSWORD ="_password";
    public static final String COLUMN_CONFIRM_PASSWORD ="_confirm_password";

    public dbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query="CREATE TABLE "+TABLE_NAME+" ("+
                COLUMN_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COLUMN_UNAME+" TEXT, "+
                COLUMN_EMAIL+" TEXT, "+
                COLUMN_PASSWORD+" TEXT, "+
                COLUMN_CONFIRM_PASSWORD+" TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXIST "+TABLE_NAME+";");
        onCreate(db);
    }

    //Adding a new record

    public void AddRecord(Details_Database Details_Database) {

        ContentValues list=new ContentValues();
        list.put(COLUMN_UNAME,Details_Database.get_uname());
        list.put(COLUMN_EMAIL,Details_Database.get_email());
        list.put(COLUMN_PASSWORD,Details_Database.get_password());
        list.put(COLUMN_CONFIRM_PASSWORD,Details_Database.get_confirm_password());

        SQLiteDatabase db=getWritableDatabase();
        db.insert(TABLE_NAME,null,list);
        db.close();
    }

    public int CheckRecord(Details_Database D_Database){

        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM "+TABLE_NAME+";";
        Cursor c=db.rawQuery(query,null);

        c.moveToFirst();

        int flag=0;
        while(!c.isAfterLast())
        {
            if((D_Database.get_uname().equals(c.getString(c.getColumnIndex(COLUMN_UNAME))))&&(D_Database.get_password().equals(c.getString(c.getColumnIndex(COLUMN_PASSWORD)))))
            {
                flag=1;
            }
            c.moveToNext();
        }
        return flag;
    }
}