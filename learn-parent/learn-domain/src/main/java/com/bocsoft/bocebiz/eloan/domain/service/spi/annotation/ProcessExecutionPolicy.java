/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.service.spi.annotation;

/**
 * 扩展流程执行策略
 *
 * @author sw0876
 */
public enum ProcessExecutionPolicy {
    /**
     * 纳入主流程事务执行
     */
    SYNCHRONIZED,
    /**
     * 异步执行<br>
     * 注意：<br>
     * 1. 异步执行策略下，将消灭所有下层异常以保证主流程的事务性<br>
     * 2. 以异步方式执行的副流程，需要考虑一旦流程中断后的重新吊起机制<br>
     */
    ASYCHRONIZED
}
