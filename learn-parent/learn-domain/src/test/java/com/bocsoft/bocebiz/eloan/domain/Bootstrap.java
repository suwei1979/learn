package com.bocsoft.bocebiz.eloan.domain;

import com.bocsoft.metis.commons.loader.Main;

public class Bootstrap {
    public static void main(String[] args) {
    	System.setProperty("system.productId", "eloan");
    	System.setProperty("system.moduleId", "eloan-domain");
    	System.setProperty("system.nodeId", "876");
    	
        Main.main(new String[] { Application.class.getName() });
    }
}