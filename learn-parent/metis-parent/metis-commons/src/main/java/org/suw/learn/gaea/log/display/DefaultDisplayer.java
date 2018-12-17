/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.gaea.log.display;

class DefaultDisplayer extends LogDisplayer {

	private Object toLogData;
	
	DefaultDisplayer(Object toLogData) {
		this.toLogData = toLogData;
	}

	@Override
	public String toString() {
		if(toLogData == null)
			return "";
		else
			return toLogData.toString();
	}

}
