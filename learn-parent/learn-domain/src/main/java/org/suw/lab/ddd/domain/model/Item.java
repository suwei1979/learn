/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.ddd.domain.model;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.suw.lab.ddd.validation.constraints.MasterDataEntity;
import org.suw.lab.ddd.validation.constraints.ZipCode;

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
