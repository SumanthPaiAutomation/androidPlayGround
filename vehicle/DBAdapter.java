package com.example.csc.vehicle;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter {
    static final String NUMBER = "vehicle_id";
    static final String VEHICLE_NAME = "vehicle_name";
    static final String OWNER = "vehicle_owner";
    static final String MAKE_YEAR = "make_year";
    static final String TAG = "DBAdapter";
    static final String DATABASE_NAME = "VehicleDB";
    static final String DATABASE_TABLE = "vehicle_table";
    static final int DATABASE_VERSION = 2;
    static final String DATABASE_CREATE = "create table vehicle_table(vehicle_id integer primary key," + "vehicle_name text not null,vehicle_owner text not null,make_year integer not null);";

    final Context context;
    DatabaseHelper DBHelper;
    SQLiteDatabase db;

    public DBAdapter(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
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
    }

    public DBAdapter open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        DBHelper.close();
    }

    public long insertVehicleDetails(Integer num, String name, String owner, Integer year) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(NUMBER, num);
        initialValues.put(VEHICLE_NAME, name);
        initialValues.put(OWNER, owner);
        initialValues.put(MAKE_YEAR, year);
        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    public Cursor getAllVehicleDetails()
    {
        return db.query(DATABASE_TABLE, new String[] {NUMBER, VEHICLE_NAME,
                OWNER, MAKE_YEAR}, null, null, null, null, null);
    }
    public boolean updateVehicleDetails(Integer num, String name, String owner, Integer year)
    {
        ContentValues args = new ContentValues();
        args.put(VEHICLE_NAME, name);
        args.put(OWNER, owner);
        args.put(MAKE_YEAR, year);
        return db.update(DATABASE_TABLE, args, NUMBER + "=" + num, null) > 0;
    }




}


