package com.example.friendlist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="friends.db";
    public static final String TABLE_NAME="friends_table";
    public static final String COL_1="FIRSTNAME";
    public static final String COL_2="LASTNAME";
    public static final String COL_3="EMAIL";
    private String lastname;
    private String firstname;
    private String email;


    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME ,null , 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db . execSQL("create table(FIRSTNAME TEXT PRIMARY KEY AUTOINCREAMENT, LASTNAME TEXT,EMAIL VARCHAR)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    onCreate(db);
    }
    public boolean insertData(String firstname , String lastname,String email){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,firstname);
        contentValues.put(COL_2,lastname);
        contentValues.put(COL_3,email);
        db.insert(TABLE_NAME,null,contentValues);


        return false;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String id,String name,String surname,String marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,firstname);
        contentValues.put(COL_2,lastname);
        contentValues.put(COL_3,email);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        boolean b = true;
        return b;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }
}


