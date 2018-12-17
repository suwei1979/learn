/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.domain.model;

import javax.validation.constraints.NotNull;

import org.suw.learn.validation.constraints.Email;
import org.suw.learn.validation.constraints.ZipCode;

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
