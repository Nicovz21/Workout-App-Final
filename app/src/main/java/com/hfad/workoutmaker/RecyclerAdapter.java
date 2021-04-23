package com.hfad.workoutmaker;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>  {

    private String[] weekdays = {"Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday"};

    private String[] workouts = {"Item one details",
            "Item two details", "Item three details",
            "Item four details", "Item five details"};
    //

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int pos) {
    //    viewHolder.weekdays.setText(weekdays[pos]);
     //   viewHolder.workouts.setText(workouts[pos]);
    }

    @Override
    public int getItemCount() {
        return weekdays.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

     //   public TextView weekdays;
     //   public TextView workouts;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        //    weekdays = (TextView)weekdays.findViewById(R.id.weekday_text);
         //   workouts = (TextView)workouts.findViewById(R.id.workout_text);
        }
    }
}
