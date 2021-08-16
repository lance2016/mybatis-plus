package com.lance.mybatisplus.base.thread.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: mybatisplus  SequentialExecution
 * @description:
 * @author: flchen
 * 按顺序执行
 * @create: 2021-07-06 21:22
 **/

public class SequentialExecution {
    private volatile static int nowRunning = 1;
    private static Lock lock = new ReentrantLock();
    final private static Condition conditionA = lock.newCondition();
    final private static Condition conditionB = lock.newCondition();
    final private static Condition conditionC = lock.newCondition();

    public static void main(String[] args) {

        ExecutorService execotors = Executors.newCachedThreadPool();
        Thread threadA = new Thread(() -> {
            lock.lock();
            try {
                while (nowRunning != 1) {
                    System.out.println(Thread.currentThread().getName()+ " wait");
                    conditionA.await();
                }
                for (int i = 0; i < 3; i++) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
                nowRunning = 2;
                conditionB.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread threadB = new Thread(() -> {
            lock.lock();
            try {
                while (nowRunning != 2) {
                    System.out.println(Thread.currentThread().getName()+ " wait");
                    conditionB.await();
                }
                for (int i = 0; i < 3; i++) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
                nowRunning = 3;
                conditionC.signalAll();
            } catch (InterruptedException e) {

            } finally {
                lock.unlock();
            }
        });

        Thread threadC = new Thread(() -> {
            lock.lock();
            try {
                while (nowRunning != 3) {
                    System.out.println(Thread.currentThread().getName()+ " wait");
                    conditionC.await();
                }
                for (int i = 0; i < 3; i++) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
                nowRunning = 1;
                conditionA.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });


        Thread a[] = new Thread[100];
        Thread b[] = new Thread[100];
        Thread c[] = new Thread[100];
        for (int i = 0; i < 5 ; i++) {
            a[i] = new Thread(threadA,"A"+i);
            b[i] = new Thread(threadB,"B"+i);
            c[i] = new Thread(threadC, "C"+i);
            a[i].start();
            b[i].start();
            c[i].start();
        }

    }


}

