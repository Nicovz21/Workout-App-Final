package com.hfad.workoutmaker;

/**
 * Created by relkharboutly on 3/30/2016.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_EXERCISES = "exercises";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_EXPERIENCE = "experience";
    public static final String COLUMN_EQUIPMENT = "equipment";
    public static final String COLUMN_WORKOUT = "workout";
    public static final String COLUMN_MONDAY = "monday";
    public static final String COLUMN_TUESDAY = "tuesday";
    public static final String COLUMN_WEDNESDAY = "wednesday";
    public static final String DATABASE_NAME = "exercises.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_EXERCISES + "(" + COLUMN_ID
            + " integer primary key autoincrement, "+ COLUMN_EXPERIENCE + " text not null,  " + COLUMN_EQUIPMENT
            + " text not null, "+ COLUMN_WORKOUT
            + " text not null, "+ COLUMN_MONDAY + "text not null, "+ COLUMN_TUESDAY + "text not null, "+COLUMN_WEDNESDAY + "text not null );";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(com.hfad.workoutmaker.MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXERCISES);
        onCreate(db);
    }

}
