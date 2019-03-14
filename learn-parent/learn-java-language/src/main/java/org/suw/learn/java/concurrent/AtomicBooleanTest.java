/*
 * Copyright (C) 2019 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.java.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @classname: AtomicBooleanTest
 * @author: suwei
 * @description:
 * @date: created in 2019/1/23 : 4:40 PM
 * @modified
 **/
public class AtomicBooleanTest {
    public static void main(String... args) throws InterruptedException {
        BarWorker bar1 = new BarWorker("bar1");
        BarWorker bar2 = new BarWorker("bar2");
        new Thread(bar1).start();
        new Thread(bar2).start();

        Thread.currentThread().sleep(5000);

        BarWorkerAtomic bar3 = new BarWorkerAtomic("bar3");
        BarWorkerAtomic bar4 = new BarWorkerAtomic("bar4");

        new Thread(bar3).start();
        new Thread(bar4).start();
    }
}


class BarWorker implements Runnable {
    private static boolean exists = false;
    private String name;

    public BarWorker(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        if (!exists) {
            try {
                TimeUnit.SECONDS.sleep(1);

            } catch (InterruptedException e) {
                //do nothing
            }

            exists = true;
            System.out.println(name + " enter");

            try {
                System.out.println(name + "working");
                TimeUnit.SECONDS.sleep(2);

            } catch (InterruptedException e) {
                // do nothing
            }
            System.out.println(name + " leave");
            exists = false;

        } else {
            System.out.println(name + " give up");
        }
    }
}

class BarWorkerAtomic implements Runnable{
    private static AtomicBoolean exists = new AtomicBoolean(false);
    private String name;

    public BarWorkerAtomic(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        if (exists.compareAndSet(false, true)) {
            System.out.println(name + " enter");
            try {
                System.out.println(name + " working");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                //do nothing
            }
            System.out.println(name + " leave");
            exists.set(false);
        } else {
            System.out.println(name + " give up");
        }
    }

}
