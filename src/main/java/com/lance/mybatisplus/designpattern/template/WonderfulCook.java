package com.lance.mybatisplus.designpattern.template;

/**
 * @program: mybatisplus  WonderfulCook
 * @description:
 * @author: flchen
 * @create: 2021-11-23 00:41
 **/

public class WonderfulCook extends Cook {
    @Override
    public void stapleFood() {
        System.out.println("主食是馒头");
    }

    @Override
    public void juice() {
        System.out.println("饮料是橙汁");
    }

    @Override
    void food() {
        System.out.println("菜是白菜炖粉条");
    }

    @Override
    void dessert() {
        System.out.println("甜点是草莓巧克力冰淇淋");
    }
}
