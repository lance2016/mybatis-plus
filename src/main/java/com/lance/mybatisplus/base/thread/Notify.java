package com.lance.mybatisplus.base.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: mybatisplus  Notify
 * @description:
 * @author: flchen
 * @create: 2021-07-04 16:59
 **/

public class Notify {
    public static void main(String[] args) {
        ProvideService list = new ProvideService();
        WaitThread wait = new WaitThread(list);
        ProduceThread produceThread = new ProduceThread(list);
        new Thread(wait).start();
        new Thread(produceThread).start();

    }
}

class ProduceThread implements Runnable {
    private ProvideService list;

    ProduceThread(ProvideService list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            synchronized (list) {
                for (int i = 0; i < 10; i++) {
                    list.add();
                    System.out.println(list.getSize());
                    if (list.getSize() == 5) {
                        list.notify();
                        System.out.println("已经发出通知");
                    }
                    Thread.sleep(2000);
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ProvideService {
    List myList = new ArrayList();

    int getSize() {
        return myList.size();
    }

    void add() {
        myList.add("lance");
    }
}


class WaitThread implements Runnable {

    private ProvideService myService;

    WaitThread(ProvideService list) {
        this.myService = list;
    }

    @Override
    public void run() {
        try {
            synchronized (myService) {

                if (myService.getSize() != 5) {
                    System.out.println("开始等" + System.currentTimeMillis());
                    myService.wait();
                    System.out.println("结束等" + System.currentTimeMillis());
                }
            }
        } catch (
                InterruptedException e) {
            e.printStackTrace();
        }
    }
}
