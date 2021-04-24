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


public class TestCardViewFragment extends Fragment {

    NavController navController = null;
    MySQLiteHelper myDb;
    TextView mondayText, tuesdayText, wedText, thursText, friText;
    PreferenceFragment preference;
    int daysoff;
    public TestCardViewFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myDb = new MySQLiteHelper(getActivity());
//        Bundle bundle = this.getArguments();
//        Integer relaxdays = bundle.getInt("days off");
//        daysoff = relaxdays;
        View inf = inflater.inflate(R.layout.fragment_test_card_view, container, false);
        mondayText = (TextView) inf.findViewById(R.id.monday_workout);
        tuesdayText = (TextView) inf.findViewById(R.id.tuesday_workout);
        wedText = (TextView) inf.findViewById(R.id.wednesday_workout);
        thursText = (TextView) inf.findViewById(R.id.thursday_workout);
        friText = (TextView) inf.findViewById(R.id.friday_workout);
        viewAll();
        return inf;
    }
    public void viewAll() {
        Cursor res = myDb.getBeginnerAndEquipmentData();
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){
            int workoutNumber = 1;
            //String experience = res.getString(1);
            //buffer.append("Id :" + res.getString(0)+ "\n");
            //buffer.append("experience :" + experience+ "\n");
            //buffer.append("equipment :" + res.getString(2)+ "\n");
            buffer.append(workoutNumber + ":" + res.getString(3) + " ");
            for(workoutNumber = 2; res.moveToNext(); workoutNumber++) {
                buffer.append(workoutNumber + ":" + res.getString(3) + " ");
            }
            mondayText.setText(buffer.toString());
            tuesdayText.setText(buffer.toString());
            wedText.setText(buffer.toString());
            thursText.setText(buffer.toString());
//            if(daysoff == 1) {
//                mondayText.setText(buffer.toString());
//                tuesdayText.setText(buffer.toString());
//                wedText.setText(buffer.toString());
//                thursText.setText(buffer.toString());
//            }
//            if(daysoff == 2) {
//                mondayText.setText(buffer.toString());
//                tuesdayText.setText(buffer.toString());
//                wedText.setText(buffer.toString());
//            }
//            if(daysoff == 3) {
//                mondayText.setText(buffer.toString());
//                tuesdayText.setText(buffer.toString());
//            }



        }


        //showMessage("Data",buffer.toString());
        myDb.close();

    }
}