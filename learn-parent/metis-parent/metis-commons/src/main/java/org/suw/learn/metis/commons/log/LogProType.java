/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.metis.commons.log;

import org.suw.learn.gaea.log.GaeaLogUtil;

/**
 * Gaea Log Protocol has five elements, including
 * product, module, node, process, uuid. LogProType includes
 * key names of these five element stored in maps.
 */
public enum LogProType {
    PRODUCT_ID(GaeaLogUtil.GAEA_PRODUCT_NAME),
    MODULE_ID(GaeaLogUtil.GAEA_MODULE_NAME),
    NODE_ID(GaeaLogUtil.GAEA_NODE_NAME),
    PROCESS_ID("process"),
    UUID("uuid");

    private String type;

    LogProType(final String type) {
        this.type = type;
    }

    /**
     * Get type key name.
     *
     * @return key name of specific type.
     */
    public String getType() {
        return type;
    }
}
