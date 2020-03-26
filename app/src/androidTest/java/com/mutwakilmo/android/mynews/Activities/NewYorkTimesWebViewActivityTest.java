package com.mutwakilmo.android.mynews.Activities;

import android.content.Context;
import android.content.Intent;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.mutwakilmo.android.mynews.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Mutwakil Mo on
 */
public class NewYorkTimesWebViewActivityTest {


    @Rule
    public ActivityTestRule<NewYorkTimesWebViewActivity> mNewYorkTimesWebViewActivityActivityTestRule =
            new ActivityTestRule<NewYorkTimesWebViewActivity>(NewYorkTimesWebViewActivity.class);


    private  NewYorkTimesWebViewActivity mActivity = null;


    private String articleUrl;

    private Context targetContext;


    //TodO Test fail
    private Intent intent;
    @Before
    public void setUp() throws Exception {
        /** With this, we get the context! */
        mActivity = mNewYorkTimesWebViewActivityActivityTestRule.getActivity();

        articleUrl = "        https://www.nytimes.com/2020/03/25/business/2-trillion-stimulus-coronavirus-bill.html\n";

        targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        intent = new Intent(targetContext, NewYorkTimesWebViewActivity.class);
    }


    @Test
    public void testWebViewDisplayed () {

        mNewYorkTimesWebViewActivityActivityTestRule.launchActivity(intent);

        onView(withId(R.id.webView)).check(matches(isDisplayed()));

    }
}