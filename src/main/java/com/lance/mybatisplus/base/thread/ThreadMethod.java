package com.lance.mybatisplus.base.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现多线程的三种方法
 * 1. 继承Thread类，重写run方法
 * 2. 实现Runnable接口，实现run方法
 * 3. 实现Callable接口，实现call方法
 **/

public class ThreadMethod {
    public static void main(String[] args) {
        //method 1
        MyThread thread1 = new MyThread("thread1");
        thread1.start();
        // method 2
        MyThread2 myThread2 = new MyThread2();
        Thread thread2 = new Thread(myThread2,"thread2");
        thread2.start();
        // methed 3
        MyThread3 myThread3 = new MyThread3();
        //执行 Callable 方式，需要 FutureTask 实现类的支持，用于接收运算结果。
        FutureTask<Integer> result = new FutureTask<>(myThread3);
        Thread thread3 = new Thread(result,"thread3");
        thread3.start();
        try {
            System.out.println(result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        List<List<Integer>> list = new ArrayList<>();
    }
}




/**
 * 1. 继承Thread类，重写run方法
 */
class MyThread extends Thread{

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        System.out.println(Thread.currentThread().getName());
    }
}

/**
 * 2. 实现Runnable接口，实现run方法
 */
class MyThread2 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

/**
 * 3 实现Callable接口，实现call方法
 */

class MyThread3 implements Callable<Integer>{
    int num =0;
    @Override
    public Integer call()  {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i <1000 ; i++) {
            num += i;
        }
        return num;
    }
}