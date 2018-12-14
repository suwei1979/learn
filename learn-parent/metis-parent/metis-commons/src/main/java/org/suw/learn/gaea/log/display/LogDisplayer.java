package org.suw.learn.gaea.log.display;

import java.util.Map;

public abstract class LogDisplayer {

	public static LogDisplayer getDisplayerFor(Object logData) {
		if (logData instanceof byte[]) {
			return new ByteArrayDisplayer((byte[]) logData);
		} else if (logData instanceof Map) {
			return new MapDisplayer(
					(Map<? extends Object, ? extends Object>) logData);
		} else if (logData != null && logData.getClass().isArray()) {
			return new CommonArrayDisplayer(logData);
		} else
			return new DefaultDisplayer(logData);
	}

	abstract public String toString();
}
