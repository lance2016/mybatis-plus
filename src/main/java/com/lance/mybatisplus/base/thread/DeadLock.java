package com.lance.mybatisplus.base.thread;

/**
 * 模拟死锁
 **/

public class DeadLock {
    private static String str1 = "1";
    private static String str2 = "2";
    public static void main(String[] args) {

        new Thread(()->{
            synchronized (str1){
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+" got resource1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" waiting to get resource2");
                synchronized (str2){
                    System.out.println(Thread.currentThread().getName()+" got resource2");
                }
            }
        }).start();

        new Thread(()->{
            synchronized (str2){
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+" got resource2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" waiting to get resource1");
                synchronized (str1){
                    System.out.println(Thread.currentThread().getName()+" got resource1");
                }
            }
        }).start();

    }
}
