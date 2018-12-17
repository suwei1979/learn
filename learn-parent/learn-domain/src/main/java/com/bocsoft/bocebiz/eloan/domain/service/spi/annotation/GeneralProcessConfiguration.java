/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.service.spi.annotation;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 基本流程的配置元数据，当在Service 上配置了基本流程标签后，流程扩展机制将自动<br/>
 * 为Service生成流程代理（ProcessAgent）。流程代理将按定义的配置信息触发流程的<br/>
 * 预处理、后处理事件。
 *
 * @author sw0876
 */
@Documented
@Target({TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface GeneralProcessConfiguration {
    /**
     * 当前主流程副流程路由表名称，为具体的流程路由表所对应的类名或者在容器 <br/>
     * 声明的Bean名称
     *
     * @return
     */
    public String routeTable();

    /**
     * 指定流程扩展对应的接口
     *
     * @return
     */
    Class<?>[] proxyedInterfaces();

    String[] proxyedMethods() default {""};
}
