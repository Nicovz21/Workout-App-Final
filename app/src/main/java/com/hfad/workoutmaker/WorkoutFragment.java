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
import android.widget.ArrayAdapter;

import java.util.List;


public class WorkoutFragment extends Fragment {
    NavController navController = null;
    private  WorkoutsDataSource dataSource;

    public WorkoutFragment() {
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
        return inflater.inflate(R.layout.fragment_workout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        //view.findViewById(R.id.BeginnerImage).setOnClickListener(this);
        //view.findViewById(R.id.ExperiencedImage).setOnClickListener(this);

        List<Workout> allWorkouts = MainActivity.dataSource.getAllWorkouts();
        ArrayAdapter<Workout> adapter = new ArrayAdapter<Workout>(getActivity(), android.R.layout.simple_list_item_1, allWorkouts);

        adapter.notifyDataSetChanged();

    }
}