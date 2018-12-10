/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.spring.beans.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author suwei
 *
 */
@Data
@RequiredArgsConstructor
public class Item {

    private final String name;
    private Number price;
    private int quantity;
}
