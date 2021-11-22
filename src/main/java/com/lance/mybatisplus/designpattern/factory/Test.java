package com.lance.mybatisplus.designpattern.factory;

/**
 * @program: mybatisplus  Test
 * @description:
 * @author: flchen
 * @create: 2021-11-22 10:47
 **/

public class Test {

    private static final String pre = "com.lance.mybatisplus.designpattern.factory.";

    public static void main(String[] args) {

        Calculate cal = null;
        try {
            cal = SimpleFactory.getInstance(pre + "Multiplication");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("找不到指定类路径");
        }
        if (cal != null) {
            System.out.println(cal.getResult(1, 2));
        }

    }
}
