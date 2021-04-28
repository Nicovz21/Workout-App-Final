package com.hfad.workoutmaker;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class PreferenceFragment extends Fragment implements View.OnClickListener {
    NavController navController = null;
    int daysOff;
    public Boolean weights;
    public boolean experienced;

    public PreferenceFragment() {
        // Required empty public constructor
    }


//gets values from bundle for the user experience and user days off selected
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        experienced = getArguments().getBoolean("experience");
        daysOff = getArguments().getInt("days off");

    }


//creates infaltor and inflates
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_preference, container, false);
    }
    //on click listeners set up for images
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.weights).setOnClickListener(this);
        view.findViewById(R.id.no_weights).setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.weights:
                //bundle for transporting boolean
                Bundle bundle = new Bundle();
                weights = true;
                //transport every bundle so far
                bundle.putBoolean("weights", weights);
                bundle.putInt("days off", daysOff);
                bundle.putBoolean("experience", experienced);
                navController.navigate(R.id.action_preferenceFragment_to_testCardViewFragment, bundle);
                //navController.navigate(R.id.action_preferenceFragment_to_testFragment, bundle);
                break;
            case R.id.no_weights:
                //bundle for transporting boolean
                bundle = new Bundle();
                weights = false;
                //transport every bundle so far
                bundle.putBoolean("weights", weights);
                bundle.putInt("days off", daysOff);
                bundle.putBoolean("experience", experienced);
               navController.navigate(R.id.action_preferenceFragment_to_testCardViewFragment, bundle);
                //navController.navigate(R.id.action_preferenceFragment_to_testFragment, bundle);
                break;

        }

    }

}