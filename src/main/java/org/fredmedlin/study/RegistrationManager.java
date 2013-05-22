package org.fredmedlin.study;

public class RegistrationManager {

	public static RegistrationManager instance;

	public static RegistrationManager getInstance() {
		if (instance == null) {
			instance = new RegistrationManager();
		}
		return instance;
	}

	private RegistrationManager() {
		// Not for public consumption
	}

	public String registerUser(String name) {
		return "Just registered " + name + " on " + getRegistrationUrl();
	}

	public String getRegistrationUrl() {
		return "http://org.production.registration.system.com";
	}
}