package com.hfad.workoutmaker;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//source for layout: https://www.youtube.com/watch?v=_QgsZ0xd00Q

public class CardViewFragment extends Fragment {

    NavController navController = null;
    MySQLiteHelper myDb;
    TextView mondayText, tuesdayText, wedText, thursText, friText;
    int daysOff;
    Boolean weights;
    public boolean experienced;
    public CardViewFragment() {
        // Required empty public constructor
    }

//create bundle objects
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        experienced = getArguments().getBoolean("experience");
        daysOff = getArguments().getInt("days off");
        weights = getArguments().getBoolean("weights");

    }
//create navigation controller
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

    }
//create view for fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //initialize database
        myDb = new MySQLiteHelper(getActivity());
        //create inflator
        View inf = inflater.inflate(R.layout.fragment_card_view, container, false);
        //make tests objects
        mondayText = (TextView) inf.findViewById(R.id.monday_workout);
        tuesdayText = (TextView) inf.findViewById(R.id.tuesday_workout);
        wedText = (TextView) inf.findViewById(R.id.wednesday_workout);
        thursText = (TextView) inf.findViewById(R.id.thursday_workout);
        friText = (TextView) inf.findViewById(R.id.friday_workout);
        //un comment to test values
        //friText.setText("days off"+experienced +daysOff + weights);
        //method that decides what to display
        viewAll();
        return inf;
    }
    //decides what to display based on choices
    public void viewAll() {
        //if someone is not experienced and does not own weights
        if (experienced == false && weights == false) {
            Cursor res = myDb.getBeginnerAndNoEquipmentData();
            StringBuffer buffer = new StringBuffer();
            while (res.moveToNext()) {
                //number workouts from 1-4
                int workoutNumber = 1;
                buffer.append(workoutNumber + ":" + res.getString(3) + " ");
                for (workoutNumber = 2; res.moveToNext(); workoutNumber++) {
                    buffer.append(workoutNumber + ":" + res.getString(3) + " ");
                }
                mondayText.setText(buffer.toString());
                tuesdayText.setText(buffer.toString());
                wedText.setText(buffer.toString());
                thursText.setText(buffer.toString());
                friText.setText(buffer.toString());
            }

            myDb.close();
        }
        //if someone is not experienced and owns weights
        if (experienced == false && weights == true) {
            Cursor res = myDb.getBeginnerAndEquipmentData();
            StringBuffer buffer = new StringBuffer();
            while (res.moveToNext()) {
                //number workouts from 1-4
                int workoutNumber = 1;
                buffer.append(workoutNumber + ":" + res.getString(3) + " ");
                for (workoutNumber = 2; res.moveToNext(); workoutNumber++) {
                    buffer.append(workoutNumber + ":" + res.getString(3) + " ");
                }
                mondayText.setText(buffer.toString());
                tuesdayText.setText(buffer.toString());
                wedText.setText(buffer.toString());
                thursText.setText(buffer.toString());
                friText.setText(buffer.toString());
            }
            myDb.close();
        }
        //if someone is experienced and does not own weights
        if (experienced == true && weights == false) {
            Cursor res = myDb.getExperiencedAndNoEquipmentData();
            StringBuffer buffer = new StringBuffer();
            while (res.moveToNext()) {
                //number workouts from 1-4
                int workoutNumber = 1;
                buffer.append(workoutNumber + ":" + res.getString(3) + " ");
                for (workoutNumber = 2; res.moveToNext(); workoutNumber++) {
                    buffer.append(workoutNumber + ":" + res.getString(3) + " ");
                }
                mondayText.setText(buffer.toString());
                tuesdayText.setText(buffer.toString());
                wedText.setText(buffer.toString());
                thursText.setText(buffer.toString());
                friText.setText(buffer.toString());
            }
            myDb.close();
        }
        //if someone is experienced and does own weights
        if (experienced == true && weights == true) {
            Cursor res = myDb.getExperiencedAndEquipmentData();
            StringBuffer buffer = new StringBuffer();
            while (res.moveToNext()) {
                //number workouts from 1-4
                int workoutNumber = 1;
                buffer.append(workoutNumber + ":" + res.getString(3) + " ");
                for (workoutNumber = 2; res.moveToNext(); workoutNumber++) {
                    buffer.append(workoutNumber + ":" + res.getString(3) + " ");
                }
                mondayText.setText(buffer.toString());
                tuesdayText.setText(buffer.toString());
                wedText.setText(buffer.toString());
                thursText.setText(buffer.toString());
                friText.setText(buffer.toString());
            }
            myDb.close();
        }

    }
}