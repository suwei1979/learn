package com.bocsoft.bocebiz.eloan.domain.service.spi;

import org.springframework.stereotype.Component;

@Component("testRouteTable")
public class TestProcessRouteTable implements ProcessRouteTable {

	@Override
	public String route(Object... args) {
		// TODO Auto-generated method stub
		return "testExtensionProcess";
	}

}
