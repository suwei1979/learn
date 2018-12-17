/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.bocsoft.metis.commons.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.suw.learn.metis.commons.log.annotation.BusiLog;

/**
 * Created by zion on 11/17/14.
 */
@Slf4j
@Service
public class AService {
  @Autowired
  BService bService;

  @BusiLog(module = "A", operation = "say")
  public void say() {
    log.info("World");
//        throw new IllegalArgumentException("Hello World");
  }

  @BusiLog
  public String sya(String arg) {
    log.info("Hello " + bService.getB());
    return "123";
  }
}
