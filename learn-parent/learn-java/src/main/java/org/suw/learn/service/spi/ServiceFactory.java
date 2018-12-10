/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.service.spi;

/**
 * 服务工厂方法
 *
 * @author suwei
 */
public interface ServiceFactory<S> {
    /**
     * 根据传入的服务接口及Provider名，生成对应的服务对象
     *
     * @param serviceInterface 服务接口
     * @param providerName     服务提供者全路径类名，该类必须实现了{@code serviceInterface接口}
     *
     * @return 服务提供者
     */
    public S create(String providerName);
    //    public S create(String providerName, Class<S> classInterface);
}
