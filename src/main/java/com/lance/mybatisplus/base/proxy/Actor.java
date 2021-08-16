package com.lance.mybatisplus.base.proxy;

/**
 * @program: mybatisplus  Actor
 * @description:
 * @author: flchen
 * @create: 2021-07-15 22:25
 **/

public class Actor implements Person {
    @Override
    public void saySomething() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("I am an actor");
    }

    @Override
    public void saySomething2() {
        System.out.println("I am an actress");
    }
}
