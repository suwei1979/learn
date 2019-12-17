/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.bridge.sample;

import lombok.Data;

/**
 * Bag
 *
 * @author suwei
 * @since 2019/12/16 : 3:49 PM
 **/
@Data
public class Bag {

    private Color color;

    private Usage usage;

    protected Brand brand;

}
