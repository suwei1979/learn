package org.suw.learn.gaea.log.display;

import java.util.Map;

class MapDisplayer extends LogDisplayer {

	private final static String ENTER = System.getProperty("line.separator");

	private Map<? extends Object, ? extends Object> mapData;

	MapDisplayer(Map<? extends Object, ? extends Object> logData) {
		mapData = logData;
	}

	@Override
	public String toString() {
		StringBuffer displayBuffer = new StringBuffer(ENTER);
		for (Object key : mapData.keySet()) {
			displayBuffer.append(LogDisplayer.getDisplayerFor(key))
					.append(" :=")
					.append(LogDisplayer.getDisplayerFor(mapData.get(key)))
					.append(ENTER);
		}
		return displayBuffer.toString();
	}

}
