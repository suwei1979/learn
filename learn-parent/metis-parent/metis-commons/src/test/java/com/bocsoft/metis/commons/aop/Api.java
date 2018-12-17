/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.bocsoft.metis.commons.aop;

import org.suw.learn.gaea.dubbo.Request;
import org.suw.learn.gaea.dubbo.Response;

/**
 * Created by zion on 11/17/14.
 */
public interface Api {

    Response<String> sayHello(Request<String> name);
}
