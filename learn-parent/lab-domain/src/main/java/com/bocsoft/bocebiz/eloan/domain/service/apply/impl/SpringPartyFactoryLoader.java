/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.service.apply.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.bocsoft.bocebiz.eloan.domain.model.application.PartyFactory;
import com.bocsoft.bocebiz.eloan.domain.service.apply.PartyFactoryLoader;

public class SpringPartyFactoryLoader implements PartyFactoryLoader, ApplicationContextAware, InitializingBean {

    private ApplicationContext applicationContext;
    private HashMap<String, PartyFactory> cachedPartyFactoryMap = new HashMap<>();

    @Override
    public HashMap<String, PartyFactory> load() {
        Map<String, PartyFactory> partyFactoryMap = applicationContext.getBeansOfType(PartyFactory.class);
        cachedPartyFactoryMap.putAll(partyFactoryMap);

        return cachedPartyFactoryMap;
    }

    public PartyFactory getPartyFactory(String partyName) {
        return cachedPartyFactoryMap.get(partyName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        load();
    }

}
