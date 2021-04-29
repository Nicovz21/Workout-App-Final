package com.hfad.workoutmaker;

//class for getting specific workout elements
public class Workout {
    private long id;
    private String experience;
    private String equipment;
    private String workout;

    //get id of workout
    public long getId() {
        return id;
    }
    //set id of workout
    public void setId(long id) {
        this.id = id;
    }

    //get experience of any given id
    public String getExperience() {
        return experience;
    }
    //get equipment of any given id
    public String getEquipment() {
        return equipment;
    }
    //get workout by any given id
    public String getWorkout() {
        return workout;
    }
    //set experience of any given id
    public void setExperience(String experience) {
        this.experience = experience;
    }
    //set equipment of any given id
    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }
    //set workout of any given id
    public void setWorkout(String workout) {
        this.workout = workout;
    }


    //convert database elements to string
    @Override
    public String toString() {
        return experience + "," + equipment + "," + workout;
    }
}