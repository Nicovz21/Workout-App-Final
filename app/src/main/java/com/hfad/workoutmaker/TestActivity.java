package com.hfad.workoutmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        TextView workoutDesc = (TextView) findViewById(R.id.testText);
        WorkoutsDataSource dataSource = new WorkoutsDataSource(this);
        dataSource.open();

    }
}