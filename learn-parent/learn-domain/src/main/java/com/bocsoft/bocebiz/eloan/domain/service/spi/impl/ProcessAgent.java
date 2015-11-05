package com.bocsoft.bocebiz.eloan.domain.service.spi.impl;

import java.lang.reflect.Method;

public interface ProcessAgent {

	public Object process(Method method, Object... args);

	public Class<?>[] getProxyedInterfaces();

}