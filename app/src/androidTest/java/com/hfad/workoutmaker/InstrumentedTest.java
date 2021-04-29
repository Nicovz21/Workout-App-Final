//package com.hfad.workoutmaker;
//
//import android.database.sqlite.SQLiteDatabase;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.JUnit4;
//import java.util.List;
//import android.util.Log;
//import androidx.test.rule.ActivityTestRule;
//import androidx.test.platform.app.InstrumentationRegistry;
//import androidx.test.InstrumentationRegistry.getTargetContext;
//
//import static org.junit.Assert.*;
//
//@RunWith(JUnit4.class)
//public class SQLiteInstrumentedTest {
//    private SQLiteDatabase db;
//    private WorkoutsDataSource dataSource;
//
//    //what to use instead of data source
//
//    private static String experience;
//    private static String equipment;
//    private static String workout;
//
//
////    @Rule
////    public ActivityTestRule<WorkoutActivity> mySQLiteHelperActivityTestRule = new ActivityTestRule<>(MySQLiteHelper.class);
//
//    @Before
//    public void setUp() throws Exception {
//        getTargetContext().deleteDatabase(MySQLiteHelper.TABLE_EXERCISES);
//        dataSource = new WorkoutsDataSource(getTargetContext());
//        dataSource.open();
//        db = dataSource.getDatabase();
//    }
//
//    @Test
//    public void insertData() {
//
//        //onView (some id) perform ____
//        //onView (some id) check (matches (_____) )
//    }
//
//    @Test
//    public void getBeginnerAndNoEquipmentData() {
//
//        // from example
//        dataSource.createWorkout("beginner","no weights","push-ups");
//        List<Workout> wList = dataSource.getAllWorkouts();
//        assertEquals(wList.size(),1);
//        Log.i("test", String.valueOf(wList.get(0).getWorkout().equals("push-ups")));
//
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        dataSource.close();
//    }
//}