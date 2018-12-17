/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.service.apply;

import java.util.Map;

import com.bocsoft.bocebiz.eloan.domain.model.application.PartyFactory;

public interface PartyFactoryLoader {
    Map<String, PartyFactory> load();

    public PartyFactory getPartyFactory(String partyType);
}
