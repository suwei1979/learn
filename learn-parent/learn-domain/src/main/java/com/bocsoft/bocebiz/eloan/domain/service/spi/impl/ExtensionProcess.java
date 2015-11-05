package com.bocsoft.bocebiz.eloan.domain.service.spi.impl;

import java.lang.reflect.Method;

import com.bocsoft.bocebiz.eloan.domain.service.spi.annotation.ExtensionProcessType;

public interface ExtensionProcess {

	Object process(Method method, Object... args);
	
	ExtensionProcessType getType();
}
