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


public class RelaxFragment extends Fragment implements View.OnClickListener {
    NavController navController = null;
    public int daysOff;
    public RelaxFragment() {
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_relax, container, false);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.one_day:
                daysOff = 1;
                navController.navigate(R.id.action_relaxFragment_to_preferenceFragment);
                break;
            case R.id.two_days:
                daysOff = 2;
                navController.navigate(R.id.action_relaxFragment_to_preferenceFragment);
                break;
            case R.id.three_days:
                daysOff = 3;
                navController.navigate(R.id.action_relaxFragment_to_preferenceFragment);
                break;

        }

    }

}