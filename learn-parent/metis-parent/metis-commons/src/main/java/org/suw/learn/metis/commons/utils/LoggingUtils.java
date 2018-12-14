package org.suw.learn.metis.commons.utils;

import org.slf4j.MDC;
import org.suw.learn.gaea.log.GaeaLogUtil;
import org.suw.learn.metis.commons.log.LogProType;

import java.util.UUID;

/**
 * Logging utility.
 */
public final class LoggingUtils {

    /**
     * Set System Properties for Logging
     *
     * @param productId product id
     * @param moduleId  module id
     * @param nodeId    node id
     */
    public static void initSystemLoggingArgs(String productId, String moduleId, String nodeId) {
        System.setProperty(GaeaLogUtil.GAEA_PRODUCT_NAME, productId);
        System.setProperty(GaeaLogUtil.GAEA_MODULE_NAME, moduleId);
        System.setProperty(GaeaLogUtil.GAEA_NODE_NAME, nodeId);
        GaeaLogUtil.registerProcessID(createProcessOrInteractionId());
    }

    /**
     * generate uuid for log.
     * This method is to generate the processId and interactionId of gaea log
     *
     * @return A string
     */
    public static String createProcessOrInteractionId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * Get log properties: productId, moduleId,
     * @param type LogProType
     * @return property value
     */
    public static String getLogProperty(LogProType type) {
        if (type == LogProType.UUID || type == LogProType.PROCESS_ID) {
            return MDC.get(type.getType());
        } else {
            return System.getProperty(type.getType());
        }
    }

    private LoggingUtils() {
    }

}
