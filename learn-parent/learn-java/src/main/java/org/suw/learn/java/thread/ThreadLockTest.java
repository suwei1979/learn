/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLockTest {
    public static void main(String[] args) {
        test01();
        test02();
        test03();
    }

    /**
     * 测试不加锁的运行结果
     */
    public static void test01() {
        Account account = new Account();
        ExecutorService service = Executors.newFixedThreadPool(100);

        for (int i = 1; i <= 100; i++) {
            service.execute(new DepositMoney(account, 1));

        }
        service.shutdown();
        while (!service.isTerminated()) {
        }

        System.out.println("账户余额 = " + account.getBalance());

    }

    public static void test02() {
        Account account = new Account();
        ExecutorService service = Executors.newFixedThreadPool(100);

        for (int i = 1; i <= 100; i++) {
            service.execute(new DepositMoneyWithSync(account, 1));

        }
        service.shutdown();
        while (!service.isTerminated()) {
        }

        System.out.println("账户余额 = " + account.getBalance());

    }

    public static void test03() {
        AccountWithReentrantLock account = new AccountWithReentrantLock();
        ExecutorService service = Executors.newFixedThreadPool(100);

        for (int i = 1; i <= 100; i++) {
            service.execute(new DepositMoneyWithLock(account, 1));

        }
        service.shutdown();
        while (!service.isTerminated()) {
        }

        System.out.println("账户余额 = " + account.getBalance());


    }
}

class Account {
    private double balance;

    public void deposit(double money) {
        double newBalance = balance + money;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        balance = newBalance;

    }

    public double getBalance() {
        return balance;
    }
}

class AccountWithReentrantLock {
    private Lock accountLock = new ReentrantLock();
    private double balance;

    public void deposit(double money) {
        accountLock.lock();
        try {
            double newBalance = balance + money;
            try {
                Thread.sleep(10);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance = newBalance;
        } finally {
            accountLock.unlock();
        }

    }

    public double getBalance() {
        return balance;
    }
}

class DepositMoney implements Runnable {
    private Account account;
    private double money;

    public DepositMoney(Account account, double money) {
        this.account = account;
        this.money = money;
    }

    @Override
    public void run() {
        account.deposit(money);
    }
}

class DepositMoneyWithLock implements Runnable {
    private AccountWithReentrantLock account;
    private double money;

    public DepositMoneyWithLock(AccountWithReentrantLock account, double money) {
        this.account = account;
        this.money = money;
    }

    @Override
    public void run() {
        account.deposit(money);
    }
}


class DepositMoneyWithSync implements Runnable {
    private Account account;
    private double money;

    public DepositMoneyWithSync(Account account, double money) {
        this.account = account;
        this.money = money;
    }

    @Override
    public void run() {
        synchronized(account) {
            account.deposit(money);
        }
    }

}
