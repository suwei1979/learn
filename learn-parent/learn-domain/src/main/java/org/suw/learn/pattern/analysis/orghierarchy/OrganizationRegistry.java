/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.pattern.analysis.orghierarchy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class OrganizationRegistry {
	private static Map<String, Organization> instances = new HashMap<String, Organization>();
	public static void clearRegistry() {
		instances = new HashMap<String, Organization>();
	}

	public static Organization get(String name) {
		return instances.get(name);
	}

	public static void put(Organization org) {
		instances.put(org.getName(), org);
	}
	
	public static Collection<Organization> values() {
		return instances.values();
	}
	
}
