package com.lance.mybatisplus.base;

import java.util.concurrent.Callable;

/**
 * 启动类
 **/

public class Start {
    public static void main(String[] args) {
        Runnable runnable  = () -> {
            System.out.println(Thread.currentThread().getName());
        };
       Thread t = new Thread(runnable,"123");
       t.start();

       Callable callable = () -> {
          return "123";
       };
    }



}
