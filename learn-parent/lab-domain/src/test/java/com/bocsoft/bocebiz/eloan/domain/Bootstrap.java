/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain;

import org.suw.learn.metis.commons.loader.Main;

public class Bootstrap {
    public static void main(String[] args) {
        System.setProperty("system.productId", "eloan");
        System.setProperty("system.moduleId", "eloan-domain");
        System.setProperty("system.nodeId", "876");

        Main.main(new String[] {Application.class.getName()});
    }
}