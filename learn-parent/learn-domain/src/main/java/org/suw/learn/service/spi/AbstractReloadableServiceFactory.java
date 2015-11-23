/**
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.service.spi;

import java.util.HashMap;
import java.util.Map;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author suwei
 *
 * @param <S> 服务接口
 */
@Data
public abstract class AbstractReloadableServiceFactory<S> implements ReloadableServiceFactory<S> {
    @Setter(value = AccessLevel.NONE)
    @Getter(value = AccessLevel.NONE)
    protected Map<String, S> cachedProviders = new HashMap<String, S>();
    private LoadStrategy loadStrategy = LoadStrategy.EAGER;
    private Class<S> serviceInterface;

    // private boolean loadO
    protected AbstractReloadableServiceFactory(Class<S> serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

    /**
     * 清空缓存
     */
    protected void clearCacheProviders() {
        if (cachedProviders != null) {
            cachedProviders.clear();
        }
    }

    @Override
    public S create(String providerName) {
        S result = cachedProviders.get(providerName);
        if (result == null) {
            if (loadStrategy == LoadStrategy.LAZY) {
                S providerFromContainer = load(serviceInterface, providerName);
                if (providerFromContainer != null)
                    cachedProviders.put(providerName, providerFromContainer);
            }
        }
        return result;
    }

    public enum LoadStrategy {
        EAGER, LAZY
    }
}
