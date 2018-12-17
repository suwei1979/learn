/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.pattern.analysis.orghierarchy;

public class Division extends Organization {

    public Division(String name, Company parent) {
        super(name, parent);

    }

    //	@Override
    //	protected void assertValidParent(Organization argParent) {
    //		assert argParent instanceof Company;
    //		super.assertValidParent(argParent);
    //	}

}
