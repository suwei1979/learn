/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.book.ddd.chapter10;

public class Facility {
    private SharePie shares;

    public SharePie calculateDrawDownDefaultDistribution(double drawDownAmount) {
        return shares.prorated(drawDownAmount);
    }
}
