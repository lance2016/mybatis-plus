package com.lance.mybatisplus.designpattern.factory;

/**
 * @program: mybatisplus  Sum
 * @description:
 * @author: flchen
 * @create: 2021-11-22 10:37
 **/

public class Sum implements Calculate {
    @Override
    public int getResult(int a, int b) {
        return a+b;
    }
}
