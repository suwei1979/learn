/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package test.spring.methodinjection;

public interface Command {

    void setState(Object commandState);

    Object execute();

}
