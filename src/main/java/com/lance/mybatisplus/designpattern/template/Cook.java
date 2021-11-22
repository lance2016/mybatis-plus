package com.lance.mybatisplus.designpattern.template;

/**
 * @program: mybatisplus  Cook
 * @description:
 * @author: flchen
 * @create: 2021-11-23 00:36
 **/

public abstract class Cook {
    public abstract void stapleFood();
    public abstract void juice();
    abstract void food();
    abstract void dessert();

    // 模板方法定义了具体的执行顺序，具体子类实现具体的内部方法
    public void make(){
        // 主食
        stapleFood();
        // 饮料
        juice();
        //菜
        food();
        // 点心
        dessert();


    }
}
