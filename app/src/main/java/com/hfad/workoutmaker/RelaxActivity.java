package com.hfad.workoutmaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class RelaxActivity extends AppCompatActivity {
RelaxFragment relax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relax);

    }

    public RelaxFragment getRelax() {
        return relax;
    }

    public void nextButton(View view) {
        Intent intent = new Intent(this, PreferenceActivity.class);
        Log.i("moveScreens", "secondScreen");
        startActivity(intent);
    }
}