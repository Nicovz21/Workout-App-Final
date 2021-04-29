package com.hfad.workoutmaker;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class RelaxFragment extends Fragment implements View.OnClickListener {

    NavController navController = null;
    public int daysOff;
    public boolean experienced;
    Button oneDay,twoDays,threeDays;
    public RelaxFragment() {
        // Required empty public constructor
    }


//on create method
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        experienced = getArguments().getBoolean("experience");

    }

//
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.one_day).setOnClickListener(this);
        view.findViewById(R.id.two_days).setOnClickListener(this);
        view.findViewById(R.id.three_days).setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_relax, container, false);

        return v;
    }
//make on click events for the days selected
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //if one day is selected send all the data that came prior and the day selected as an int
            case R.id.one_day:
                Bundle bundle = new Bundle();
                daysOff = 1;
                bundle.putInt("days off", daysOff);
                bundle.putBoolean("experience", experienced);
                navController.navigate(R.id.action_relaxFragment_to_preferenceFragment, bundle);

                break;
            //if two days is selected send all the data that came prior and the day selected as an int
            case R.id.two_days:
                bundle = new Bundle();
                daysOff = 2;
                bundle.putInt("days off", daysOff);
                bundle.putBoolean("experience", experienced);
                navController.navigate(R.id.action_relaxFragment_to_preferenceFragment,bundle);

                break;
            //if three days is selected send all the data that came prior and the day selected as an int
            case R.id.three_days:
                bundle = new Bundle();
                daysOff = 3;
                bundle.putInt("days off", daysOff);
                bundle.putBoolean("experience", experienced);
                navController.navigate(R.id.action_relaxFragment_to_preferenceFragment,bundle);

                break;
        }

    }

}