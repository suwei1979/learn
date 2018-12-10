/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.java.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadCreateTest {
    public static void main(String[] args) throws Exception{
        test01();
        test02();
    }

    private static void test01() throws InterruptedException, java.util.concurrent.ExecutionException {
        List<Future<Integer>> list = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            list.add(service.submit(new MyThread((int) (Math.random() * 100))));
        }

        int sum = 0;
        for (Future<Integer> future : list) {
            sum += future.get();
        }

        System.out.println(sum);
    }

    private static void test02() {
        List<Integer> list = new ArrayList<>();

        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            MyThread01 myTask = new MyThread01((int) (Math.random() * 100));
            service.execute(myTask);
            list.add(myTask.getSum());
        }

        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        System.out.println(sum);
    }

}
abstract class AbstractTask {
    private int upperBounds;
    private int sum;
    protected AbstractTask(int upperBounds) {
        this.upperBounds = upperBounds;
    }

    protected void doSum() {
        int sum = 0;
        for (int i = 0; i < upperBounds; i++) {
            sum += (++i);
        }
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }
}

class MyThread extends AbstractTask implements Callable<Integer> {

    public MyThread(int upperBounds) {
        super(upperBounds);
    }

    @Override
    public Integer call() throws Exception {
        doSum();
        return getSum();
    }
}

class MyThread01 extends AbstractTask implements Runnable {

    public MyThread01(int upperBounds) {
        super(upperBounds);
    }

    @Override
    public void run() {
        doSum();
    }
}