package com.lance.mybatisplus.base.java8;

import java.util.Optional;

/**
 * @program: mybatisplus  OptionTest
 * @description:
 * @author: flchen
 * @create: 2021-07-05 11:52
 **/

public class OptionTest {
    public static void main(String[] args) {
        Integer value1 = null;
        Optional<Integer> option = Optional.ofNullable(value1);
        System.out.println(option.isPresent());
        System.out.println(option.orElse(0));
    }
}
