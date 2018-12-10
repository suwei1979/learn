/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.service.spi;

import java.util.ServiceLoader;

/**
 * 
 * @author suwei
 *
 */
public class JvmServiceFactory<S> extends AbstractReloadableServiceFactory<S> {
    private ServiceLoader<S> jvmServiceLoader;

    /**
     * @param serviceInterface
     */
    protected JvmServiceFactory(Class<S> serviceInterface) {
        super(serviceInterface);
        this.jvmServiceLoader = ServiceLoader.load(serviceInterface);
        super.setLoadStrategy(LoadStrategy.EAGER);
        reload();
    }

    /**
     * 
     * @see org.suw.learn.mdm.common.spi.ReloadableServiceFactory#load(java.lang.Class, java.lang.String)
     */
    @Override
    public S load(Class<S> serviceInterface, String providerName) {
        for (S serviceProvider : jvmServiceLoader) {
            if (serviceProvider.getClass().getName().equals(providerName)) {
                return serviceProvider;
            }
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.suw.learn.mdm.common.spi.ReloadableServiceFactory#reload()
     */
    @Override
    public void reload() {
        jvmServiceLoader.reload();
        super.clearCacheProviders();
        for (S serviceProvider : jvmServiceLoader) {
            super.cachedProviders.put(serviceProvider.getClass().getName(), serviceProvider);
        }

    }

//    public static <S> ServiceFactory<S> getInstance(Class<S> serviceInterface) {
//        return new JvmServiceFactory<S>(serviceInterface);
//    }

}
