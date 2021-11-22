package com.lance.mybatisplus.controller;

import com.lance.mybatisplus.entity.Student;
import com.lance.mybatisplus.propertity.DataSourceProperty;
import com.lance.mybatisplus.utils.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: mybatisplus  DemoController
 * @description:
 * @author: flchen
 * @create: 2021-10-09 21:00
 **/
@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
public class DemoController {


    private final DataSourceProperty dataSourceProperty;


    private final Student student;

    @RequestMapping("/test")
    public String testException(){
        return "{'message':'12345'}"+"\n"+JsonUtil.toJson(student)+JsonUtil.toJson(dataSourceProperty);
    }

}
