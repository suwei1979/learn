package org.suw.learn.gaea.log;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.MDC;

public class GaeaLogUtil {
	
	public static final String GAEA_PRODUCT_NAME = "gaea_product_id";
	
	public static final String GAEA_MODULE_NAME = "gaea_module_id";
	
	public static final String GAEA_NODE_NAME = "gaea_node_id";

	public static final String GAEA_PROCESS_NAME = "gaea_process_id";
	
	private static Map<String, String> unvariableInfoMap;
	
	static {
		checkAndSet(GAEA_PRODUCT_NAME);
		checkAndSet(GAEA_MODULE_NAME);
		checkAndSet(GAEA_NODE_NAME);
	}
	
	private static void checkAndSet(String infoName) {
		String infoValue = System.getProperty(infoName);
		check(infoName, infoValue);
		if(unvariableInfoMap == null)
			unvariableInfoMap = new HashMap<String, String>();
		unvariableInfoMap.put(infoName, infoValue);
	}
	
	private static void check(String infoName, String infoValue) {
		if(infoValue == null || "".equals(infoValue))
			throw new RuntimeException(infoName + " must be set");		
	}
	
	public static void registerProcessID(String processID) {
		check(GAEA_PROCESS_NAME, processID);
		
		MDC.put("product", unvariableInfoMap.get(GAEA_PRODUCT_NAME));
		MDC.put("module", unvariableInfoMap.get(GAEA_MODULE_NAME));
		MDC.put("node", unvariableInfoMap.get(GAEA_NODE_NAME));
		MDC.put("process", processID);
	}
	
	public static void registerInteractionUUID(String interactionUUID) {
		MDC.put("uuid", interactionUUID);
	}
	
	public static String getProcessID() {
		return MDC.get("process");
	}
	
	public static String getIntetractionUUID() {
		return MDC.get("uuid");
	}
}
