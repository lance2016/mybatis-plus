package com.lance.mybatisplus.bytecode;

/**
 * @program: mybatisplus  T005LasyLoading
 * @description:
 * @author: flchen
 * @create: 2021-07-17 22:38
 **/

public class T005LasyLoading {

    public static void main(String[] args) {
        P p;
        System.out.println(P.p);
        System.out.println(P.t);
    }

}

class P{
    final static int p = 1;
    static int t = 2;
    static {
        System.out.println("load P");
    }

}