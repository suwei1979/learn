/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.ddd.domain.model;

import org.suw.lab.ddd.validation.constraints.ZipCode;

public class Address {
    private String street;
    private Country country;

    @ZipCode(countryCode = "CN")
    private String zipCode;

    public String getStreet() {
        return street;
    }

    public Country getCountry() {
        return country;
    }
}
