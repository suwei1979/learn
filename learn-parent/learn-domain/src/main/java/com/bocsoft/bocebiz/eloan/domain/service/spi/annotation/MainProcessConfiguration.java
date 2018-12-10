/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.service.spi.annotation;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 可扩展流程的配置元数据，当在Service上配置了ExtensibleProcessConfig后，<br/>
 * 流程扩展机制将自动为Service生成流程代理（ProcessAgent）。流程代理将按<br/>
 * ExtensibleProcessConfig中定义的配置信息触发流程的预处理、后处理事件。
 * @author sw0876
 *
 */
@Documented
@Target( {TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MainProcessConfiguration {
	/**
	 * 当前主流程副流程路由表名称，为具体的流程路由表所对应的类名或者在容器 <br/>
	 * 声明的Bean名称。
	 * @return 
	 */
	public String routeTable();

	Class<?>[] proxyedInterfaces();
	String[] proxyedMethods() default {""};
}
