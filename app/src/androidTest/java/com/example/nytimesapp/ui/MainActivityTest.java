package com.example.nytimesapp.ui;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.nytimesapp.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testTextContent() {
        onView(withId(R.id.searchText)).check(matches(withText(R.string.search)));
        onView(withId(R.id.gotoSearch)).check(matches(withText(R.string.search_articles)));
    }

    @Test
    public void testButtonClick() {
        onView(withId(R.id.gotoSearch)).check(matches(isClickable()));
    }
}