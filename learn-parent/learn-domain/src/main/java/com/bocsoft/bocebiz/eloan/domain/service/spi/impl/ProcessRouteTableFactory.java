package com.bocsoft.bocebiz.eloan.domain.service.spi.impl;

import com.bocsoft.bocebiz.eloan.domain.service.spi.ProcessRouteTable;

public interface ProcessRouteTableFactory {
	ProcessRouteTable getRouteTable(String tableName);
}
