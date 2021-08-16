package com.lance.mybatisplus.base.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: mybatisplus  MyThread4
 * @description:
 * @author: flchen
 * @create: 2021-07-04 00:30
 **/

public class MyThread4 {

    public static void main(String[] args) throws InterruptedException {

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("123");
//            }
//        }).start();

//        MyThreadTest m = new MyThreadTest();
//        Thread t = new Thread(m);
//        t.start();
//        Thread.sleep(2000);
//        t.interrupt();


//        MyObject myObject = new MyObject();
//        for(int i=0;i<1000;i++){
//            ThreadObject t1 =new ThreadObject(myObject);
//            Thread thread = new Thread(t1);
//            thread.start();
//        }
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        S s = new S();
        for (int i = 0; i < 10; i++) {
            ThreadS threadS = new ThreadS(s);
            Thread thread = new Thread(threadS);
            thread.start();
        }

    }
}

class MyObject {
    private int num = 0;

    public synchronized void addNum() {
        System.out.println(++num);
    }
}

class ThreadObject implements Runnable {
    private MyObject obj;

    ThreadObject(MyObject obj) {
        this.obj = obj;
    }

    @Override
    public void run() {

    }
}


class MyThreadTest implements Runnable {
    int num = 0;

    @Override
    public void run() {
        for (int i = 0; i < 50000000; i++) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("break");
                break;
            }
            System.out.println(i);
        }
    }
}


class S {
    AtomicInteger  count = new AtomicInteger(0);

    synchronized void printCount() {
            System.out.println(count.addAndGet(100));
            count.addAndGet(1);
    }
}

class ThreadS implements Runnable {

    private S s;

    ThreadS(S s) {
        this.s = s;
    }

    @Override
    public void run() {
        s.printCount();
    }
}

