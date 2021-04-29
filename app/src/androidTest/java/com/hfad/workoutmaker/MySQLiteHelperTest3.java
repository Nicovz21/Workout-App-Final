package com.hfad.workoutmaker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import androidx.test.core.app.ApplicationProvider;
//import androidx.test.InstrumentationRegistry.getTargetContext;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MySQLiteHelperTest3 extends TestCase {

    private Context context;
    private MySQLiteHelper myDB;
    private static String experience;
    private static String equipment;
    private static String workout;
    private SQLiteDatabase db;
    private long workoutID;

    @Before
    public void setUp() throws Exception {
        Context context = ApplicationProvider.getApplicationContext();
     //   getTargetContext().deleteDatabase(MySQLiteHelper.TABLE_EXERCISES);
        myDB = new MySQLiteHelper(context);
        db = myDB.getReadableDatabase();
    }


    @Test
    public void databaseInsertionTest() {

        experience = "beginner";
        equipment = "no weights";
        workout = "push-ups";

        ContentValues contentValues = new ContentValues();
        contentValues.put(MySQLiteHelper.COLUMN_EXPERIENCE, experience);
        contentValues.put(MySQLiteHelper.COLUMN_EQUIPMENT, equipment);
        contentValues.put(MySQLiteHelper.COLUMN_WORKOUT, workout);

        workoutID = db.insert(MySQLiteHelper.TABLE_EXERCISES, null, contentValues);

        Cursor cursor = db.query(MySQLiteHelper.TABLE_EXERCISES, new String[]
                {MySQLiteHelper.COLUMN_ID, MySQLiteHelper.COLUMN_EXPERIENCE,
                        MySQLiteHelper.COLUMN_EQUIPMENT, MySQLiteHelper.COLUMN_WORKOUT},
                MySQLiteHelper.COLUMN_ID + " = " + workoutID,
                null,null,null,null);

        assertTrue(cursor.moveToFirst());

        int experienceColumnIndex = cursor.getColumnIndex(MySQLiteHelper.COLUMN_EXPERIENCE);
        String dbExperience = cursor.getString(experienceColumnIndex);

        int equipmentColumnIndex = cursor.getColumnIndex(MySQLiteHelper.COLUMN_EQUIPMENT);
        String dbEquipment = cursor.getString(equipmentColumnIndex);

        int workoutColumnIndex = cursor.getColumnIndex(MySQLiteHelper.COLUMN_WORKOUT);
        String dbWorkout = cursor.getString(workoutColumnIndex);

        assertEquals(experience, dbExperience);
        assertEquals(equipment, dbEquipment);
        assertEquals(workout, dbWorkout);
    }

    @After
    public void tearDown() throws Exception {
       myDB.close();
    }
}