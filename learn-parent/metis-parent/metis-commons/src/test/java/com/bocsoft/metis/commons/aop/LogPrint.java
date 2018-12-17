/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.bocsoft.metis.commons.aop;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.suw.learn.gaea.dubbo.Response;
import org.suw.learn.gaea.dubbo.factory.RequestFactory;
import org.suw.learn.metis.commons.utils.LoggingUtils;

/**
 * Created by zion on 12/1/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:consumer.xml")
public class LogPrint {
  @Autowired
  private Api api;

  @BeforeClass
  public static void init() {
    LoggingUtils.initSystemLoggingArgs("metis", "consumer", "007");
  }

  @Test
  public void multiThreadLogging() throws InterruptedException {
    for (int i = 1; i <= 10; i++) {
      new Thread("Thread" + i) {
        @Override
        public void run() {
         log();
        }
      }.start();
    }
    Thread.sleep(10000);
  }

  public void log() {
    Response<String> response = api.sayHello(RequestFactory.createRequest("World"));
    System.out.println(response);
  }
}
