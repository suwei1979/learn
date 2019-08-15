/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.ddd.domain.model;

import javax.validation.constraints.NotNull;

import org.suw.lab.ddd.validation.constraints.Email;
import org.suw.lab.ddd.validation.constraints.ZipCode;

@SuppressWarnings("unused")
public class Customer {
    private String name;
    private String customerId;
    @Email(message = "email must has a regular format")
    @NotNull(message = "email can't be null")
    private String email;
    @ZipCode(countryCode = "CN")
    private String zipCode;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
