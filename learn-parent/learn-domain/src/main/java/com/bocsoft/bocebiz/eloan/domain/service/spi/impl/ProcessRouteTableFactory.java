/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.service.spi.impl;

import com.bocsoft.bocebiz.eloan.domain.service.spi.ProcessRouteTable;

public interface ProcessRouteTableFactory {
    ProcessRouteTable getRouteTable(String tableName);
}
