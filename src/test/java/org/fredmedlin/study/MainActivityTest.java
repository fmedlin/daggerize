package org.fredmedlin.study;

import static org.fest.assertions.api.ANDROID.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertNotNull;

import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class) public class MainActivityTest {

    MainActivity activity;
    TextView statusText;
    @Mock RegistrationManager registrationManager;

    @Before public void setUp() throws Exception {
    	MockitoAnnotations.initMocks(this);
        activity = new MainActivity(registrationManager);
        activity.onCreate(null);
        statusText = (TextView) activity.findViewById(R.id.text_status);
    }

    @Test public void shouldNotBeNull() {
    	assertNotNull(activity);
    	assertNotNull(statusText);
    }

    @Test public void shouldRegisterUser() {
    	activity.registerUser("Alexa");
    	verify(registrationManager).registerUser("Alexa");
    }

    @Test public void shouldNotUseProductionRegistrationSystem_OMFG() {
    	activity.registerUser("LookingForNewJob");
    	verify(registrationManager).registerUser("LookingForNewJob");
    }
}