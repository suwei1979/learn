/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.spring.beans.model;

import java.util.LinkedHashSet;
import java.util.Set;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author suwei
 *
 */
@Data
@RequiredArgsConstructor
public class Order {
    private final String orderId;
    private Number price;
    private Set<Item> items = new LinkedHashSet<>();

}
