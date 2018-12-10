/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.service.spi;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.suw.learn.metis.commons.utils.SpringUtils;

import com.bocsoft.bocebiz.eloan.domain.ITContext;
import com.bocsoft.bocebiz.eloan.domain.service.apply.ApplyService;
import com.bocsoft.bocebiz.eloan.domain.service.spi.impl.ExtensionProcessFactory;
import com.bocsoft.bocebiz.eloan.domain.service.spi.impl.ProcessRouteTableFactory;
import com.bocsoft.bocebiz.eloan.domain.service.spi.impl.spring.ExtensionProcessAssembler;

public class ExtensionProcessAssemblerTest  extends ITContext implements ApplicationContextAware {

	private ExpectedException exception = ExpectedException.none();
	@Test
	public void testAssembleResult() {
		ExtensionProcessAssembler assembler = SpringUtils.getBean(ExtensionProcessAssembler.class);
		ProcessRouteTableFactory routeTable = SpringUtils.getBean(ProcessRouteTableFactory.class);
		ExtensionProcessFactory extensionProcessFactory = SpringUtils.getBean(ExtensionProcessFactory.class);
		assertThat(assembler).isNotNull();
		assertThat(routeTable).isNotNull();
		assertThat(extensionProcessFactory).isNotNull();
		
		ApplyService testApplyService =SpringUtils.getBean("testApplyService", ApplyService.class);
		testApplyService.initApplication("test", "test");
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		
	}
}
