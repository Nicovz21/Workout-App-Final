package com.hfad.workoutmaker;

/**
 * Created by relkharboutly on 3/30/2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_EXERCISES = "exercises";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_EXPERIENCE = "experience";
    public static final String COLUMN_EQUIPMENT = "equipment";
    public static final String COLUMN_WORKOUT = "workout";
    public static final String DATABASE_NAME = "exercises.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement


    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL("create table " + TABLE_EXERCISES +" (_id INTEGER PRIMARY KEY AUTOINCREMENT,experience TEXT, equipment TEXT,workout TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_EXERCISES);
        onCreate(db);
    }
    public boolean insertData(String experience, String equipment, String workout){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_EXPERIENCE, experience);
        contentValues.put(COLUMN_EQUIPMENT, equipment);
        contentValues.put(COLUMN_WORKOUT, workout);
        long result = db.insert(TABLE_EXERCISES, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public Cursor getBeginnerAndEquipmentData(){
        SQLiteDatabase db = this.getWritableDatabase();
        //Cursor res = db.rawQuery("SELECT equipment, experience FROM exercises WHERE experience = ? AND equipment = ?", new String[] {"beginner", "weights"});
        Cursor res = db.rawQuery("select * from "  + TABLE_EXERCISES, null);
        Cursor two = db.query(TABLE_EXERCISES,new String[]{COLUMN_ID,COLUMN_EXPERIENCE, COLUMN_EQUIPMENT, COLUMN_WORKOUT}, COLUMN_EXPERIENCE + "=?" + " AND" +" "+ COLUMN_EQUIPMENT + "=?",new String[]{"beginner","no weights"},null,null,null);
//        if (res.moveToFirst()) {
//            return res;
//        }

       return two;

    }
    public Cursor getBeginnerData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor trytwo = db.query("exercises",new String[]{"experience"}, "experience=?",new String[]{"beginner"},null,null,null);
        Cursor res = db.rawQuery("select " + COLUMN_WORKOUT+ " from "  + TABLE_EXERCISES, null);
        return trytwo;
    }
    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
       return db.delete(TABLE_EXERCISES,"_id = ?",new String[] {id});
    }
    public void clearDatabase() {
        SQLiteDatabase db = this.getWritableDatabase();
        String clearDBQuery = "DELETE FROM "+TABLE_EXERCISES;
        db.execSQL(clearDBQuery);
        db.close();
    }

}
