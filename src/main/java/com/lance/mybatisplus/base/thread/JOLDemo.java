package com.lance.mybatisplus.base.thread;

import org.openjdk.jol.info.ClassLayout;

/**
 * @program: mybatisplus  JOLDemo
 * @description:
 * @author: flchen
 * @create: 2021-04-18 23:33
 **/

public class JOLDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        Thread.sleep(4000);
        Object object2 = new Object();

        System.out.println(ClassLayout.parseInstance(object2).toPrintable());

    }
}
