/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.java.java8;

public interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
