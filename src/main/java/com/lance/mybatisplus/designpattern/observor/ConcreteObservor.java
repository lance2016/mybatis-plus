package com.lance.mybatisplus.designpattern.observor;

/**
 * @program: mybatisplus  ConcreteObservor
 * @description:
 * @author: flchen
 * @create: 2021-11-22 10:16
 **/

public class ConcreteObservor implements Observor {
    @Override
    public void update() {
        System.out.println("data updated");
    }
}
