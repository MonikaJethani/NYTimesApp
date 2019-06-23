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
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class SearchActivityTest {

    @Rule
    public ActivityTestRule<SearchActivity> activityRule =
            new ActivityTestRule<>(SearchActivity.class);

    @Test
    public void testViews() {
        onView(withId(R.id.search_query)).check(matches(isDisplayed()));
        onView(withId(R.id.searchBtn)).check(matches(isDisplayed()));
    }

    @Test
    public void testSearchButtonClick() {
        onView(withId(R.id.searchBtn)).check(matches(isClickable()));
    }
}