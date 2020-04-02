package com.mutwakilmo.android.mynewsapp.Activities;

import android.app.Activity;
import android.app.Instrumentation;

import androidx.test.rule.ActivityTestRule;

import com.mutwakilmo.android.mynewsapp.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Mutwakil Mo on🐮🐮🐮 on 25/03/2020
 */
public class WelcomeActivityTest {


    @Rule
    public ActivityTestRule<WelcomeActivity> mWelcomeActivityActivityTestRule =
            new ActivityTestRule<WelcomeActivity>(WelcomeActivity.class);

    //reference to welcomeActivity
    private WelcomeActivity mWelcomeActivity = null;
    //Activity monitor
    Instrumentation.ActivityMonitor mMonitor = getInstrumentation().addMonitor(MainActivity.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {
        mWelcomeActivity = mWelcomeActivityActivityTestRule.getActivity();
    }

    @Test
    public void testLaunchMainActivityOnButtonClicked() {

        assertNotNull(mWelcomeActivity.findViewById(R.id.start_btn));
        //perform click on btn using espresso(UI)
        onView(withId(R.id.start_btn)).perform(click());

        //timeOut in milliseconds
        Activity mainActivity = getInstrumentation().waitForMonitorWithTimeout(mMonitor, 5000);
        assertNotNull(mainActivity);
        // mainActivity.finish();

    }

    @After
    public void tearDown() throws Exception {
        mWelcomeActivity = null;
    }


}