/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.spring.boot;

import org.springframework.context.ApplicationContext;


public interface Application {

    /**
     * @param context
     */
    void run(ApplicationContext context);

}
