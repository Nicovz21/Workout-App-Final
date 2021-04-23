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

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }
    public  SQLiteDatabase getDatabase() {return database;}
    public void close(){
        dbHelper.close();
    }

    public Workout createWorkout(String experience, String equipment, String workout) {
            ContentValues values = new ContentValues();
                values.put(MySQLiteHelper.COLUMN_EXPERIENCE, experience);
                values.put(MySQLiteHelper.COLUMN_EQUIPMENT, equipment);
                values.put(MySQLiteHelper.COLUMN_WORKOUT, workout);
            long insertId = database.insert(MySQLiteHelper.TABLE_EXERCISES, null, values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_EXERCISES, allColumns, MySQLiteHelper.COLUMN_ID + "=" + insertId, null, null, null, null);
        cursor.moveToFirst();
        Workout newWorkout = cursorToWorkout(cursor);
        cursor.close();

        return newWorkout;
    }
    //createall workouts
    //call createworkout many times to add 6 or 7 workouts

    public void deleteWorkout(Workout workout) {
        long id = workout.getId();
        database.delete(MySQLiteHelper.TABLE_EXERCISES, MySQLiteHelper.COLUMN_ID + "="+ id, null);
    }
//get specific workout from this method
    public List<Workout> getAllWorkouts() {
        //select * from workouts;
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
    //get workout with experience: beginner and no weights
    public ArrayList<String> getWorkoutByBeginnerAndNoWeights(){

        Cursor cursor = database.query(MySQLiteHelper.TABLE_EXERCISES, workoutColumns, MySQLiteHelper.COLUMN_EXPERIENCE + "=" + "beginner" + "AND" + MySQLiteHelper.COLUMN_EQUIPMENT + "=" + "no weights", null, null, null, null);
        while(!cursor.isLast()){
            int i=0;
            String workouts =cursor.getString(i++);
            workoutArray.add(workouts);

        }

        //return string array
        return workoutArray;
    }
    public String getTest(){
        Cursor cursor = database.query(MySQLiteHelper.TABLE_EXERCISES, workoutColumns, MySQLiteHelper.COLUMN_EXPERIENCE + "=" + "beginner" + "AND" + MySQLiteHelper.COLUMN_EQUIPMENT + "=" + "no weights", null, null, null, null);
    }


    //get workout with experience: beginner and weights
    public String getWorkoutByBeginnerAndWeights(){
        //loop through getAllWorkouts
        for(int i = 0; i< workouts.size(); i++){
            //filter list by experience
            if(workouts.contains("beginner") && workouts.contains("weights")){
                //return  workouts.indexOf(i).toString();
            }
        }
        return null;
    }

    //get workout with experience: experienced and no weights
    public String getWorkoutByExperiencedAndNoWeights(){
        //loop through getAllWorkouts
        for(int i = 0; i< workouts.size(); i++){
            //filter list by equipment
            if(workouts.contains("experienced") && workouts.contains("no weights")){
                //return  workouts.indexOf(i).toString();
            }
        }
        return null;
    }
    //get workout with experience: experienced and weights
    public String getWorkoutByExperiencedAndWeights(){
        //loop through getAllWorkouts
        for(int i = 0; i< workouts.size(); i++){
            //filter list by equipment
            if(workouts.contains("experienced") && workouts.contains("weights")){
                //return  workouts.indexOf(i);
            }
        }
        return null;
    }

    private Workout cursorToWorkout(Cursor cursor) {
        Workout workout = new Workout();
        workout.setId(cursor.getLong(0));
        workout.setWorkout(cursor.getString(1));
        return workout;
    }



}