/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.bocsoft.metis.commons.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.suw.learn.metis.commons.utils.UUIDUtils;

/**
 * Created by zion on 1/30/15.
 */
public class MultiThreadUUID {
    private static Logger logger = LoggerFactory.getLogger(MultiThreadUUID.class);
    public static void main(String[] args) {
        UUIDUtils uuidUtils = new UUIDUtils(3);
        Thread[] threads = new Thread[100];
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 1; j <= 200; j++) {
                        logger.info("{}", UUIDUtils.nextIdNumeric());
                    }
                }
            });
        }

        for (int i = 0; i < 100; i++) {
            threads[i].start();
        }
        stopWatch.stop();
        System.out.println("time consumed: " + stopWatch.getTotalTimeMillis());
    }
}
