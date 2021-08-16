package com.lance.mybatisplus.base.thread;

import lombok.Data;

/**
 * @program: mybatisplus  Produce
 * @description:
 * @author: flchen
 * @create: 2021-07-04 19:39
 **/
@Data
public class ValueObject {
    public static String value = "";

    public static void main(String[] args) {

        new Thread (() -> System.out.println("1")).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("2");
            }
        }).start();
        Object o = new Object();
        Produce233 p = new Produce233(o);
        Consume233 c = new Consume233(o);
        ProduceThread233 produceThread233 = new ProduceThread233(p);
        ConsumeThread233 consumeThread233 = new ConsumeThread233(c);
        ConsumeThread233 consumeThread234 = new ConsumeThread233(c);

        new Thread(produceThread233).start();
        new Thread(consumeThread233).start();
        new Thread(consumeThread234).start();
    }
}

class ProduceThread233 implements Runnable {

    private Produce233 p;

    ProduceThread233(Produce233 p) {
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            p.setValue();
        }
    }
}

class ConsumeThread233 implements Runnable {
    private Consume233 c;

    ConsumeThread233(Consume233 c) {
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            c.getValue();

        }
    }
}


class Produce233 {
    private Object lock;

    Produce233(Object o) {
        this.lock = o;
    }

    void setValue() {
        try {
            synchronized (lock) {
                if (!ValueObject.value.equals("")) {
                    lock.wait();
                } else {
                    ValueObject.value = String.valueOf(System.currentTimeMillis());
                    System.out.println("set " +ValueObject.value);
                    Thread.sleep(1000);
                    lock.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Consume233 {
    private Object lock;

    Consume233(Object object) {
        this.lock = object;
    }

    public void getValue() {
        try {
            synchronized (lock) {
                if (!ValueObject.value.equals("")) {
                    System.out.println("get " + ValueObject.value);
                    ValueObject.value = "";
                    Thread.sleep(1000);
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


