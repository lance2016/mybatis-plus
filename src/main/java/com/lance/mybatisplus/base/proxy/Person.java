package com.lance.mybatisplus.base.proxy;

import java.util.HashMap;

/**
 * @program: mybatisplus  Person
 * @description:
 * @author: flchen
 * @create: 2021-07-15 22:24
 **/

public interface Person {
    void saySomething();

    HashMap<String, String> map = new HashMap<>();

    void saySomething2();
}
