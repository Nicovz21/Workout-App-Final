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
//create table with strings made above
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL("create table " + TABLE_EXERCISES +" (_id INTEGER PRIMARY KEY AUTOINCREMENT,experience TEXT, equipment TEXT,workout TEXT)");
    }
//upgrade table version
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_EXERCISES);
        onCreate(db);
    }
    //insert data into data table
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
    //if someone is not experienced and does not own weights
    public Cursor getBeginnerAndNoEquipmentData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.query(TABLE_EXERCISES,new String[]{COLUMN_ID,COLUMN_EXPERIENCE, COLUMN_EQUIPMENT, COLUMN_WORKOUT}, COLUMN_EXPERIENCE + "=?" + " AND" +" "+ COLUMN_EQUIPMENT + "=?",new String[]{"beginner","no weights"},null,null,null);
       return res;
    }
    //if someone is not experienced and does own weights
    public Cursor getBeginnerAndEquipmentData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.query(TABLE_EXERCISES,new String[]{COLUMN_ID,COLUMN_EXPERIENCE, COLUMN_EQUIPMENT, COLUMN_WORKOUT}, COLUMN_EXPERIENCE + "=?" + " AND" +" "+ COLUMN_EQUIPMENT + "=?",new String[]{"beginner","weights"},null,null,null);
        return res;
    }
    //if someone is experienced and does not own weights
    public Cursor getExperiencedAndNoEquipmentData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.query(TABLE_EXERCISES,new String[]{COLUMN_ID,COLUMN_EXPERIENCE, COLUMN_EQUIPMENT, COLUMN_WORKOUT}, COLUMN_EXPERIENCE + "=?" + " AND" +" "+ COLUMN_EQUIPMENT + "=?",new String[]{"experienced","none"},null,null,null);
        return res;
    }
    //if someone is experienced and does own weights
    public Cursor getExperiencedAndEquipmentData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.query(TABLE_EXERCISES,new String[]{COLUMN_ID,COLUMN_EXPERIENCE, COLUMN_EQUIPMENT, COLUMN_WORKOUT}, COLUMN_EXPERIENCE + "=?" + " AND" +" "+ COLUMN_EQUIPMENT + "=?",new String[]{"experienced","weights"},null,null,null);
        return res;
    }
    //delete specific data in data table
    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
       return db.delete(TABLE_EXERCISES,"_id = ?",new String[] {id});
    }
    //delete all data in data table
    public void clearDatabase() {
        SQLiteDatabase db = this.getWritableDatabase();
        String clearDBQuery = "DELETE FROM "+TABLE_EXERCISES;
        db.execSQL(clearDBQuery);
        db.close();
    }

}
