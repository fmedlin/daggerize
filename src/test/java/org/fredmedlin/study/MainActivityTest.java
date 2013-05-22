package org.fredmedlin.study;

import static org.fest.assertions.api.ANDROID.assertThat;
import static org.junit.Assert.assertNotNull;

import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class) public class MainActivityTest {

    MainActivity activity;
    TextView statusText;

    @Before public void setUp() throws Exception {
        activity = new MainActivity();
        activity.onCreate(null);
        statusText = (TextView) activity.findViewById(R.id.text_status);
    }

    @Test public void shouldNotBeNull() {
    	assertNotNull(activity);
    	assertNotNull(statusText);
    }

    @Test public void shouldRegisterUser() {
    	activity.registerUser("Alexa");
    	assertThat(statusText).containsText("Just registered Alexa");
    }

    @Test public void shouldNotUseProductionRegistrationSystem_OMFG() {
    	activity.registerUser("LookingForNewJob");
    	assertThat(statusText).doesNotContainText("production.registration.system");    	
    }
}