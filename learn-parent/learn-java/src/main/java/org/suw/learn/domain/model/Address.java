/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.domain.model;

import org.suw.learn.validation.constraints.ZipCode;

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
