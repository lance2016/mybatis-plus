package com.lance.mybatisplus.base.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: mybatisplus  MyService
 * @description:
 * @author: flchen
 * @create: 2021-07-05 23:05
 **/

public class MyService {
    ReentrantLock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    private String value = "";

    public static void main(String[] args) {
        MyService service = new MyService();
        new Thread(() -> {
            while (true) {
                service.get();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                service.set();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                service.get();
            }
        }).start();
    }

    void get() {
        lock.lock();
        try {
            while ("".equals(value)) {
                conditionA.await();
            }
            System.out.println("get: " + value);
            value = "";
            conditionA.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void set() {
        lock.lock();
        try {
            while (!"".equals(value)) {
                conditionA.await();
            }
            value = Math.random() + "";
            System.out.println("set: " + value);
            conditionA.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class ThreadA implements Runnable {
    MyService myService;

    ThreadA(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        while (true) {
            myService.get();
        }
    }
}


class ThreadB implements Runnable {
    MyService myService;

    ThreadB(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        while (true) {
            myService.get();
        }
    }
}


