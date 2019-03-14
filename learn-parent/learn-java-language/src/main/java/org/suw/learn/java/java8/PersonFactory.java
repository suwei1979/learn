/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.java.java8;

public interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
