package com.lance.mybatisplus.controller;

import com.lance.mybatisplus.service.SysUserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: mybatisplus  UserController
 * @description:
 * @author: flchen
 * @create: 2021-06-29 10:48
 **/

@RestController
public class UserController {
    @Autowired
    private SysUserService sysUserService;

    AtomicInteger i = new AtomicInteger(0);

    Num num = new Num();

    @GetMapping("/test")
    public void test() {
        MyThread myThread = new MyThread(num);
        Thread mt = new Thread(myThread);
        mt.start();
    }


}

@Data
class Num {
    int i = 0;
}

@Data
class MyThread implements Runnable {

    private Num num;

    MyThread(Num num) {
        this.num = num;
    }

    @Override
    public void run() {
        num.setI(num.getI() + 1);
        System.out.println(num.getI());
    }
}
