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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myDb = new MySQLiteHelper(getActivity());
        View inf = inflater.inflate(R.layout.fragment_test, container, false);
        editEquipment = (TextView) inf.findViewById(R.id.equipmentText);
        editExperience = (TextView) inf.findViewById(R.id.experienceText);
        editWorkout = (TextView) inf.findViewById(R.id.workoutText);
        btnAddData = (Button) inf.findViewById(R.id.button);
        btnViewAll = (Button) inf.findViewById(R.id.button2);
        btnDeleteAll = (Button) inf.findViewById(R.id.delete);
        addData();
        viewAll();
        deleteData();
        // Inflate the layout for this fragment
        return inf;

    }
    public void deleteData(){
        btnDeleteAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Integer deletedRows = myDb.deleteData("1");
                        myDb.clearDatabase();
                        if(myDb.getBeginnerAndEquipmentData()== null)
                            Toast.makeText(getActivity(), "Data Deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(getActivity(), "Data Not Deleted", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }
    public void addData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       boolean isInserted = myDb.insertData(editEquipment.getText().toString(), editExperience.getText().toString(), editWorkout.getText().toString());
                       if(isInserted == true)
                            Toast.makeText(getActivity(), "Data Inserted", Toast.LENGTH_LONG).show();
                           else
                            Toast.makeText(getActivity(), "Data Not Inserted", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }
    public void viewAll(){
        btnViewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Cursor res = myDb.getBeginnerAndEquipmentData();
                        if(res.getCount() == 0){
                            //show message
                            showMessage("error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()){
                            //String experience = res.getString(1);
                            //buffer.append("Id :" + res.getString(0)+ "\n");
                            //buffer.append("experience :" + experience+ "\n");
                            //buffer.append("equipment :" + res.getString(2)+ "\n");
                            buffer.append(res.getString(3)+ "\n\n");


                        }

                        //show all data
                        editWorkout.setText(buffer.toString());
                        //showMessage("Data",buffer.toString());
                        myDb.close();
                    }
                }
        );
    }
    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }


}