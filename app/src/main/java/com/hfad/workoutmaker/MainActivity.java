package com.hfad.workoutmaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

public class MainActivity extends FragmentActivity {
    public static WorkoutsDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//un-comment to re-create the database
//        dataSource = new WorkoutsDataSource(this);
//        dataSource.open();
//        //create beginner workouts with no weights
//        dataSource.createWorkout("beginner", "no weights", "push-ups (3 sets to failure)");
//        dataSource.createWorkout("beginner", "no weights", "squats (3 sets to failure)");
//        dataSource.createWorkout("beginner", "no weights", "hip bridges (2 sets to failure)");
//        dataSource.createWorkout("beginner", "no weights", "Jumping Jacks (1 minute)");
//        //create beginner workouts with weights
//        dataSource.createWorkout("beginner", "weights", "squats (3 sets of 12)");
//        dataSource.createWorkout("beginner", "weights", "bench press (3 sets of 12)");
//        dataSource.createWorkout("beginner", "weights", "calf raises (3 sets of 12)");
//        dataSource.createWorkout("beginner", "weights", "bicep curls (3 sets of 12)");
//        //create experienced workouts without weights
//        dataSource.createWorkout("experienced", "none", "inclined push-ups (3 sets to failure)");
//        dataSource.createWorkout("experienced", "none", "bulgarian split squats (3 sets to failure)");
//        dataSource.createWorkout("experienced", "none", "banded side steps (1 minute)");
//        dataSource.createWorkout("experienced", "none", "burpes (1 minute)");
//        //create experienced workouts with weights
//        dataSource.createWorkout("experienced", "weights", "side step ups (3 sets of 12)");
//        dataSource.createWorkout("experienced", "weights", "incline fly-press (3 sets of 12)");
//        dataSource.createWorkout("experienced", "weights", "seated dumbbell calf-rasies (3 sets of 12)");
//        dataSource.createWorkout("experienced", "weights", "lateral raises (3 sets of 12)");




        }




}