package org.fredmedlin.study;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module (
	injects = MainActivity.class
)
public class RegistrationModule {
    	@Provides @Singleton RegistrationManager provideRegistrationManager() {
    		return new RegistrationManager();
    	}
}