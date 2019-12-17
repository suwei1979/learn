/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.bridge.sample;

import lombok.Data;

@Data
public class Brand {
    private String name;
    private String description;

    public Brand(String name) {
        this.name = name;
    }
}
