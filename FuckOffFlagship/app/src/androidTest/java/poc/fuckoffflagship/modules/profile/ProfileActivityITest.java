package poc.fuckoffflagship.modules.profile;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import poc.fuckoffflagship.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class ProfileActivityITest {

    @Rule
    public ActivityTestRule<ProfileActivity> mProfileActivity = new ActivityTestRule<ProfileActivity>(ProfileActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(context, ProfileActivity.class);
            result.putExtra("id", 1);
            return result;
        }
    };

    @Test
    public void changeText_sameProfileActivity() {
        onView(withId(R.id.show_friends_button)).perform(click());

        ViewInteraction textView = onView(allOf(withId(R.id.item_user_firstname), withText("Guillaume"), childAtPosition(childAtPosition(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class), 0), 0), isDisplayed()));
        textView.check(matches(withText("Guillaume")));

        ViewInteraction textView2 = onView(allOf(withId(R.id.item_user_lastname), withText("Beguin"), childAtPosition(childAtPosition(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class), 0), 1), isDisplayed()));
        textView2.check(matches(withText("Beguin")));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }


}