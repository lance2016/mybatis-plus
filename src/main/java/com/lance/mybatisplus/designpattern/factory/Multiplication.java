package com.lance.mybatisplus.designpattern.factory;

/**
 * @program: mybatisplus  Multiplication
 * @description:
 * @author: flchen
 * @create: 2021-11-22 10:38
 **/

public class Multiplication implements Calculate {
    @Override
    public int getResult(int a, int b) {
        return a*b;
    }
}
