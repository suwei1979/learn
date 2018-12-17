/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.java.thread;

import java.util.HashMap;

public class ThreadLocalTest {
    static ThreadLocal<HashMap<String, Object>> threadLocal = new ThreadLocal<HashMap<String, Object>>() {
        @Override
        protected HashMap<String, Object> initialValue() {
            System.out.println("Thread - " + Thread.currentThread().getId() + " initialValue");
            //可以在这里为各线程的Map设置初始值

            HashMap<String, Object> result = new HashMap<String, Object>();
            Long id = Thread.currentThread().getId();
            System.out.println("Thread ID is: " + id);
            for (int i = 0; i < 10; i++) {
                result.put("Reserved Key: " + i, i + id * 10);
                try {
                    Thread.sleep(100);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            result.put("" + 99999, "Reserved Thread ID - " + Thread.currentThread().getId());
            return result;
        }
    };

    /**
     * Main
     *
     * @param args
     */
    public static void main(String[] args) {
        ThreadLocalTest test = new ThreadLocalTest();
        test.run();
    }

    public void run() {
        Thread[] runs = new Thread[3];
        for (int i = 0; i < runs.length; i++) {
            runs[i] = new Thread(new T1(i));
        }
        for (int i = 0; i < runs.length; i++) {
            runs[i].start();
        }
    }

    public static class T1 implements Runnable {
        int id;

        public T1(int id0) {
            id = id0;
        }

        public void run() {
            System.out.println("Thread " + Thread.currentThread().getId() + ": start");
            HashMap<String, Object> map = threadLocal.get();
            System.out.println("Thread " + Thread.currentThread().getId() + ": " + map);
        }
    }
}
