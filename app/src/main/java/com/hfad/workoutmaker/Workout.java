package com.hfad.workoutmaker;

/**
 * Created by relkharboutly on 3/30/2016.
 */
public class Workout {
    private long id;
    private String experience;
    private String equipment;
    private String workout;
    private String monday;
    private String tuesday;
    private String wednesday;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getExperience() {
        return experience;
    }
    public String getEquipment() {
        return equipment;
    }
    public String getWorkout() {
        return workout;
    }
    public String getMonday() {
        return monday;
    }
    public String getTuesday() {
        return tuesday;
    }
    public String getWednesday() {
        return wednesday;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }
    public void setWorkout(String workout) {
        this.workout = workout;
    }
    public void setMonday(String monday) {
        this.monday = monday;
    }
    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }
    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    // Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return experience;
    }
}