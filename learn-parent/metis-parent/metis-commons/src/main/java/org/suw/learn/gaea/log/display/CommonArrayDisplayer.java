package org.suw.learn.gaea.log.display;

import java.lang.reflect.Array;

class CommonArrayDisplayer extends LogDisplayer {

	private final static String ENTER = System.getProperty("line.separator");

	private Object toLogArray;

	CommonArrayDisplayer(Object toLogData) {
		toLogArray = toLogData;
	}

	@Override
	public String toString() {
		StringBuffer displayBuffer = new StringBuffer(ENTER).append("{")
				.append(ENTER);
		int arraySize = Array.getLength(toLogArray);
		for (int i = 0; i < arraySize; i++) {
			displayBuffer.append(
					LogDisplayer.getDisplayerFor(Array.get(toLogArray, i)));
			if(i < arraySize - 1) {
				displayBuffer.append(ENTER).append(",").append(ENTER);
			} else {
				displayBuffer.append(ENTER);
			}
		}
		return displayBuffer.append("}").toString();
	}

}
