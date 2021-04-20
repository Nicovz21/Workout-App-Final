package com.hfad.workoutmaker;

/**
 * Created by relkharboutly on 3/30/2016.
 */
import android.content.ContentValues;
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
//    public static final String COLUMN_MONDAY = "monday";
//    public static final String COLUMN_TUESDAY = "tuesday";
//    public static final String COLUMN_WEDNESDAY = "wednesday";
    public static final String DATABASE_NAME = "exercises.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_EXERCISES + "(" + COLUMN_ID
            + " integer primary key autoincrement, "+ COLUMN_EXPERIENCE + " text not null,  " + COLUMN_EQUIPMENT
            + " text not null, "+ COLUMN_WORKOUT
            + " text not null);";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXERCISES);
        onCreate(db);
    }
//    private static void insertWorkout(SQLiteDatabase db, String workout, String experience, String equipment){
//        ContentValues workoutValues = new ContentValues();
//        workoutValues.put("EXPERIENCE", experience);
//        workoutValues.put("EQUIPMENT", equipment);
//        workoutValues.put("WORKOUT", workout);
//        db.insert("WORKOUT", null, workoutValues);
//    }
//    private void updateMyDatabse(SQLiteDatabase db, int oldVersion, int newVersion){
//        if (oldVersion < 1){
//            db.execSQL("CREATE TABLE WORKOUT ("
//                    + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
//                    + "WORKOUT TEXT, "
//                    + "EXPERIENCE TEXT, "
//                    + "EQUIPMENT TEXT);");
//            insertWorkout(db, "Push-ups", "Beginner", "none");
//            insertWorkout(db, "Bench Press", "Beginner", "weights");
//            insertWorkout(db, "Bicep Curls", "Beginner", "weights");
//        }
//        if (oldVersion < 2){
//            db.execSQL("ALTER TABLE DRINK ADD COLUMN FAVORITE NUMERIC;");
//        }
//    }

}
