/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.bocsoft.metis.commons.log;

import com.google.common.collect.ImmutableMap;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.MDC;
import org.suw.learn.gaea.log.GaeaLogUtil;
import org.suw.learn.metis.commons.log.LogProType;
import org.suw.learn.metis.commons.utils.LoggingUtils;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by zion on 2015/4/2 0002.
 */
public class LogProTypeUT {

    private String uuid;
    private String product;

    @Before
    public void initSystem() {
        uuid = LoggingUtils.createProcessOrInteractionId();
        product = "metis";
        System.setProperty("gaea_product_id", product);
        MDC.setContextMap(ImmutableMap.of("uuid", uuid, "process", uuid));
    }

    @Test
    public void getSystemPro() {
        assertThat(LoggingUtils.getLogProperty(LogProType.PRODUCT_ID)).isEqualTo(product);
        assertThat(LoggingUtils.getLogProperty(LogProType.UUID)).isEqualTo(uuid);
        assertThat(LoggingUtils.getLogProperty(LogProType.PROCESS_ID)).isEqualTo(uuid);
    }

    @Test
    public void getPropertyKey() {
        assertThat(LogProType.PRODUCT_ID.getType()).isEqualTo(GaeaLogUtil.GAEA_PRODUCT_NAME);
        assertThat(LogProType.MODULE_ID.getType()).isEqualTo(GaeaLogUtil.GAEA_MODULE_NAME);
        assertThat(LogProType.NODE_ID.getType()).isEqualTo(GaeaLogUtil.GAEA_NODE_NAME);
        assertThat(LogProType.PROCESS_ID.getType()).isEqualTo("process");
        assertThat(LogProType.UUID.getType()).isEqualTo("uuid");
    }
}
