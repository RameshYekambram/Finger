package com.example.mylap3.savepasswordssql;

import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelpler extends SQLiteOpenHelper {

    public static final String Table_name = "user";
    public static final String DATABASE_NAME = "UserDetails";
    public static final String id = "ID";
    public static final String userid = "NAME";
    public static final String password = "pass";

    public DataBaseHelpler(Context context) {
        super( context, DATABASE_NAME, null, 1 );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( "create Table " + Table_name + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Table_name);
        onCreate(db);
    }

    public boolean insert(String Username) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues Content = new ContentValues();
        Content.put( userid, Username );


        long result = db.insert( Table_name, null, Content );

        if (result == -1) {

            return false;
        } else {
            return true;
        }

    }

    public Cursor getdata() {


    SQLiteDatabase Db = this.getWritableDatabase();
    Cursor data = Db.rawQuery( "select * from " + Table_name, null );
    return  data;
      }

      public  Integer delete(String id){
        SQLiteDatabase Db = this.getWritableDatabase();
        return  Db.delete( Table_name,"ID= ?",new String[] {id});

      }
 }
