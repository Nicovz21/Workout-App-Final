package com.hfad.workoutmaker;

/**
 * Created by relkharboutly on 3/30/2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class WorkoutsDataSource {

    // Database fields
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_EXPERIENCE, MySQLiteHelper.COLUMN_EQUIPMENT, MySQLiteHelper.COLUMN_WORKOUT, MySQLiteHelper.COLUMN_MONDAY, MySQLiteHelper.COLUMN_TUESDAY, MySQLiteHelper.COLUMN_WEDNESDAY };

    public WorkoutsDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }
    public  SQLiteDatabase getDatabase() {return database;}
    public void close(){
        dbHelper.close();
    }

    public Workout createWorkout(String experience) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_EXPERIENCE, experience);
        long insertId = database.insert(MySQLiteHelper.TABLE_EXERCISES,null, values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_EXERCISES, allColumns, MySQLiteHelper.COLUMN_ID + "=" + insertId, null, null, null, null);
        cursor.moveToFirst();
        Workout newWorkout = cursorToWorkout(cursor);
        cursor.close();

        return newWorkout;
    }

    public void deleteWorkout(Workout workout) {
        long id = workout.getId();
        database.delete(MySQLiteHelper.TABLE_EXERCISES, MySQLiteHelper.COLUMN_ID + "="+ id, null);
    }

    public List<Workout> getAllWorkouts() {
        List<Workout> workouts = new ArrayList<Workout>();
        //select * from comments;
        Cursor cursor = database.query(MySQLiteHelper.TABLE_EXERCISES,allColumns,null,null, null, null, null);
        cursor.moveToFirst();
        while(! cursor.isAfterLast()){
            Workout workout = cursorToWorkout(cursor);
            workouts.add(workout);
            cursor.moveToNext();
        }
        cursor.close();
        return workouts;
    }

    private Workout cursorToWorkout(Cursor cursor) {
        Workout workout = new Workout();
        workout.setId(cursor.getLong(0));
        workout.setWorkout(cursor.getString(1));
        return workout;
    }
}