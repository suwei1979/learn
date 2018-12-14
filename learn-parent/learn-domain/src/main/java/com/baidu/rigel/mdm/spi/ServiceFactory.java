/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package com.baidu.rigel.mdm.spi;

/**
 * 服务工厂方法
 *
 * @author suwei
 */
public interface ServiceFactory {
    /**
     * 根据传入的服务接口及Provider名，生成对应的服务对象
     *
     * @param providerName     服务提供者在容器中注册的名称，该类必须实现了{@code serviceInterface接口}
     * @param serviceInterface 服务接口
     *
     * @return 服务提供者，若找不到对应类型的服务提供者则返回{@code null}
     */
    public <S> S create(String providerName, Class<S> serviceInterface);
    // public S create(String providerName, Class<S> classInterface);

    /**
     * 根据传入的服务接口及Provider名、具体的泛型类型，定位对应的服务对象
     *
     * @param providerName        服务提供者在容器中注册的名称，该类必须实现了{@code serviceInterface接口}
     * @param serviceInterface    服务接口
     * @param paramemterizedTypes 泛型类型
     *
     * @return
     */
    public <S> S create(String providerName, Class<S> serviceInterface, Class<?>... paramemterizedTypes);

    /**
     * 根据传入的服务接口具体的泛型类型，定位对应的服务对象
     *
     * @param serviceInterface    服务接口
     * @param paramemterizedTypes 泛型类型
     *
     * @return 匹配的服务对象
     */
    public <S> S create(Class<S> serviceInterface, Class<?>... paramemterizedTypes);

}
