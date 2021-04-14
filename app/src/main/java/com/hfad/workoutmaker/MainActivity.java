package com.hfad.workoutmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


    public void nextButton(View view) {
        Intent intent = new Intent(this, RelaxActivity.class);
        Log.i("moveScreens", "secondScreen");
        startActivity(intent);
    }
}