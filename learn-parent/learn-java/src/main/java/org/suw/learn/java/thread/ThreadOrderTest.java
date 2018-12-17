/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.java.thread;

import java.util.concurrent.CountDownLatch;

public class ThreadOrderTest {
    private static final int count = 2;
    private static long millisUnit = 1000;

    public static void main(String[] args) throws InterruptedException {
        //Test PreserveOrder Via Join
        ThreadOrderTest threadOrderTest = new ThreadOrderTest();
        System.out.println(count == threadOrderTest.preserveOrderViaJoin() / millisUnit);

        //Test PreserveOrder Via CountdownLatch
        ThreadOrderTest threadOrderTest1 = new ThreadOrderTest();
        System.out.println(1 == threadOrderTest1.preserveOrderViaCountdowwn() / millisUnit);

    }

    public long preserveOrderViaJoin() throws InterruptedException {
        long startMillis = System.currentTimeMillis();
        Thread tmp;

        for (int i = 0; i < count; i++) {
            tmp = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(millisUnit);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "join-" + i);
            tmp.start();
            tmp.join();
        }
        return System.currentTimeMillis() - startMillis;
    }

    public long preserveOrderViaCountdowwn() throws InterruptedException {
        long startMillis = System.currentTimeMillis();

        final CountDownLatch countDownLatch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(millisUnit);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //只要计数器清零，等待的线程就可以开始执行，于是可以达到并发的效果
                    countDownLatch.countDown();
                }
            }, "countDownLatch-" + i).start();
        }

        countDownLatch.await();

        return System.currentTimeMillis() - startMillis;
    }

}
