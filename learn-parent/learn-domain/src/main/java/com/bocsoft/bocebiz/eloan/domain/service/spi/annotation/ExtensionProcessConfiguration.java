/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.service.spi.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 扩展流程执行策略标记
 *
 * @author sw0876
 */
@Documented
@Target({ANNOTATION_TYPE, TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExtensionProcessConfiguration {
    public ProcessExecutionPolicy executionPolicy() default ProcessExecutionPolicy.ASYCHRONIZED;

    public boolean inMainProcessTransaction() default false;

    public ExtensionProcessType type() default ExtensionProcessType.POST_PROCESS;
}
