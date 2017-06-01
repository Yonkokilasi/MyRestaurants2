package com.example.bubbles.myrestaurants;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.example.bubbles.myrestaurants.ui.RestaurantListActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by bubbles on 5/23/17.
 */

public class RestaurantListActivityInstrumentationTest {

}
