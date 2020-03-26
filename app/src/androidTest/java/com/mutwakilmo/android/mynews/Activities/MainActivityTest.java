package com.mutwakilmo.android.mynews.Activities;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.Gravity;

import androidx.test.espresso.contrib.DrawerActions;
import androidx.test.espresso.contrib.NavigationViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.mutwakilmo.android.mynews.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.DrawerMatchers.isClosed;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Mutwakil Mo on
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {


    @Rule
    public ActivityTestRule<MainActivity> mMainActivityActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    //reference to MainActivity
    private MainActivity mMainActivity = null;

    //Activity monitor
    Instrumentation.ActivityMonitor mMonitor = getInstrumentation().addMonitor(SearchActivity.class.getName(), null, false);
    private Object swipeUp;


    @Before
    public void setUp() throws Exception {
        mMainActivity = mMainActivityActivityTestRule.getActivity();
    }

    // --------------------------------
    //launch searchActivity when we click search
    // --------------------------------
    @Test
    public void testLaunchSearchActivityOnButtonActionClicked() {

        assertNotNull(mMainActivity.findViewById(R.id.action_search));
        //perform click on btn using espresso(UI)
        onView(withId(R.id.action_search)).perform(click());

        //timeOut in milliseconds
        Activity searchActivity = getInstrumentation().waitForMonitorWithTimeout(mMonitor, 5000);
        assertNotNull(searchActivity);

    }


    // --------------------------------
    //Test TabLayout Display
    // --------------------------------

    @Test
    public void testMyCoolTabLayoutIsDisplayed() {
        onView(withId(R.id.tab_layout))
                .perform(click())
                .check(matches(isDisplayed()));
    }



    // --------------------------------
    //Test NavigationDrawer Display
    // --------------------------------
    
    @Test
    public void testMyCoolNavigationDrawer() {
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer

        // Start the screen of your activity.
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.nav_arts));


    }

    @Test
    public void testNavigationDrawer(){
        onView(withId(R.id.drawer_layout)).perform();
    }
    

}