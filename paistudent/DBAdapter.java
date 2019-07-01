package com.example.csc.paistudent;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by CSC on 1/29/2018.
 */

public class DBAdapter {

    static final  String NAME="student_name";
    static final  String USN="student_usn";
    static final  String SEM="student_sem";
    static final  String CGPA= "student_cgpa";
    static final int DATABASE_VERSION=1;
    static  final String TAG="DBAdapter";
    static final String DATABASE_NAME="studentDB";
    static final String DATABASE_TABLE="student_table";

    static final String DATABASE_CREATE="create table student_table(student_name text primary key,"+"student_usn text not null,student_sem text not null,student_cgpa Integer not null);";

    final Context context;
    DatabaseHelper DBHelper;
    SQLiteDatabase db;

    public void DBAdpater(Context ctx){

        this.context=ctx;
        DBHelper= new DatabaseHelper(context);

    }

    private static DatabaseHelper extends SQLiteOpenHelper{


         DatabaseHelper(Context context){

            super(context,DATABASE_NAME,null,DATABASE_VERSION);

        }
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(DATABASE_CREATE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }


    public DBAdapter open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        DBHelper.close();
    }


    }





