package poc.fuckoffflagship.modules.profile;

import android.app.Activity;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import poc.fuckoffflagship.R;
import poc.fuckoffflagship.data.beans.Profile;
import poc.fuckoffflagship.modules.core.BaseRouter;

/**
 * Created by tai on 7/18/17.
 */

@RunWith(AndroidJUnit4.class)
public class ProfilePresenterITest extends ActivityInstrumentationTestCase2<ProfileActivity> {

    ProfileContract.ProfileInteractor mInteractor;

    public ProfilePresenterITest() {
        super(ProfileActivity.class);
    }

    @Before
    public void setup() {
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        Intent intent = new Intent();
        intent.putExtra("id", 1);
        setActivityIntent(intent);

        mInteractor = new ProfileInteractor(getActivity());
    }

    @Test
    public void retrieveProfile_withInteractor_withGoodParams() {
        Profile profile = mInteractor.getProfile(1);

        assertEquals("NG", profile.getLastname());
        assertEquals("Tai", profile.getName());
        assertEquals("Developer", profile.getFunction());
        assertEquals("Android", profile.getFunctionOs());
    }

    @Test
    public void retrieveProfile_withInteractor_withBadParams() {
        Profile profile = mInteractor.getProfile(-2);

        assertNull(profile);
    }

    @Test
    public void testView() {
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        Intent intent = new Intent();
        intent.putExtra("id", 1);
        setActivityIntent(intent);

        assertEquals("NG", ((TextView) getActivity().findViewById(R.id.user_lastname)).getText().toString());
        assertEquals("Tai", ((TextView) getActivity().findViewById(R.id.user_name)).getText().toString());
        assertEquals("Developer", ((TextView) getActivity().findViewById(R.id.user_function)).getText().toString());
        assertEquals("Android", ((TextView) getActivity().findViewById(R.id.user_function_os)).getText().toString());
    }
}