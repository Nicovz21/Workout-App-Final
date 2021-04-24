package com.hfad.workoutmaker;

import android.app.Activity;
import android.nfc.Tag;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.List;


public class MainActivityFragment extends Fragment implements View.OnClickListener{
    NavController navController = null;


    public boolean experienced;

    private  WorkoutsDataSource dataSource;
    private MainActivityListenser mActivity;


    public MainActivityFragment() {
        // Required empty public constructor
    }




    //create interface for fragment
    public interface MainActivityListenser{
        void nextButton();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //variable for myActivity
        Activity myActivity = getActivity();

            //create inflater
            View view =inflater.inflate(R.layout.fragment_main_activity, container, false);
            // Inflate the layout for this fragment
            return view;


    }

//click listeners for images
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.BeginnerImage).setOnClickListener(this);
        view.findViewById(R.id.ExperiencedImage).setOnClickListener(this);

    }
//case by case on which image is clicked
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.BeginnerImage:
                //bundle made to transport boolean
                Bundle bundle = new Bundle();
                //not experienced
                experienced = false;
                bundle.putBoolean("experience", experienced);
                navController.navigate(R.id.action_mainActivityFragment_to_relaxFragment, bundle);
                break;
            case R.id.ExperiencedImage:
                //bundle made to transport boolean
                bundle = new Bundle();
                //experienced
                experienced = true;
                bundle.putBoolean("experience", experienced);
                navController.navigate(R.id.action_mainActivityFragment_to_relaxFragment, bundle);
                break;

        }

    }

}