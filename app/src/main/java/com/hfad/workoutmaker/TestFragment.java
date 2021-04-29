package com.hfad.workoutmaker;

import android.app.AlertDialog;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//for testing purposes and errors with the database. This class can be used to delete a database with more ease then searching through the files and
//can delete specific entries
public class TestFragment extends Fragment {
    NavController navController = null;
    MySQLiteHelper myDb;
    TextView editEquipment, editExperience, editWorkout;
    Button btnAddData;
    Button btnViewAll;
    Button btnDeleteAll;
    public TestFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
//view created
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //set nav controller for navigation
        navController = Navigation.findNavController(view);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //use database activity
        myDb = new MySQLiteHelper(getActivity());
        //setup inflater
        View inf = inflater.inflate(R.layout.fragment_test, container, false);
        //make texts for input of equipment, experience and workout
        editEquipment = (TextView) inf.findViewById(R.id.equipmentText);
        editExperience = (TextView) inf.findViewById(R.id.experienceText);
        editWorkout = (TextView) inf.findViewById(R.id.workoutText);
        //buttons for adding data, viewing data and deleting all data
        btnAddData = (Button) inf.findViewById(R.id.button);
        btnViewAll = (Button) inf.findViewById(R.id.button2);
        btnDeleteAll = (Button) inf.findViewById(R.id.delete);
        addData();
        viewAll();
        deleteData();
        // Inflate the layout for this fragment
        return inf;

    }
    //for deleting all data in database
    public void deleteData(){
        btnDeleteAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //clearing database completely
                        myDb.clearDatabase();
                        if(myDb.getBeginnerAndNoEquipmentData()== null)
                            //Toast that data was deleted
                            Toast.makeText(getActivity(), "Data Deleted", Toast.LENGTH_LONG).show();
                        else
                            //if method did not work
                            Toast.makeText(getActivity(), "Data Not Deleted", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }
    //method for adding data to the exisiting database without coding
    public void addData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //check if the inserted data successfully worked
                       boolean isInserted = myDb.insertData(editEquipment.getText().toString(), editExperience.getText().toString(), editWorkout.getText().toString());
                       if(isInserted == true)
                           //Toast that it worked
                            Toast.makeText(getActivity(), "Data Inserted", Toast.LENGTH_LONG).show();
                           else
                               //tell user it did not
                            Toast.makeText(getActivity(), "Data Not Inserted", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }
    //method for viewing all data to see what is in the database
    public void viewAll(){
        btnViewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //use cursor to move through database
                        Cursor res = myDb.getBeginnerAndNoEquipmentData();
                        //if nothing was pulled from database, return an error message
                        if(res.getCount() == 0){
                            //show message
                            showMessage("error","Nothing found");
                            return;
                        }
                        //create string buffer and append the string value for all categories
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()){
                            String experience = res.getString(1);
                            buffer.append("Id :" + res.getString(0)+ "\n");
                            buffer.append("experience :" + experience+ "\n");
                            buffer.append("equipment :" + res.getString(2)+ "\n");
                        }
                        //show all data
                        editWorkout.setText(buffer.toString());
                        //showMessage("Data",buffer.toString());
                        myDb.close();
                    }
                }
        );
    }
    //show message for the database
    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }


}