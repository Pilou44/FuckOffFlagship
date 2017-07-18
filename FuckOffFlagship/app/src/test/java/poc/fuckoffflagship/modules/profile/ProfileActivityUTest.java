package poc.fuckoffflagship.modules.profile;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import poc.fuckoffflagship.data.beans.Profile;

import static org.junit.Assert.*;

public class ProfileActivityUTest {

    public Profile profile = new Profile("Tai", "Ng", "Developer", "Android", "www.facebook.com");

    @Test
    public void testProfileName() {
        assertEquals("Tai", profile.getName());
    }

    @Test
    public void testProfileLastName() {
        assertEquals("Ng", profile.getLastname());
    }

    @Test
    public void testProfileFunction() {
        assertEquals("Developer", profile.getFunction());
    }

    @Test
    public void testProfileFunctionOs() {
        assertEquals("Android", profile.getFunctionOs());
    }

    @Test
    public void testProfilePicture() {
        assertEquals("www.facebook.com", profile.getPictureUrl());
    }
}