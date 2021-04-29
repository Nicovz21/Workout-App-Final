package com.hfad.workoutmaker;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class RelaxActivity extends AppCompatActivity {
RelaxFragment relax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relax);
        setSupportActionBar(findViewById(R.id.toolbar));
        ActionBar ab = getSupportActionBar();
        if(ab != null)
            ab.setDisplayHomeAsUpEnabled(true);
    }

    public RelaxFragment getRelax() {
        return relax;
    }

    public void nextButton(View view) {
        Intent intent = new Intent(this, PreferenceActivity.class);
        Log.i("moveScreens", "secondScreen");
        startActivity(intent);
    }
    //add the menu options to the toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}