/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.ddd.chapter10;

public class Facility {
    private SharePie shares;

    public SharePie calculateDrawDownDefaultDistribution(double drawDownAmount) {
        return shares.prorated(drawDownAmount);
    }
}
