package com.lance.mybatisplus.designpattern.observor;

/**
 * @program: mybatisplus  ConcreteSubject
 * @description:
 * @author: flchen
 * @create: 2021-11-22 10:19
 **/

public class ConcreteSubject extends Subject {


    @Override
    public void changeState(Integer state) {
        super.setState(state);
        System.out.println(super.getState());
        this.notifiAllObservors();
    }


    public static void main(String[] args) {
        ConcreteSubject self = new ConcreteSubject();
        Observor ob = new ConcreteObservor();
        self.registerObservor(ob);
        self.changeState(233);
    }
}
