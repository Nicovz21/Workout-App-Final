package com.hfad.workoutmaker;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class WorkoutsDataSource {
    List<Workout> workouts = new ArrayList<Workout>();
    // Database fields
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_EXPERIENCE, MySQLiteHelper.COLUMN_EQUIPMENT, MySQLiteHelper.COLUMN_WORKOUT };
    private String[] workoutColumns = { MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_WORKOUT };
    public ArrayList<String> workoutArray = new ArrayList<String>();;

    public WorkoutsDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }
//open database
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }
    public  SQLiteDatabase getDatabase() {return database;}
    public void close(){
        dbHelper.close();
    }
//create workout to put in database
    public Workout createWorkout(String experience, String equipment, String workout) {
            ContentValues values = new ContentValues();
                values.put(MySQLiteHelper.COLUMN_EXPERIENCE, experience);
                values.put(MySQLiteHelper.COLUMN_EQUIPMENT, equipment);
                values.put(MySQLiteHelper.COLUMN_WORKOUT, workout);
            long insertId = database.insert(MySQLiteHelper.TABLE_EXERCISES, null, values);
            //create cursor for adding all columns and going id 0 - infinity
        Cursor cursor = database.query(MySQLiteHelper.TABLE_EXERCISES, allColumns, MySQLiteHelper.COLUMN_ID + "=" + insertId, null, null, null, null);
        cursor.moveToFirst();
        Workout newWorkout = cursorToWorkout(cursor);
        //close cursor
        cursor.close();

        return newWorkout;
    }

    //set cursor in workout
    private Workout cursorToWorkout(Cursor cursor) {
        Workout workout = new Workout();
        workout.setId(cursor.getLong(0));
        workout.setWorkout(cursor.getString(1));
        return workout;
    }



}