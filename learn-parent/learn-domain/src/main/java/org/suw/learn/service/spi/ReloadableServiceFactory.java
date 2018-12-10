/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.service.spi;

/**
 * 可重载的抽象服务工厂类
 * 
 * @author suwei
 *
 * @param <S> 服务接口，可以为接口、抽象类及具体类，但推荐为接口
 */
public interface ReloadableServiceFactory<S> extends ServiceFactory<S> {
    /**
     * 从具体的容器中加载具体类
     * @param serviceInterface 服务接口
     * @param providerName 具体的提供者名称
     * @return 具体的服务提供者
     */
    public S load(Class<S> serviceInterface, String providerName);

    /**
     * 从容器中重新加载所有以缓存的服务提供者。
     */
    public void reload();
}
