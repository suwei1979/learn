/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.domain.model;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.suw.learn.validation.constraints.MasterDataEntity;
import org.suw.learn.validation.constraints.ZipCode;

@Component
@MasterDataEntity
public class Item {
    @NotNull(message = "validate.notnull.item.message")
    private String name;
    private int price;
    @NotNull
    @ZipCode(countryCode = "CN")
    private String zipCode;

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}
