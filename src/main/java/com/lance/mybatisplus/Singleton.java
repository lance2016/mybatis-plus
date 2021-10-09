package com.lance.mybatisplus;

import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: mybatisplus  Singleton
 * @description:
 * @author: flchen
 * @create: 2021-07-06 10:37
 **/

public class Singleton {

    private volatile static Singleton singleton;

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
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,10,0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new DefaultThreadFactory("thread-poll-"), new ThreadPoolExecutor.AbortPolicy());
        Semaphore semaphore = new Semaphore(5);
        for(int i=0;i<10;i++){
            executor.submit(()->{
                if(semaphore.availablePermits()==0){
                    System.out.println("资源不足，请耐心等待");
                }
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "获取令牌");
                    Thread.sleep(1000);
                    Singleton singleton = Singleton.getInstance();
                    System.out.println(singleton.hashCode());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + "释放资源");
                }


            });
        }
        executor.shutdown();
    }
}
