package com.lance.mybatisplus.designpattern.template;

/**
 * @program: mybatisplus  CommonCook
 * @description:
 * @author: flchen
 * @create: 2021-11-23 00:45
 **/

public class CommonCook extends Cook {
    @Override
    public void stapleFood() {
        System.out.println("主食是馒头");
    }

    @Override
    public void juice() {
        System.out.println("饮料矿泉水");
    }

    @Override
    void food() {
        System.out.println("菜是煎鸡蛋");
    }

    @Override
    void dessert() {
    }
}
