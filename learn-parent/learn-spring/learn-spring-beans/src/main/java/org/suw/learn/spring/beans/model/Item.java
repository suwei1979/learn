/**
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
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
