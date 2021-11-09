package com.lance.mybatisplus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: mybatisplus  DemoController
 * @description:
 * @author: flchen
 * @create: 2021-10-09 21:00
 **/

@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/test")
    public String testException(){

        return "{'message':'123'}";
    }

}
