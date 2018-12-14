/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.service.spi.impl;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

import com.bocsoft.bocebiz.eloan.domain.service.spi.ExtensionProcessConfigException;
import com.bocsoft.bocebiz.eloan.domain.service.spi.ExtensionProcessExecutionException;
import com.bocsoft.bocebiz.eloan.domain.service.spi.annotation.ExtensionProcessConfiguration;
import com.bocsoft.bocebiz.eloan.domain.service.spi.annotation.ExtensionProcessType;
import com.bocsoft.bocebiz.eloan.domain.service.spi.annotation.ProcessExecutionPolicy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultExtensionProcess implements ExtensionProcess {

    private ExtensionProcessConfiguration config;
    private Object target;
    private Executor executor;

    public DefaultExtensionProcess(Object bean, Executor executor) {
        this.config = bean.getClass().getAnnotation(ExtensionProcessConfiguration.class);

        if (config == null) {
            throw new ExtensionProcessConfigException(
                    "The extension process must be configed with annotation : " + ExtensionProcessConfiguration.class.getName());
        }
        this.target = bean;
        this.executor = executor;
    }

    @Override
    public Object process(Method method, Object... args) {
        Object result = null;
        Throwable exceptionCatched = null;
        if (config.executionPolicy() == ProcessExecutionPolicy.SYNCHRONIZED) {
            exceptionCatched = syncfireProcessExtension(method, args);
        }
        if (config.executionPolicy() == ProcessExecutionPolicy.ASYCHRONIZED) {
            asynfireProcessExtension(method, args);
        }
        if (config.inMainProcessTransaction() && exceptionCatched != null) {
            throw new ExtensionProcessExecutionException(exceptionCatched);
        }
        return result;
    }

    /**
     * 触发标准流程之外的扩展流程。 扩展流程的触发策略参见 {@link } {@link ExtensionProcess}
     * 接口实现方应考虑如何缓存并重新处理这些事件。 对于此服务后续的扩展，可考虑将事件转发至JMS中间件。 <br/>
     *
     * @param event
     *
     * @return
     */
    private Throwable syncfireProcessExtension(Method method, Object... args) {
        Throwable result = null;
        try {
            Method targetMethod = target.getClass().getDeclaredMethod(method.getName(), method.getParameterTypes());
            targetMethod.invoke(target, args);
        } catch (Exception e) {
            log.error("error occured while dispatch process extension named {}, the exception message is {}", target.getClass().getName(),
                    e.getMessage());
            result = new ExtensionProcessExecutionException(e);
        }
        return result;
    }

    private void asynfireProcessExtension(final Method method, final Object... args) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Method targetMethod = target.getClass().getDeclaredMethod(method.getName(), method.getParameterTypes());
                    targetMethod.invoke(target, args);
                } catch (Exception e) {
                    log.error("error occured while dispatch process extension named {}, the exception message is {}",
                            target.getClass().getName(), e.getMessage());
                }
            }
        });
    }

    @Override
    public ExtensionProcessType getType() {
        return config.type();
    }
}
