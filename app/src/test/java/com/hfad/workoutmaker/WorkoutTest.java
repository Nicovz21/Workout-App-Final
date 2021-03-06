package com.hfad.workoutmaker;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorkoutTest {
private Workout workout;
private WorkoutsDataSource ds;
    @Before
    public void setUp() throws Exception {
        workout = new Workout();

    }

    @Test
    public void getId() {
        assertNotNull(ds.getWorkoutByBeginnerAndNoWeights());
    }


    @Test
    public void getExperience() {

        assertNotNull(workout);
    }

    @Test
    public void getEquipment() {
        assertNotNull(workout);
    }

    @Test
    public void getWorkout() {
        assertNotNull(workout);
    }

    @Test
    public void testToString() {
        assertNotNull(ds.getWorkoutByBeginnerAndNoWeights());
    }
}