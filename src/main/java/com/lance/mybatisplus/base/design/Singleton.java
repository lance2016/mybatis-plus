package com.lance.mybatisplus.base.design;

import lombok.Data;


/**
 * DCS Double Check Singleton 双重校验
 **/

public class Singleton {

    private static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (null == singleton) {
            synchronized (Singleton.class) {
                if (null == singleton) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            Thread2 thread = new Thread2("thread-"+i);
            thread.start();
        }
        System.out.println("start");
    }
}

@Data
class Thread2 extends Thread{
    public Thread2(String name){
        super(name);
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton);
    }
}
