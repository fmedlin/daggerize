package org.fredmedlin.study;

import static org.fest.assertions.api.ANDROID.*;
import static org.junit.Assert.assertNotNull;

import android.widget.TextView;

import dagger.Module;
import dagger.ObjectGraph;
import dagger.Provides;
import javax.inject.Singleton;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class) public class MainActivityTest {

    MainActivity activity;
    TextView statusText;

    @Before public void setUp() throws Exception {
        activity = new MainActivity();
    	ObjectGraph.create(new FakeRegistrationModule()).inject(activity);
        activity.onCreate(null);
        statusText = (TextView) activity.findViewById(R.id.text_status);
    }

    @Module(
    	injects = MainActivity.class,
    	includes = RegistrationModule.class,
    	overrides = true
    )
    static class FakeRegistrationModule {
    	@Provides @Singleton RegistrationManager provideRegistrationManager() {
    		return new RegistrationManager("http://org.test.registration.system");
    	}
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
    	assertThat(statusText)
    		.containsText("Just registered LookingForNewJob")
    		.doesNotContainText("production.registration.system")
    		.containsText("test.registration.system");
    }
}