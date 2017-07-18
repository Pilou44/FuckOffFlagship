package poc.fuckoffflagship.modules.profile;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import poc.fuckoffflagship.R;

import static android.support.test.espresso.core.deps.guava.base.Verify.verify;
import static android.support.test.espresso.core.deps.guava.base.Verify.verifyNotNull;
import static org.junit.Assert.*;

/**
 * Created by tai on 7/18/17.
 */

@RunWith(AndroidJUnit4.class)
public class ProfilePresenterITest extends ActivityInstrumentationTestCase2<ProfileActivity> {

    public ProfilePresenterITest() {
        super(ProfileActivity.class);
    }

    @Before
    public void setup() {
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        Intent intent = new Intent();
        intent.putExtra("id", 1);
        setActivityIntent(intent);
    }

    @Test
    public void testSetId() {
        assertEquals("NG", ((TextView) getActivity().findViewById(R.id.user_lastname)).getText().toString());

        assertEquals("Tai", ((TextView) getActivity().findViewById(R.id.user_name)).getText().toString());

        assertEquals("Developer", ((TextView) getActivity().findViewById(R.id.user_function)).getText().toString());

        assertEquals("Android", ((TextView) getActivity().findViewById(R.id.user_function_os)).getText().toString());
    }

    @Test
    public void testShowFriendList() {

    }
}