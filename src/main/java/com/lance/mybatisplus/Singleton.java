package com.lance.mybatisplus;

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
        new Thread(() -> System.out.println(Singleton.getInstance())).start();
    }
}
