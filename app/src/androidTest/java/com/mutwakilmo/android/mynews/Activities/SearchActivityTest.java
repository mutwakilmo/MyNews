package com.mutwakilmo.android.mynews.Activities;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.test.rule.ActivityTestRule;

import com.mutwakilmo.android.mynews.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.PickerActions.setDate;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Mutwakil Mo on
 */
public class SearchActivityTest {


    @Rule
    public ActivityTestRule<SearchActivity> mSearchActivityActivityTestRule =
            new ActivityTestRule<SearchActivity>(SearchActivity.class);


    //reference to welcomeActivity
    private SearchActivity mSearchActivity = null;
    //Activity monitor
    Instrumentation.ActivityMonitor mMonitor = getInstrumentation().addMonitor(NYSearchResultActivity.class.getName(), null, false);
    private CheckBox cb_arts;
    private CheckBox cb_politics;
    private CheckBox cb_business;
    private CheckBox cb_sports;
    private CheckBox cb_entrepreneurs;
    private CheckBox cb_travel;
    private View endDateButton;
    private View beginDateButton;
    private EditText textInputEditText;


    @Before
    public void setUp() throws Exception {
        mSearchActivity = mSearchActivityActivityTestRule.getActivity();


        //Checkboxes
        cb_arts = mSearchActivity.findViewById(R.id.artsCB);
        cb_politics = mSearchActivity.findViewById(R.id.politicsCB);
        cb_business = mSearchActivity.findViewById(R.id.businessCB);
        cb_sports = mSearchActivity.findViewById(R.id.sportsCB);
        cb_entrepreneurs = mSearchActivity.findViewById(R.id.entrepreneursCB);
        cb_travel = mSearchActivity.findViewById(R.id.travelCB);


        textInputEditText = mSearchActivity.findViewById(R.id.editTextSearch);

        //Views (buttons)
        endDateButton = mSearchActivity.findViewById(R.id.editTextBeginDate);
        beginDateButton = mSearchActivity.findViewById(R.id.editTextEndDate);
    }

    @Test
    public void testLaunchNYSearchResultActivityOnButtonClicked() {

        assertNotNull(mSearchActivity.findViewById(R.id.searchButton));
        //perform click on btn using espresso(UI)
        onView(withId(R.id.searchButton)).perform(click());

        //timeOut in milliseconds
        Activity nYSearchResultActivity = getInstrumentation().waitForMonitorWithTimeout(mMonitor, 5000);
        assertNotNull(nYSearchResultActivity);
        nYSearchResultActivity.finish();

    }

    @Test
    public void testViewsDisplayOnActivity() {
        onView(withId(R.id.editTextSearch)).check(matches(isDisplayed()));

        onView(withId(R.id.editTextBeginDate)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextEndDate)).check(matches(isDisplayed()));

        onView(withId(R.id.artsCB)).perform(click()).check(matches(isDisplayed()));
        onView(withId(R.id.politicsCB)).perform(click()).check(matches(isDisplayed()));
        onView(withId(R.id.businessCB)).perform(click()).check(matches(isDisplayed()));
        onView(withId(R.id.sportsCB)).perform(click()).check(matches(isDisplayed()));
        onView(withId(R.id.entrepreneursCB)).perform(click()).check(matches(isDisplayed()));
        onView(withId(R.id.travelCB)).perform(click()).check(matches(isDisplayed()));
    }

    @Test
    public void testViewsCheckable() {
        // -------------------------------------------------------------
        // SearchEditText and Check and  un-checking the checkboxes
        // --------------------------------------------------------------

        onView(withId(R.id.editTextSearch)).perform(clearText());


        if (cb_arts.isChecked()) onView(withId(R.id.artsCB)).perform(click());
        if (cb_business.isChecked()) onView(withId(R.id.businessCB)).perform(click());
        if (cb_politics.isChecked()) onView(withId(R.id.politicsCB)).perform(click());
        if (cb_sports.isChecked()) onView(withId(R.id.sportsCB)).perform(click());
        if (cb_entrepreneurs.isChecked()) onView(withId(R.id.entrepreneursCB)).perform(click());
        if (cb_travel.isChecked()) onView(withId(R.id.travelCB)).perform(click());

        // ------------------------------------------------------------------------------------
        // SearchEditText Writing Hello Search Test from Belgium StayHome StaySafe on the EditText
        // -----------------------------------------------------------------------------------

        onView(withId(R.id.editTextSearch))
                .perform(typeText("Hello Search Test from Belgium StayHome StaySafe"))
                .check(matches(isDisplayed()));


        // --------------------------------------------------------------
        // Checking the categoriesSelected are checked when clicked
        // --------------------------------------------------------------

        onView(withId(R.id.artsCB)).perform(click()).check(matches(isChecked()));
        onView(withId(R.id.businessCB)).perform(click()).check(matches(isDisplayed()));
        onView(withId(R.id.sportsCB)).perform(click()).check(matches(isDisplayed()));
        onView(withId(R.id.entrepreneursCB)).perform(click()).check(matches(isDisplayed()));
        onView(withId(R.id.travelCB)).perform(click()).check(matches(isDisplayed()));

        // --------------------------------------------------------------
        // unChecking the categoriesSelected are checked when clicked
        // --------------------------------------------------------------

        if (cb_arts.isChecked()) onView(withId(R.id.artsCB)).perform(click());
        if (cb_politics.isChecked()) onView(withId(R.id.politicsCB)).perform(click());
        if (cb_business.isChecked()) onView(withId(R.id.businessCB)).perform(click());
        if (cb_sports.isChecked()) onView(withId(R.id.sportsCB)).perform(click());
        if (cb_entrepreneurs.isChecked()) onView(withId(R.id.entrepreneursCB)).perform(click());
        if (cb_travel.isChecked()) onView(withId(R.id.travelCB)).perform(click());


    }

    @Test
    public void testBeginDateInDatePicker() {
        // Show the date picker
        onView(withId(R.id.editTextBeginDate)).perform(click());
        // Sets a date on the date picker widget
        onView(isAssignableFrom(DatePicker.class)).perform(setDate(1988, 11, 27));
    }

    @Test
    public void testEndDateInDatePicker(){
        // Show the date picker
        onView(withId(R.id.editTextEndDate)).perform(click());
        // Sets a date on the date picker widget
        onView(isAssignableFrom(DatePicker.class)).perform(setDate(1988, 11, 27));
    }
}