package com.lance.mybatisplus.designpattern.singleton;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: mybatisplus  Singleton
 * @description:
 * @author: flchen
 * @create: 2021-11-22 15:13
 **/

public class Singleton {

    private static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }


    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(100, 100, 0, TimeUnit.SECONDS, new ArrayBlockingQueue(1024), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());
        Lock lock = new ReentrantLock(false);
        for (int i = 0; i < 100; i++) {
            pool.execute(() -> {
                lock.lock();
                try {
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName() + ":" + Singleton.getInstance());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }


            });
        }
    }
}
