package com.hfad.workoutmaker;

import androidx.appcompat.app.AppCompatActivity;
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

public class MainActivity extends ListActivity {
    private  WorkoutsDataSource dataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataSource = new WorkoutsDataSource(this);
        dataSource.open();
        List<Workout> allWorkouts = dataSource.getAllWorkouts();
        ArrayAdapter<Workout> adapter = new ArrayAdapter<Workout>(this, android.R.layout.simple_list_item_1, allWorkouts);
        setListAdapter(adapter);
        //create object for both images
        ImageView beginner_image = (ImageView) findViewById(R.id.BeginnerImage);
        ImageView experienced_image = (ImageView) findViewById(R.id.ExperiencedImage);
        //set on click listeners and establish what they do for both image buttons
        //for experienced button
        experienced_image.setOnClickListener(new ImageView.OnClickListener(){
            @Override
            public void onClick(View v){
                System.out.println("ExperiencedPressed");
            }
        });
        //for beginner button
        beginner_image.setOnClickListener(new ImageView.OnClickListener(){
            @Override
            public void onClick(View v){
                System.out.println("BeginnerPressed");
            }
        });

    }
    public void onClick(View view){
        ArrayAdapter<Workout> adapter = (ArrayAdapter<Workout>)getListAdapter();
        Workout workout = null;
        if(view.getId() == R.id.add) {
            String[] workouts = new String[]{"beginner", "weights"};
            int nextInt = new Random().nextInt(4);
            workout = dataSource.createWorkout(workouts[nextInt]);
            adapter.add(workout);
        }else {
            if (getListAdapter().getCount() > 0) {
                workout = (Workout) getListAdapter().getItem(0);
                dataSource.deleteWorkout(workout);
                adapter.remove(workout);
            }
        }
        adapter.notifyDataSetChanged();
    }


    public void nextButton(View view) {
//        View fragmentContainer = findViewById(R.id.fragment_container);
//        if(fragmentContainer != null){
//            HoroscopeDetail frag = new HoroscopeDetail();
//            frag.setHoroscopeFact(fact);
//            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.replace(R.id.fragment_container, frag);
//            ft.addToBackStack(null);
//            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//            ft.commit();
//
//        }else {
            Intent intent = new Intent(this, RelaxActivity.class);
            Log.i("moveScreens", "secondScreen");
            startActivity(intent);
        }

    @Override
    protected void onPause() {
        super.onPause();
        dataSource.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        dataSource.close();
    }
    //}
}