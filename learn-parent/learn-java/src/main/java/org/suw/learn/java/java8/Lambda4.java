/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.java.java8;

public class Lambda4 {
	static int outerStaticNum;
	int outerNum;
	
	void testScopes() {
		Converter<Integer, String> stringConverter = (from) -> {
			outerNum = 23;
			return String.valueOf(from);
		};
		
		Converter<Integer, String> stringConverter1 = (from) -> {
			outerStaticNum = 72;
			return String.valueOf(from);
		};
	}
}
