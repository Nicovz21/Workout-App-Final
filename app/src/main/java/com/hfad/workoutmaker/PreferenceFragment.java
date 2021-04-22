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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PreferenceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PreferenceFragment extends Fragment implements View.OnClickListener {
    NavController navController = null;


    public PreferenceFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_preference, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.BeginnerImage:
                //navController.navigate(R.id.action_preferenceFragment_to_workoutActivity);
                break;
            case R.id.ExperiencedImage:

                break;

        }

    }

}