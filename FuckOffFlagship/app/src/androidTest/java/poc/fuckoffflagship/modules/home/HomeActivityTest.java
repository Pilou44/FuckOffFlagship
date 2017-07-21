package poc.fuckoffflagship.modules.home;

import android.content.res.Resources;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.internal.util.Checks;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import poc.fuckoffflagship.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class HomeActivityTest {

    @Rule
    public ActivityTestRule<HomeActivity> mActivityTestRule = new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void HomeActivityTest() {
        ViewInteraction floatingActionButton = onView(allOf(withId(R.id.fab1), isDisplayed()));
        floatingActionButton.perform(click());

        onView(withId(R.id.user_name)).check(matches(withText("Tai")));
        onView(withId(R.id.user_lastname)).check(matches(withText("NG")));
    }

    @Test
    public void HomeActivityTest2() {
        ViewInteraction viewPager = onView(allOf(withId(R.id.pager), isDisplayed()));
        viewPager.perform(swipeLeft());

        onView(withId(R.id.disney_rv)).perform(RecyclerViewActions.actionOnItemAtPosition(0, MyViewAction.clickChildViewWithId(R.id.disney_checked)));
        onView(withId(R.id.disney_rv)).perform(RecyclerViewActions.actionOnItemAtPosition(1, MyViewAction.clickChildViewWithId(R.id.disney_checked)));
        onView(withId(R.id.disney_rv)).perform(RecyclerViewActions.actionOnItemAtPosition(2, MyViewAction.clickChildViewWithId(R.id.disney_checked)));

        viewPager.perform(swipeLeft());

        onView(withRecyclerView(R.id.rv).atPositionOnView(0, R.id.disney_name)).check(matches(withText("Mickey")));
        onView(withRecyclerView(R.id.rv).atPositionOnView(1, R.id.disney_name)).check(matches(withText("Donald")));
        onView(withRecyclerView(R.id.rv).atPositionOnView(2, R.id.disney_name)).check(matches(withText("Dingo")));
    }

    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }

    public static class MyViewAction {

        public static ViewAction clickChildViewWithId(final int id) {
            return new ViewAction() {
                @Override
                public Matcher<View> getConstraints() {
                    return null;
                }

                @Override
                public String getDescription() {
                    return "Click on a child view with specified id.";
                }

                @Override
                public void perform(UiController uiController, View view) {
                    View v = view.findViewById(id);
                    v.performClick();
                }
            };
        }

    }

}