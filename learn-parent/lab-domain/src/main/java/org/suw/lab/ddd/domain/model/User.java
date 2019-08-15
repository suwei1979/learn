/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.ddd.domain.model;

import java.util.HashMap;

public class User {
    private HashMap<String, Address> addresses;

    public HashMap<String, Address> getAddresses() {
        return this.addresses;
    }
}
