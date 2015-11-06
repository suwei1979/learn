package org.suw.learn.domain.model;

import java.util.HashMap;

public class User {
	private HashMap<String, Address> addresses;
	
	public HashMap<String, Address> getAddresses() {
		return this.addresses;
	}
}
