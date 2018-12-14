package com.bocsoft.metis.commons.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.suw.learn.gaea.dubbo.Request;
import org.suw.learn.gaea.dubbo.Response;
import org.suw.learn.gaea.dubbo.factory.ResponseFactory;

/**
 * Created by zion on 11/17/14.
 */
@Slf4j
@Service
public class Provider implements Api {

    public Response<String> sayHello(Request<String> name) {
        return ResponseFactory.getResponse("Hello " + name.getRequestData(), name);
    }

    @Autowired
    private AService aService;
}
