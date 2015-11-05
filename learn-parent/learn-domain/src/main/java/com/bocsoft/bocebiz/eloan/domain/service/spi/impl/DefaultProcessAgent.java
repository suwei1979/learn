package com.bocsoft.bocebiz.eloan.domain.service.spi.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import com.bocsoft.bocebiz.eloan.domain.service.spi.MainProcessConfigException;
import com.bocsoft.bocebiz.eloan.domain.service.spi.MainProcessExecutionException;
import com.bocsoft.bocebiz.eloan.domain.service.spi.ProcessRouteTable;
import com.bocsoft.bocebiz.eloan.domain.service.spi.annotation.ExtensionProcessType;
import com.bocsoft.bocebiz.eloan.domain.service.spi.annotation.GeneralProcessConfiguration;

@Slf4j
public class DefaultProcessAgent implements ProcessAgent {

	private ProcessRouteTable routeTable;
	private ExtensionProcessFactory extensionFactory;

	private Object concreteService;
	private GeneralProcessConfiguration config;
	private List<String> proxyedMethods = new ArrayList<String>();

	public DefaultProcessAgent(Object concreteService, ProcessRouteTableFactory routeTableFactory,
			ExtensionProcessFactory extensionProcessFactory) {
		if ( !concreteService.getClass().isAnnotationPresent(GeneralProcessConfiguration.class) ) { throw new IllegalArgumentException(
				"The concreteService to be proxy mast ben configured by ExtensibleProcessMeta"); }
		this.concreteService = concreteService;
		this.config = concreteService.getClass().getAnnotation(GeneralProcessConfiguration.class);
		if ( config.proxyedInterfaces() != null && config.proxyedInterfaces().length != 0 ) {
			for (Class<?> proxyedInterface : config.proxyedInterfaces()) {
				proxyedMethods.addAll(getProxyedMethods(proxyedInterface));
			}
		}
		this.routeTable = routeTableFactory.getRouteTable(config.routeTable());
		this.extensionFactory = extensionProcessFactory;
		this.proxyedMethods.addAll(Arrays.asList(config.proxyedMethods()));

	}

	@Override
	public Class<?>[] getProxyedInterfaces() {
		return config.proxyedInterfaces();
	}

	@Override
	public Object process(Method method, Object... args) {
		if ( !proxyedMethods.contains(method.getName()) )
			throw new MainProcessExecutionException("The method fired didn't in the proxyed interface.");
		String extensionProcessName = routeTable.route(args);
		ExtensionProcess extensionProcess = extensionFactory.load(extensionProcessName);
		if ( extensionProcess.getType() == ExtensionProcessType.PRE_PROCESS ) {
			log.info("Firing extension pre-process {} execution start: ", concreteService.getClass().getName() + "." + method.getName());
			extensionProcess.process(method, args);
			log.info("Firing extension pre-process {} execution succeed: ", concreteService.getClass().getName() + "." + method.getName());
		}
		Object result = fireMethod(concreteService, method, args);
		if ( extensionProcess.getType() == ExtensionProcessType.POST_PROCESS ) {
			log.info("Firing extension post-process {} execution start: ", concreteService.getClass().getName() + "." + method.getName());
			extensionProcess.process(method, args);
			log.info("Firing extension post-process {} execution succeed: ", concreteService.getClass().getName() + "." + method.getName());
		}

		return result;
	}

	private List<String> getProxyedMethods(Class<?> proxyedType) {
		if ( !proxyedType.isInterface() )
			throw new MainProcessConfigException("The " + proxyedType.getName() + " + must be an interface");
		Method[] declaredMethods = proxyedType.getDeclaredMethods();
		List<String> results = new ArrayList<String>();
		for (Method method : declaredMethods) {
			results.add(method.getName());
		}
		return results;
	}

	private Object fireMethod(Object object, Method method, Object... args) {
		log.info("Main process {} execution start: ", concreteService.getClass().getName() + "." + method.getName());
		if ( log.isDebugEnabled() ) {
			for (Object arg : args) {
				log.debug("The args is {}", arg);
			}
		}
		Object result = null;
		try {
			result = method.invoke(concreteService, args);
		} catch (IllegalAccessException | IllegalArgumentException e) {
			log.error("Error occured when execution main process {}.{} the error message is {} , the stackTrace is{}", concreteService
					.getClass().getName(), method.getName(), e.getMessage(), e.getStackTrace());
			throw new MainProcessExecutionException(e.getClass().getName(), e.getCause());
		} catch (InvocationTargetException e) {
			log.error("Error occured when execution main process {}.{} the error message is {} , the stackTrace is{}", concreteService
					.getClass().getName(), method.getName(), e.getTargetException().getCause(), e.getTargetException().getStackTrace());
		}
		log.info("Main process {} execution succeed: ", concreteService.getClass().getName() + "." + method.getName());
		return result;
	}
}