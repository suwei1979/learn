/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.service.spi;

import org.springframework.stereotype.Component;

@Component("testRouteTable")
public class TestProcessRouteTable implements ProcessRouteTable {

    @Override
    public String route(Object... args) {
        // TODO Auto-generated provider stub
        return "testExtensionProcess";
    }

}
