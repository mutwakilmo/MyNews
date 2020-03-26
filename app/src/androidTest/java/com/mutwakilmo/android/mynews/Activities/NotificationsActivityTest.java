package com.mutwakilmo.android.mynews.Activities;

import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;

import androidx.test.rule.ActivityTestRule;

import com.mutwakilmo.android.mynews.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Mutwakil Mo on
 */
public class NotificationsActivityTest {
    @Rule
    public ActivityTestRule<NotificationsActivity> mNotificationsActivityActivityTestRule =
            new ActivityTestRule<NotificationsActivity>(NotificationsActivity.class);

    //reference to welcomeActivity
    private NotificationsActivity mNotificationsActivity = null;


    private CheckBox cb_arts;
    private CheckBox cb_politics;
    private CheckBox cb_business;
    private CheckBox cb_sports;
    private CheckBox cb_entrepreneurs;
    private CheckBox cb_travel;
    private Switch notification_switch;

    @Before
    public void setUp() throws Exception {
        mNotificationsActivity = mNotificationsActivityActivityTestRule.getActivity();
        // ----------------------------------
        //CategoriesCheckBoxes
        // ----------------------------------

        cb_arts = mNotificationsActivity.findViewById(R.id.artsCB);
        cb_politics = mNotificationsActivity.findViewById(R.id.politicsCB);
        cb_business = mNotificationsActivity.findViewById(R.id.businessCB);
        cb_sports = mNotificationsActivity.findViewById(R.id.sportsCB);
        cb_entrepreneurs = mNotificationsActivity.findViewById(R.id.entrepreneursCB);
        cb_travel = mNotificationsActivity.findViewById(R.id.travelCB);

        //Text
        EditText textInputEditText = mNotificationsActivity.findViewById(R.id.editTextSearchNotification);

        //Switch notifications
        notification_switch = mNotificationsActivity.findViewById(R.id.notificationSwitch);

    }

    @Test
    public void testViewsDisplayOnActivity() {
        onView(withId(R.id.editTextSearchNotification)).check(matches(isDisplayed()));

        onView(withId(R.id.artsCB)).perform(click()).check(matches(isDisplayed()));
        onView(withId(R.id.politicsCB)).perform(click()).check(matches(isDisplayed()));
        onView(withId(R.id.businessCB)).perform(click()).check(matches(isDisplayed()));
        onView(withId(R.id.sportsCB)).perform(click()).check(matches(isDisplayed()));
        onView(withId(R.id.entrepreneursCB)).perform(click()).check(matches(isDisplayed()));
        onView(withId(R.id.travelCB)).perform(click()).check(matches(isDisplayed()));
    }

    @Test
    public void searchTopicToBeNotify() {
        onView(withId(R.id.editTextSearchNotification))
                .perform(typeText("StayHome StaySafe"))
                .check(matches(isDisplayed()));
    }

}