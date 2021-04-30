package com.hfad.workoutmaker;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.action.ViewActions.click;
import androidx.test.core.app.ActivityScenario;
//import androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class InstrumentedTest {



   ActivityScenario<RelaxActivity> relaxActivityScenario
            =  ActivityScenario.launch(RelaxActivity.class);


    @Test
    public void nextScreen() {

        onView(withId(R.id.one_day)).perform(click());
   //     onView(withId(R.id.)).check(matches(isDisplayed()));

   //     onView(withId(R.id.fragmentA)).check(//code here to check that specific text is displayed)

    }


}