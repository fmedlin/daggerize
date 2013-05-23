package org.fredmedlin.study;

import javax.inject.Inject;

public class RegistrationManager {

	String url;
	
	public RegistrationManager() {
		this.url = "http://org.production.registration.system.com";
	}

	public RegistrationManager(String url) {
		this.url = url;
	}

	public String registerUser(String name) {
		return "Just registered " + name + " on " + getRegistrationUrl();
	}

	public String getRegistrationUrl() {
		return url;
	}
}